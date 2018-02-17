package com.sohretoglu.arda.landmark;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class activityDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView textView = (TextView) findViewById(R.id.textView);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        textView.setText(name);
        Globals globals = Globals.getInstance();
        Bitmap bitmap = globals.getData();

        imageView.setImageBitmap(bitmap);


    }
}
