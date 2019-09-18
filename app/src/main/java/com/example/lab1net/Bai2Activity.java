package com.example.lab1net;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;

public class Bai2Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgAn;
    private TextView tvMess;
    private Button btnTai;
    private ProgressDialog progressDialog;
    private Bitmap bitmap = null;
    private String link = "https://i635.photobucket.com/albums/uu71/namusan/IMG_0237.jpg~original";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        imgAn = (ImageView) findViewById(R.id.imgAn);
        tvMess = (TextView) findViewById(R.id.tvMess);
        btnTai = (Button) findViewById(R.id.btnTai);
        btnTai.setOnClickListener(this);
    }

    // show dialog
    private Handler messageHandler = new Handler(){
        public  void handleMessage(Message message){
            super.handleMessage(message);
            Bundle bundle = message.getData();
            String mess = bundle.getString("message");
            tvMess.setText(mess);
            imgAn.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };


    @Override
    public void onClick(View view) {
        progressDialog = ProgressDialog.show(Bai2Activity.this,"",  "Downloading...");
        Runnable aRunnable = new Runnable() {
            @Override
            public void run() {
                bitmap = downloadBitmap(link);
                Message message = messageHandler.obtainMessage();
                Bundle bundle = new Bundle();
                String threadMess = "Image Downloaded";
                bundle.putString("message", threadMess);
                message.setData(bundle);
                messageHandler.sendMessage(message);
            }
        };
        Thread aThread = new Thread((aRunnable));
        aThread.start();
    }

    private Bitmap downloadBitmap(String link){
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
