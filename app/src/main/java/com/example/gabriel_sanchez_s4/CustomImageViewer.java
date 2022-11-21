package com.example.gabriel_sanchez_s4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomImageViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_image_viewer);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView img = (ImageView)findViewById(R.id.fullWidthImage);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView = (TextView)findViewById(R.id.tvName);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tvRaceWoned = (TextView)findViewById(R.id.tvRaceWoned);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b!=null){
            img.setImageResource(b.getInt("IMG"));
            textView.setText(b.getString("NAME"));
            String raceWoned = "Carreras ganadas " + b.getInt("RACEWONED");
            tvRaceWoned.setText(raceWoned);
        }
    }
}