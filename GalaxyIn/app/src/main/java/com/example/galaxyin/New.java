package com.example.galaxyin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;

public class New extends AppCompatActivity {

    EditText email,password,confirmPass;
    Button back;
    Button createNew;

    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        email=findViewById(R.id.email);
        password=findViewById(R.id.pass);
        confirmPass=findViewById(R.id.confirm_pass);

        createNew=findViewById(R.id.Btn_Signin);
        back=findViewById(R.id.Btn_Back);

        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");

        createNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString()!=null)
                {
                    if (password.getText().toString().equals(confirmPass.getText().toString()))
                    {

                            member.setEmail(email.getText().toString().trim());
                            member.setPassword(password.getText().toString().trim());
                            reff.push().setValue(member);
                            Toast.makeText(New.this, "Account Created Successfully", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(New.this, "Invalid Input", Toast.LENGTH_LONG).show();
                    }


                }
                else
                {
                    Toast.makeText(New.this, "Invalid Input", Toast.LENGTH_LONG).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(New.this,LoginScreen.class);
                startActivity(intent);
            }
        });

    }
}