package com.example.greenearth;

import androidx.appcompat.app.AppCompatActivity;


import java.sql.*;
import android.content.Intent;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.switchmaterial.SwitchMaterial;


public class Login extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    EditText un;
   EditText pw;
    Button lg;
     SwitchMaterial sw;


    Connection conn;

    PreparedStatement prep = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the activity to full screen
        getWindow().setDecorFitsSystemWindows(false);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        setContentView(R.layout.activity_login);


lg = findViewById(R.id.login);
lg.setOnClickListener(this);

sw=findViewById(R.id.switch2);
sw.setOnCheckedChangeListener(this);


un = findViewById(R.id.username);
pw = findViewById(R.id.password);

    }

    public void no_account(View v) {

        Toast toast = Toast.makeText(this, "wait", Toast.LENGTH_SHORT);
                toast.show();
        Intent myintent = new Intent(v.getContext(), Create_Account.class);
        startActivity(myintent);
    }



    public void reset_pass (View v) {

        Toast.makeText(Login.this, "please wait....", Toast.LENGTH_SHORT).show();

        Intent myintent = new Intent(v.getContext(), reset_password.class);
        startActivity(myintent);

    }



    public void face (View v) {

        Toast.makeText(Login.this, "please wait....", Toast.LENGTH_SHORT).show();

    }

    public void ggl (View v) {

        Toast.makeText(Login.this, "please wait....", Toast.LENGTH_SHORT).show();

    }




    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked){
            pw.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }
        else {
            pw.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }

    }

    //TODO: database connection and input verification

    @Override
    public void onClick(View v) {
        int j = v.getId();

        if (j == R.id.login) {

            if (un.getText().toString().isEmpty() && pw.getText().toString().isEmpty()) {

                Toast.makeText(Login.this, "please fill in all fields", Toast.LENGTH_LONG).show();
            } else {

                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
                    System.out.println("connected to database");

                    String username = un.getText().toString();
                    String password = pw.getText().toString();


                    String verify = "SELECT Username, Password FROM  login WHERE Username=? AND  Password=?";
                    prep = conn.prepareStatement(verify);
                    prep.setString(1, username);
                    prep.setString(2, password);

                    ResultSet rs = prep.executeQuery();
                    if (rs.next()) {

                       Snackbar.make(findViewById(R.id.cards),"Welcome",Snackbar.LENGTH_LONG).show();

                        Intent m = new Intent(v.getContext(), calculator.class);
                        startActivity(m);

                    }

                }

                catch(Exception err){
                    System.out.println("Error connecting. database not found");
                    Toast.makeText(Login.this,"Error sending details to database",Toast.LENGTH_LONG).show();
                }

            }

        }


    }
}
