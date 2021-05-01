package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    EditText text_username_1,  text_password_2;
    Button button_login,button_signup;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        text_username_1 = (EditText)findViewById(R.id.txt_username_1);
        text_password_2 = (EditText)findViewById(R.id.txt_password_2);
        button_login = (Button)findViewById(R.id.btn_login);
        button_signup = (Button)findViewById(R.id.btn_signup);
        DB = new DBHelper (this);


        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);



            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            private boolean checkuserpass;

            @Override
            public void onClick(View view) {
                String user = text_username_1.getText().toString();
                String pass = text_password_2.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LogIn.this, "The username or the Password field are answered", Toast.LENGTH_SHORT).show();
                else(
                    Boolean checkuserpass = DB.checkusernamepassowrd(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(LogIn.this, "LogIn Successful", Toast.LENGTH_SHORT).show();
                    }else(
                            Toast.makeText(LogIn.this, "LogIn Failed", Toast.LENGTH_SHORT).show();


                            )




                        )


            }
        });






    }
}