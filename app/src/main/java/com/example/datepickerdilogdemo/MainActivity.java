package com.example.datepickerdilogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

//   Project-1
    EditText editText;
    int y,m,d;
    String DOB;

//   Project-2
    ViewFlipper viewFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.etdate);

        Calendar calendar = Calendar.getInstance();

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                y = calendar.get(Calendar.YEAR);
                m = calendar.get(Calendar.MONTH);
                d = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        DOB = i2 + "/"+(i1+1)+"/"+i;
                        editText.setText(DOB);
                    }
                },y,m,d);

                datePickerDialog.show();

            }
        });

//       Project-2

        int imgarray[] = {R.drawable.boy1, R.drawable.girl1, R.drawable.boy2};
        viewFlipper = findViewById(R.id.flipper);

        for (int i = 0; i< imgarray.length; i++)
            showimage(imgarray[i]);
    }

    public void showimage(int img){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(img == R.drawable.boy1)
                    startActivity(new Intent(getApplicationContext(),boy1desc.class));

                if(img == R.drawable.boy2)
                    startActivity(new Intent(getApplicationContext(),boy2desc.class));

                if(img == R.drawable.girl1)
                    startActivity(new Intent(getApplicationContext(),girl1desc.class));

            }
        });


        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

}