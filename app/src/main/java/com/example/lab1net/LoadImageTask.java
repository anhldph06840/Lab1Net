package com.example.lab1net;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.sip.SipSession;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class LoadImageTask extends AsyncTask<String, Void, Bitmap> {

    private Listener mListener;
    private ProgressDialog progressDialog;
    public LoadImageTask(Listener listener, Context context){
        mListener = listener;
        progressDialog = new ProgressDialog(context);
    }

    // xuwr ly hien thi dialog
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Downloading image..");
        progressDialog.show();
    }

    // load hinh tu server
    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            return BitmapFactory.decodeStream((InputStream)new URL(strings[0]).getContent());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    // dong dialog va set ket qua cho ham o interface

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        if(result != null){
            mListener.onImageLoaded(result);
        } else {
            mListener.onError();
        }
    }
}
