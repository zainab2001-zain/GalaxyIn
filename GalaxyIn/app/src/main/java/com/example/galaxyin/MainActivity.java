package com.example.galaxyin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //variables
    Animation topAnimation ,bottomAnimation;
    ImageView image;
    TextView heading, description;
    private int Splash_screen=5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        //Animation
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Hooks
        image=findViewById(R.id.logoimage);
        heading=findViewById(R.id.heading_welcomescreen);
        description=findViewById(R.id.dexcription_welcomescreen);
        image.setAnimation(topAnimation);
        heading.setAnimation(bottomAnimation);
        description.setAnimation(bottomAnimation);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                //Call next screen
                Intent intent=new Intent(MainActivity.this,LoginScreen.class);
                // Attach all the elements those you want to animate in design
                Pair[]pairs=new Pair[2];
                pairs[0]=new Pair<View, String>(image,"imagelogo");
                pairs[1]=new Pair<View, String>(description,"textlogo");
                //wrap the call in API level 21 or higher
                if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.LOLLIPOP)
                {
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                    startActivity(intent,options.toBundle());
                }

            }
        },Splash_screen);
}
}