package com.example.lab1net;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class B3Activity extends AppCompatActivity implements View.OnClickListener,Listener {

    private ImageView imgLoad;
    private TextView tvMsg;
    private Button btnLo;
    public static final String IMAGE_URL = "https://cdn.shopify.com/s/files/1/1061/1924/files/Hugging_Face_Emoji_2028ce8b-c213-4d45-94aa-21e1a0842b4d_large.png?15202324258887420558";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b3);
        imgLoad = (ImageView) findViewById(R.id.imgLoad);
        tvMsg = (TextView) findViewById(R.id.tvMsg);
        btnLo = (Button) findViewById(R.id.btnLo);
        btnLo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnLo:
                new LoadImageTask(this,B3Activity.this).execute(IMAGE_URL);
                break;
        }
    }


    @Override
    public void onImageLoaded(Bitmap bitmap) {
        imgLoad.setImageBitmap(bitmap);
        tvMsg.setText("Image downloaded");
    }

    @Override
    public void onError() {
        tvMsg.setText("Error download image");
    }
}
