package com.example.greenearth;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.sql.*;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class Create_Account extends AppCompatActivity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener  {

    ImageButton ib;

    SwitchMaterial sw;


    EditText full_name;
    EditText username;
    EditText password;
    EditText confirm_password;
    EditText email;

    Connection cr;
    PreparedStatement PS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Set the activity to full screen
        getWindow().setDecorFitsSystemWindows(false);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        ib =  findViewById(R.id.goback);
        ib.setOnClickListener(this);

        full_name=findViewById(R.id.full_user);
        username=findViewById(R.id.user);
        password=  findViewById(R.id.pw);
        confirm_password=findViewById(R.id.pw2);
        email=findViewById(R.id.email);



        sw=findViewById(R.id.switch2);
        sw.setOnCheckedChangeListener(this);

    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked) {
            password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            confirm_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        } else {
            password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            confirm_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    public void fb(View v){

        Toast.makeText(Create_Account.this,"wait",Toast.LENGTH_SHORT).show();
    }

    public void gogl(View v){

        Toast.makeText(Create_Account.this,"wait",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.goback) {

            Intent m = new Intent(v.getContext(), Login.class);
            startActivity(m);


        } else if (id == R.id.sign_up) {


            if (full_name.getText().toString().isEmpty() && username.getText().toString().isEmpty() && password.getText().toString().isEmpty() && confirm_password.getText().toString().isEmpty() && email.getText().toString().isEmpty()){

                Toast.makeText(getApplicationContext(), "please fill in all fields", Toast.LENGTH_LONG).show();
            }

            else if (!password.equals(confirm_password)) {

                Toast.makeText(getApplicationContext(), "passwords do not match", Toast.LENGTH_LONG).show();

            }

            else {
                   try {
                       Class.forName("com.mysql.cj.jdbc.Driver");
                       cr=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
                       System.out.println("connected to database");

                       String Fullname=full_name.getText().toString();
                       String Username=username.getText().toString();
                       String Password=password.getText().toString();
                       String Confrimation=confirm_password.getText().toString();
                       String Email=email.getText().toString();

                       String verify="Insert into login (Fullname, Username, Password, Email)  values (?,?,?,?)";
                       PS=cr.prepareStatement(verify);
                       PS.setString(1,Fullname);
                       PS.setString(2,Username);
                       PS.setString(3,Password);
                       PS.setString(4,Confrimation);
                       PS.setString(5,Email);

                       int b = PS.executeUpdate();

                       if (b>0) {

                           Toast.makeText(Create_Account.this, "Account has been created successfully", Toast.LENGTH_LONG).show();
                                  Intent j = new Intent(v.getContext(), Login.class);
                                  startActivity(j);
                       }

                       else Toast.makeText(Create_Account.this, "An error occurred please Try again", Toast.LENGTH_LONG ).show();
                   }


                   catch (Exception err){

                        System.out.println("unable to connect to the database");
                        Toast.makeText(Create_Account.this,"Error sending details to database",Toast.LENGTH_LONG).show();

                       }




            }

        }
    }
}