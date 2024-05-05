package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidprojectcollection.Calculator.CalculatorExercise;
import com.example.androidprojectcollection.GenshinCrush.GenshinCrush;

import java.util.Random;

public class LayoutExercise extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btnjinshin, btnMiterm, btnPassIntent, btnMenu, btnOpeningMaps;
    Boolean iscolor = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_exercise);
        btn1 = findViewById(R.id.btnLayout);
        btn2 = findViewById(R.id.btnButtonHide);
        btn3 = findViewById(R.id.btnToastMe);
        btn4 = findViewById(R.id.btnExit);
        btn5 = findViewById(R.id.btnChangeBG);
        btn6 = findViewById(R.id.btnChangeThis);
        btn7 = findViewById(R.id.btnCalc);
        btnjinshin = findViewById(R.id.buttonJinshin);
        btnMiterm = findViewById(R.id.btnMidterm);
        ConstraintLayout constraintLayout = findViewById(R.id.clChangeColor);
        btnPassIntent = findViewById(R.id.btnPassIntent);
        btnMenu = findViewById(R.id.btnMenu);
        btnOpeningMaps = findViewById(R.id.btnOpeningMaps);
        btnOpeningMaps.setOnClickListener((view)->{
            Intent intent = new Intent(LayoutExercise.this, MapsActivity.class);
            startActivity(intent);
        });
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(LayoutExercise.this, MenuExercise.class);
                startActivity(intent4);
            }
        });
        btnPassIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(LayoutExercise.this, PassingIntentsExercise.class);
                startActivity(intent3);
            }
        });
        btnMiterm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(LayoutExercise.this, Midterm.class);

                startActivity(intent2);
            }
        });
        btnjinshin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(LayoutExercise.this, GenshinCrush.class);

                startActivity(intent2);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LayoutExercise.this, MainActivity.class);

                startActivity(intent1);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LayoutExercise.this, MainActivity.class);

                startActivity(intent1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2.setVisibility(view.GONE);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LayoutExercise.this, "Furina C2!", Toast.LENGTH_SHORT).show();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutExercise.this.finish();
                finish();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iscolor)
                {
                    Random color = new Random();
                    constraintLayout.setBackgroundColor(Color.argb(255, color.nextInt(255), color.nextInt(255), color.nextInt(255)));
                    iscolor = false;
                }
                else
                {
                    constraintLayout.setBackgroundColor(Color.WHITE);
                    iscolor = true;
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random color = new Random();
                btn6.setBackgroundColor(Color.argb(255, color.nextInt(255), color.nextInt(255), color.nextInt(255)));

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(LayoutExercise.this, CalculatorExercise.class);
                startActivity(intent1);
            }
        });
    }
}