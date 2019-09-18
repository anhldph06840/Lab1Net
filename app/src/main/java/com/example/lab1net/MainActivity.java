package com.example.lab1net;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bai1(View view) {
        Intent intent = new Intent(this,Bai1Activity.class);
        this.startActivity(intent);

    }

    public void bai2(View view) {
        Intent intent = new Intent(MainActivity.this,SplashActivity.class);
        this.startActivity(intent);
    }

    public void bai3(View view) {
        Intent intent = new Intent(this,B3Activity.class);
        this.startActivity(intent);
    }

    public void bai4(View view) {
        Intent intent = new Intent(this,B4Activity.class);
        this.startActivity(intent);
    }
}
