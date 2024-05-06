package com.example.galaxyin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.zip.Inflater;

public class SliderAdapter extends PagerAdapter
{
    Context context;
    LayoutInflater layoutInflater;

    public int[] imageArray ={
            R.drawable.clean,
            R.drawable.comfort,
            R.drawable.staff,
            R.drawable.music,
            R.drawable.sound,
            R.drawable.resturant,
            R.drawable.firsttime,
            R.drawable.find,
            R.drawable.open,
            R.drawable.logo,
            R.drawable.service,
            R.drawable.foodplate,
            R.drawable.fr,
            R.drawable.family,
            R.drawable.hygiene,


    };
    public String[] titleArray={
            "Question Number 01",
            "Question Number 02",
            "Question Number 03",
            "Question Number 04",
            "Question Number 05",
            "Question Number 06",
            "Question Number 07",
            "Question Number 08",
            "Question Number 09",
            "Question Number 10",
            "Question Number 11",
            "Question Number 12",
            "Question Number 13",
            "Question Number 14",
            "Question Number 15"};

    public String[] descriptionArray={
            "Was the cleanliness of the restroom up to the mark?",
            "Were the seats at the restaurant comfortable?",
            "Was the restaurant staff supportive in everything?",
            "Was the volume of the music optimum?",
            "Did you like the music and sound quality?",
            "How did you get to know about our restaurant?",
            "When did you visit our restaurant for the first time?",
            "Is the place easily accessible?",
            "Are the timings of the restaurant convenient?",
            "Would you like to visit again to this restaurant?",
            "Did you face any issues with any service of the restaurant?",
            "Did the food arrive on time?",
            "Do you feel the services were welcoming and friendly?",
            "How likely would you recommend this restaurant to your family or friends?",
            "How would you rate the overall hygiene and cleanliness of the restaurant?",
    };
    public int[] backgroundArray={
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212),
            Color.rgb(23,33,233),

            Color.rgb(100,101,102),
            Color.rgb(200,201,202),
            Color.rgb(99,88,77),
            Color.rgb(66,44,55),
            Color.rgb(110,120,130),

            Color.rgb(210,211,212),
            Color.rgb(20,30,40),
            Color.rgb(10,49,4),
            Color.rgb(1,189,112),
            Color.rgb(13,33,133),

    };
    public  int[] EdittextArray;

    public SliderAdapter(Context context1){
        this.context=context1;
    }

    @Override
    public int getCount() {

        return titleArray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return (view==object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_slide, container, false);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
        ImageView imageView = (ImageView) view.findViewById(R.id.ImageView);
        TextView title = (TextView) view.findViewById(R.id.txtTitle);
        TextView description = (TextView) view.findViewById(R.id.txtDescription);
        EditText editText1 = (EditText) view.findViewById(R.id.Edt_txt);
        Button submit=(Button)view.findViewById(R.id.Btn_Submit);

        linearLayout.setBackgroundColor(backgroundArray[position]);
        imageView.setImageResource(imageArray[position]);
        title.setText(titleArray[position]);
        description.setText(descriptionArray[position]);
        editText1.setText(EdittextArray[position]);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<=EdittextArray.length; i=i+1)
                {
                    String Answer=editText1.getText().toString();
                    if(Answer.equals("   "))
                    {

                        CharSequence text = "Thanks for you Feed Back";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                    }
                    else
                    {
                        CharSequence text = "Answer All Questions";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }

                }
            }
        });


        container.addView(view);
        return view;
    }



}
