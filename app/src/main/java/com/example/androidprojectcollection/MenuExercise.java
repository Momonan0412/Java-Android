package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MenuExercise extends AppCompatActivity implements MakeToast{
    Button btnCircleChange;
    int defaultTextColor;
    ColorStateList defaultTint;
    boolean isCircle = true;
    float windowCenterX, windowCenterY;
    GradientDrawable drawable;
    float cornerRadiusPixels;
    RotateAnimation rotateAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);
        btnCircleChange = findViewById(R.id.btnChangeMe);
        defaultTextColor = btnCircleChange.getCurrentTextColor();
        defaultTint = btnCircleChange.getBackgroundTintList();
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        int displayWidth = display.getWidth();
        int displayHeight = display.getHeight();
        windowCenterX = displayWidth / 2;
        windowCenterY = displayHeight / 2;
        drawable = new GradientDrawable();

        rotateAnimation = new RotateAnimation(
                0,
                360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setInterpolator(getApplicationContext(), android.R.anim.accelerate_decelerate_interpolator);

        // Convert dp to pixels
        float cornerRadiusDp = 300;
        cornerRadiusPixels = dpToPixels(cornerRadiusDp);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menuexercise, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.mItemChange) {
            showToast(this, "Edit Object Item is clicked");
            btnCircleChange.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
            btnCircleChange.setTextColor(Color.WHITE);
            int randomSize = new Random().nextInt(600) + 300;
            btnCircleChange.getLayoutParams().width = randomSize;
            btnCircleChange.getLayoutParams().height = randomSize;
            btnCircleChange.requestLayout();
        } else if (item.getItemId() == R.id.mItemReset) {
            showToast(this, "Reset Object Item is clicked");
            btnCircleChange.setBackgroundTintList(defaultTint);
            btnCircleChange.setTextColor(defaultTextColor);
            btnCircleChange.getLayoutParams().width = (int) dpToPixels(412);
            btnCircleChange.getLayoutParams().height = (int) dpToPixels(431);
            btnCircleChange.setX(windowCenterX - dpToPixels(412) /2);
            btnCircleChange.setY(windowCenterY -  dpToPixels(431) / 2);
            drawable.setCornerRadius(cornerRadiusPixels);
            btnCircleChange.setBackground(drawable);
            btnCircleChange.requestLayout();

        } else if (item.getItemId() == R.id.mItemExit) {
            finish();
        } else if (item.getItemId() == R.id.rRadius) {
            drawable.setCornerRadius(0);
            btnCircleChange.setBackground(drawable);
        } else if (item.getItemId() == R.id.mRandomColor) {
            btnCircleChange.setBackgroundTintList(ColorStateList.valueOf(getRandomColor()));
        } else if (item.getItemId() == R.id.mSpin) {
            btnCircleChange.startAnimation(rotateAnimation);
        }  else if (item.getItemId() == R.id.mStop) {
            rotateAnimation.cancel();
        }
        return true;
    }

    // Method to convert dp to pixels
    private float dpToPixels(float dp) {
        return dp * Resources.getSystem().getDisplayMetrics().density;
    }


    // Method to generate a random color
    private int getRandomColor() {
        Random random = new Random();
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}