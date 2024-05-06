package com.example.galaxyin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginScreen extends AppCompatActivity {

    EditText Email, pass;
    Button loginbtn;
    Button signUp;


    // private FirebaseDatabase db=FirebaseDatabase.getInstance();
    //private DatabaseReference root=db.getReference();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_screen);

        Email = findViewById(R.id.email1);
        pass = findViewById(R.id.pass);
        loginbtn = findViewById(R.id.button_login);
        signUp = findViewById(R.id.button_signup);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (Email.getText().toString().equals("zainfarq2001@gmail.com") && pass.getText().toString().equals("1234"))
                {


                    Intent intent = new Intent(LoginScreen.this, SliderActivity.class);
                    startActivity(intent);
                    //finish();
                }
                else
                {
                    Toast.makeText(LoginScreen.this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this,New.class);
                intent.setFlags((Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NEW_TASK));
                startActivity(intent);
            }
        });
    }
}
