package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    //creating variables

    String stname;
    RadioGroup rg1;
    RadioButton rbgraduated,rbungraduated;
    Spinner spcourse;
    EditText etfees,ethours;
    CheckBox cbaccomodation,cbmedical;
    Button btnadd,btnlogout;
    TextView tvname;

    //creating array if integer type
    int[] fees = {1300,1500, 1350, 1400,1000};
    int[] hours={6,5,5,7,4};

    //static variable i
    static int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //code to get intent values
        Intent act = getIntent();
        stname=act.getStringExtra("Name");

        // Display student name on title bar
        getSupportActionBar().setTitle(stname);



        //assign id into the variables
        rg1=findViewById(R.id.radiogroup1);
        rbgraduated=findViewById(R.id.graduated);
        rbungraduated=findViewById(R.id.ungraduated);

        tvname=findViewById(R.id.name);
        tvname.setText(stname);


        etfees=findViewById(R.id.fees);
        ethours=findViewById(R.id.hours);

        spcourse=findViewById(R.id.coursespinner);

        cbaccomodation=findViewById(R.id.accomodation);
        cbmedical=findViewById(R.id.medical);

        btnadd=findViewById(R.id.add);
        btnlogout=findViewById(R.id.logout);

        //creating List of courses
        List<String> course = new ArrayList<String>();
        course.add("Java");
        course.add("Swift");
        course.add("iOS");
        course.add("Android");
        course.add("Database");


        //create an adapter and fill it from the list
        ArrayAdapter<String> courseAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, course);


        //make the drop down style
        courseAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        //fill the spinner with the adapter items
        spcourse.setAdapter(courseAdapter);

        //creating listener of the spinner
        spcourse.setOnItemSelectedListener(this);

        //creating listener of the button
        btnadd.setOnClickListener(this);
        btnlogout.setOnClickListener(this);
        rg1.setOnCheckedChangeListener(this);
        cbmedical.setOnCheckedChangeListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        i=position;

        //getting fees and hours
        Integer f = new Integer(fees[i]);
        etfees.setText(f.toString());

        Integer h = new Integer(hours[i]);
        ethours.setText(h.toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.add :

                break;

                //logout button
            case R.id.logout:
                Intent act= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(act);
                break;
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }
}
