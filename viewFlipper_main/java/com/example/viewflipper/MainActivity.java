package com.example.viewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button btnStart, btnStop;
    ViewFlipper vFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart= (Button)findViewById(R.id.btnStart);
        btnStop = (Button)findViewById(R.id.btnStop);
        vFlipper = (ViewFlipper)findViewById(R.id.viewFlipper1);
        vFlipper.setFlipInterval(1000);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vFlipper.startFlipping();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.stopFlipping();
            }
        });


    }
}