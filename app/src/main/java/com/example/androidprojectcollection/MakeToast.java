package com.example.androidprojectcollection;

import android.content.Context;
import android.widget.Toast;

public interface MakeToast {
    default void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
