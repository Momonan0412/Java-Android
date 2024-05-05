package com.example.androidprojectcollection;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MapsActivity extends AppCompatActivity {
    /**
     * 35.69590782020794, 139.70065451904574 Zepp Shinjuku
     * 35.664216392428465, 139.6985581766755 Line Cube Shibuya
     * 34.68734970394744, 135.52586532567258 - Osaka Castle
     * 35.78038978623823, 139.69157810960232 - Shinjuku Gyoen National Garden
     * 35.7839638465182, 139.75197087532456 - Imperial Palace
     * **/
    Drawable[] drawables;
    Uri[] uri;
    ImageView imgNextLocation;
    ConstraintLayout clBackgroundMap;
    int index;
    Drawable background;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        index = 0;
        imgNextLocation = findViewById(R.id.imgNextLocation);
        clBackgroundMap = findViewById(R.id.clBackgroundMap);
        drawables  = new Drawable[]{
                getResources().getDrawable(R.drawable.zepp_shinjuku),
                getResources().getDrawable(R.drawable.line_cube_shibuya),
                getResources().getDrawable(R.drawable.osaka_castle),
                getResources().getDrawable(R.drawable.shinjuku_gyoen_national_garden),
                getResources().getDrawable(R.drawable.imperial_palace)
        };
        uri = new Uri[]{
                Uri.parse("geo:35.69590782020794,139.70065451904574?z=16"),
                Uri.parse("geo:35.664216392428465,139.6985581766755?z=16"),
                Uri.parse("geo:34.68734970394744,135.52586532567258?z=16"),
                Uri.parse("geo:35.78038978623823,139.69157810960232?z=16"),
                Uri.parse("geo:35.7839638465182,139.75197087532456?z=16")
        };
        imgNextLocation.setImageDrawable(drawables[index]);
        if(background != null){
            clBackgroundMap.setBackground(background);
        }
    }

    public void nextLocation(View view) {
        background = imgNextLocation.getDrawable();
        Intent intent = new Intent(Intent.ACTION_VIEW, uri[index]);
        startActivity(intent);
        index = (index + 1) % drawables.length;
        imgNextLocation.setImageDrawable(drawables[index]);
        clBackgroundMap.setBackground(background); // Update background here
    }
}