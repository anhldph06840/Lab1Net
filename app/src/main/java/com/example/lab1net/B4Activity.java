package com.example.lab1net;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class B4Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtTime;
    private Button btnRun;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b4);



        edtTime = (EditText) findViewById(R.id.edtTime);
        btnRun = (Button) findViewById(R.id.btnRun);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnRun.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.btnRun:

        AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(this,tvResult,edtTime);
        String sleepTime = edtTime.getText().toString();
        asyncTaskRunner.execute(sleepTime);
         break;
       }
    }
}
