package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //creating variables

    EditText etusername,etpassword,etstudentname;
    Button btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign id into the variables

        etusername=findViewById(R.id.username);
        etpassword=findViewById(R.id.password);
        etstudentname=findViewById(R.id.studentname);

        btnlogin=findViewById(R.id.login);

        //creating listener of the button

        btnlogin.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        //checks wheather the username , password is correct or not and checks student name is empty or not

        if(etusername.getText().toString().equals("student1")&&etpassword.getText().toString().equals("123456")&&!etstudentname.getText().toString().equals(""))
        {
            // creating an intent to let the user goes to the another page

            Intent act= new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(act);

            //code to take the student name to another page
            String name = etstudentname.getText().toString();
            act.putExtra("Name",name);
            startActivity(act);

        }

        // if username and password is incorrect and student name is empty then shows message

        else
        {
            Toast.makeText(getApplicationContext(), "Invalid  Username or Password”", Toast.LENGTH_SHORT).show();
        }
    }
}
