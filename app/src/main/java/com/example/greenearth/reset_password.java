package com.example.greenearth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.sql.*;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class reset_password extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {


    Button lg;
    ImageButton mg;

    SwitchMaterial sw;

    EditText UN;
    EditText p2;


    PreparedStatement preparedStatement;
    Connection connection;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Set the activity to full screen
        getWindow().setDecorFitsSystemWindows(false);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reset_password);

        lg = findViewById(R.id.change);
        lg.setOnClickListener(this);

        UN = findViewById(R.id.username);

        p2 = findViewById(R.id.newpass);

        sw = findViewById(R.id.switch2);
        sw.setOnCheckedChangeListener(this);

        mg = findViewById(R.id.goback);
        mg.setOnClickListener(this);


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked) {
            p2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

        } else {
            p2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        }
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.goback) {

            Intent m = new Intent(v.getContext(), Login.class);
            startActivity(m);

        } else if (id == R.id.change) {


            if (UN.getText().toString().isEmpty()  && p2.getText().toString().isEmpty()) {

                Toast.makeText(reset_password.this, "please fill in all fields", Toast.LENGTH_LONG).show();
            }
        }
                else {

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                         System.out.println("Connected to database");

                         String Username = UN.getText().toString();
                         String Newpassword = p2.getText().toString();

                         String pass = "update login set  Password=? where Username =?";


                         preparedStatement=connection.prepareStatement(pass);
                         preparedStatement.setString(1,Username);
                         preparedStatement.setString(2,Newpassword);



                    }
                    catch (Exception err){

                        System.out.println("unable to connect to database");
                        Toast.makeText(reset_password.this,"Error sending details to database",Toast.LENGTH_LONG).show();
                    }




                }

            }
        }


