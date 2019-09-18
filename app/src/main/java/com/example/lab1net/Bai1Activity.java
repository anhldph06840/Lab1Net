package com.example.lab1net;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class Bai1Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgAndroid;
    private TextView tvMessage;
    private Button btnLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);



        imgAndroid = (ImageView) findViewById(R.id.imgAndroid);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        btnLoad = (Button) findViewById(R.id.btnLoad);

        btnLoad.setOnClickListener(this);
    }

    private Bitmap loadImageFromNetWork(String link){

        URL url;
        Bitmap bmp =null;
        try{

            url = new URL(link);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }

        return bmp;
    }

    @Override
    public void onClick(View view) {

        final Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {

                final Bitmap bitmap = loadImageFromNetWork("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuVeqImUcFwHpbb0l5G15BDhT0gwNWfwFYbZYRBV2cGOBDoHBlAA");
                imgAndroid.post(new Runnable() {
                    @Override
                    public void run() {

                        tvMessage.setText("ImageDownloaded");
                        imgAndroid.setImageBitmap(bitmap);
                    }
                });
            }
        });
        myThread.start();
    }
}
