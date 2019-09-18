package com.example.lab1net;

import android.graphics.Bitmap;

public interface Listener {
    void onImageLoaded(Bitmap bitmap);
    void onError();
}
