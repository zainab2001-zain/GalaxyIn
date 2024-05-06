package com.example.galaxyin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SliderActivity extends AppCompatActivity {

    ViewPager viewPager;
    SliderAdapter sliderAdapter;
    ImageView out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);


            viewPager = (ViewPager) findViewById(R.id.ViewPager);
            sliderAdapter = new SliderAdapter(this);
            viewPager.setAdapter(sliderAdapter);

            out=(ImageView) findViewById(R.id.Exit);
            out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SliderActivity.this,"Logout Account",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(SliderActivity.this,LoginScreen.class);
                startActivity(intent);
            }
        });


    }
}