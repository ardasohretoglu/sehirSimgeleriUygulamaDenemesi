package com.sohretoglu.arda.landmark;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        final ArrayList<String> sehirSimgeleri = new ArrayList<String>();
        sehirSimgeleri.add("Pisa");
        sehirSimgeleri.add("Colleseo");
        sehirSimgeleri.add("Eiffel");
        sehirSimgeleri.add("London Bridge");

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.eiffel);
        Bitmap cloliseum = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.cloliseum);
        Bitmap londonbridge = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.londonbridge);

        final ArrayList<Bitmap> arrayImages = new ArrayList<>();
        arrayImages.add(pisa);
        arrayImages.add(cloliseum);
        arrayImages.add(eiffel);
        arrayImages.add(londonbridge);



        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sehirSimgeleri);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(getApplicationContext(),activityDetail.class);
                intent.putExtra("name",sehirSimgeleri.get(position));


                Bitmap bitmap = arrayImages.get(position);

                Globals globals = Globals.getInstance();
                globals.setData(bitmap);




                startActivity(intent);
            }
        });

    }
}
