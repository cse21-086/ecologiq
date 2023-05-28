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


import com.google.android.material.switchmaterial.SwitchMaterial;

public class Create_Account extends AppCompatActivity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener  {

    ImageButton ib;

    SwitchMaterial sw;
    EditText full_name;
    EditText username;
    EditText password;
    EditText confirm_password;
    EditText email;

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

    public void proceed(View v){

        String fn = full_name.getText().toString();
        String un = username.getText().toString();
        String ps = password.getText().toString();
        String em = email.getText().toString();
        String cp = confirm_password.getText().toString();


        if (fn.isEmpty() || un.isEmpty() || ps.isEmpty() || em.isEmpty()){

            Toast.makeText(Create_Account.this, "please fill in all fields", Toast.LENGTH_LONG).show();
        }
        else if (!ps.equals(cp)) {

            Toast.makeText(Create_Account.this, "passwords do not match", Toast.LENGTH_LONG).show();

        }

        else {

            sql_helper sq = new sql_helper(Create_Account.this);

            sq.adduser(full_name.getText().toString(), username.getText().toString(),
                    password.getText().toString(), email.getText().toString().trim());

        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.goback) {

            Intent m = new Intent(v.getContext(), Login.class);
            startActivity(m);


        }

    }
}