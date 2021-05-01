package com.example.app1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText text_username,text_password,text_retype_password;
    Button button_register,button_goback;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_username = (EditText)findViewById(R.id.txt_username);
        text_password = (EditText)findViewById(R.id.txt_password);
        text_retype_password = (EditText)findViewById(R.id.txt_retype_password);
        button_register = (Button)findViewById(R.id.btn_register);
        button_goback = (Button)findViewById(R.id.btn_goback);
        DB - new DBHelper(this);

        button_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String user = text_username.getText().toString();
                String pass = text_password.getText().toString();
                String repass = text_retype_password.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(MainActivity.this, "Not all fields are answered", Toast.LENGTH_SHORT) .show():
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);

                        if(checkuser==false){
                            Boolean insert = DB.inserData(user,pass);
                            Toast.makeText(MainActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        }else(
                                Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();

                                )
                    }else(
                            Toast.makeText(MainActivity.this, "Username is already used", Toast.LENGTH_SHORT).show();


                            )
                        button_goback.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getApplicationContext(),LogIn.class);
                            }
                        });




                    }
                )







            }
        }














        )


    }
}