package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class Midterm extends AppCompatActivity {
    int rand;
    ConstraintLayout con;
    ArrayList<Integer> container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midterm);
        Button btn[] = new Button[9];
        btn[0] = findViewById(R.id.btn1);
        btn[1] = findViewById(R.id.btn2);
        btn[2] = findViewById(R.id.btn3);
        btn[3] = findViewById(R.id.btn4);
        btn[4] = findViewById(R.id.btn5);
        btn[5] = findViewById(R.id.btn6);
        btn[6] = findViewById(R.id.btn7);
        btn[7] = findViewById(R.id.btn8);
        btn[8] = findViewById(R.id.btn9);
        Random random = new Random();
        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container = new ArrayList<Integer>();
                rand = random.nextInt(3 - 1 + 1) + 1;
                if (rand == 1)
                    btn[0].setBackgroundColor(getResources().getColor(R.color.black));
                if (rand == 2)
                    btn[0].setBackgroundColor(getResources().getColor(R.color.purple_200));
                if (rand == 3)
                    btn[0].setBackgroundColor(getResources().getColor(R.color.white));
                for (int i = 0; i < 9; i++) {
                    rand = random.nextInt(3 - 1 + 1) + 1;
                    if(i != 0 || !container.contains(i)){
                        if (rand == 1)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.black));
                        if (rand == 2)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.purple_200));
                        if (rand == 3)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.white));
                        container.add(i);
                    }
                }
                container.add(0);
            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container = new ArrayList<Integer>();
                rand = random.nextInt(3 - 1 + 1) + 1;
                if (rand == 1)
                    btn[1].setBackgroundColor(getResources().getColor(R.color.black));
                if (rand == 2)
                    btn[1].setBackgroundColor(getResources().getColor(R.color.purple_200));
                if (rand == 3)
                    btn[1].setBackgroundColor(getResources().getColor(R.color.white));
                for (int i = 0; i < 9; i++) {
                    rand = random.nextInt(3 - 1 + 1) + 1;
                    if(i != 1 || !container.contains(i)){
                        if (rand == 1)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.black));
                        if (rand == 2)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.purple_200));
                        if (rand == 3)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.white));
                        container.add(i);
                    }
                }
                container.add(1);
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container = new ArrayList<Integer>();
                rand = random.nextInt(3 - 1 + 1) + 1;
                if (rand == 1)
                    btn[2].setBackgroundColor(getResources().getColor(R.color.black));
                if (rand == 2)
                    btn[2].setBackgroundColor(getResources().getColor(R.color.purple_200));
                if (rand == 3)
                    btn[2].setBackgroundColor(getResources().getColor(R.color.white));
                for (int i = 0; i < 9; i++) {
                    rand = random.nextInt(3 - 1 + 1) + 1;
                    if(i != 2  || !container.contains(i)){
                        if (rand == 1)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.black));
                        if (rand == 2)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.purple_200));
                        if (rand == 3)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.white));
                        container.add(i);
                    }
                }
                container.add(2);
            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container = new ArrayList<Integer>();
                rand = random.nextInt(3 - 1 + 1) + 1;
                if (rand == 1)
                    btn[3].setBackgroundColor(getResources().getColor(R.color.black));
                if (rand == 2)
                    btn[3].setBackgroundColor(getResources().getColor(R.color.purple_200));
                if (rand == 3)
                    btn[3].setBackgroundColor(getResources().getColor(R.color.white));
                for (int i = 0; i < 9; i++) {
                    rand = random.nextInt(3 - 1 + 1) + 1;
                    if(i != 3  || !container.contains(i)){
                        if (rand == 1)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.black));
                        if (rand == 2)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.purple_200));
                        if (rand == 3)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.white));
                        container.add(i);
                    }
                }
                container.add(3);
            }
        });
        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container = new ArrayList<Integer>();
                rand = random.nextInt(3 - 1 + 1) + 1;
                if (rand == 1)
                    btn[4].setBackgroundColor(getResources().getColor(R.color.black));
                if (rand == 2)
                    btn[4].setBackgroundColor(getResources().getColor(R.color.purple_200));
                if (rand == 3)
                    btn[4].setBackgroundColor(getResources().getColor(R.color.white));
                for (int i = 0; i < 9; i++) {
                    rand = random.nextInt(3 - 1 + 1) + 1;
                    if(i != 4  || !container.contains(i)){
                        if (rand == 1)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.black));
                        if (rand == 2)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.purple_200));
                        if (rand == 3)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.white));
                        container.add(i);
                    }
                }

                container.add(4);
            }
        });
        btn[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container = new ArrayList<Integer>();
                rand = random.nextInt(3 - 1 + 1) + 1;
                if (rand == 1)
                    btn[5].setBackgroundColor(getResources().getColor(R.color.black));
                if (rand == 2)
                    btn[5].setBackgroundColor(getResources().getColor(R.color.purple_200));
                if (rand == 3)
                    btn[5].setBackgroundColor(getResources().getColor(R.color.white));
                for (int i = 0; i < 9; i++) {
                    rand = random.nextInt(3 - 1 + 1) + 1;
                    if(i != 5  || !container.contains(i)){
                        if (rand == 1)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.black));
                        if (rand == 2)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.purple_200));
                        if (rand == 3)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.white));
                        container.add(i);
                    }
                }
                container.add(5);
            }
        });
        btn[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container = new ArrayList<Integer>();
                rand = random.nextInt(3 - 1 + 1) + 1;
                if (rand == 1)
                    btn[6].setBackgroundColor(getResources().getColor(R.color.black));
                if (rand == 2)
                    btn[6].setBackgroundColor(getResources().getColor(R.color.purple_200));
                if (rand == 3)
                    btn[6].setBackgroundColor(getResources().getColor(R.color.white));
                for (int i = 0; i < 9; i++) {
                    rand = random.nextInt(3 - 1 + 1) + 1;
                    if(i != 6  || !container.contains(i)){
                        if (rand == 1)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.black));
                        if (rand == 2)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.purple_200));
                        if (rand == 3)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.white));
                        container.add(i);
                    }
                }
                container.add(6);
            }
        });
        btn[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container = new ArrayList<Integer>();
                rand = random.nextInt(3 - 1 + 1) + 1;
                if (rand == 1)
                    btn[7].setBackgroundColor(getResources().getColor(R.color.black));
                if (rand == 2)
                    btn[7].setBackgroundColor(getResources().getColor(R.color.purple_200));
                if (rand == 3)
                    btn[7].setBackgroundColor(getResources().getColor(R.color.white));
                for (int i = 0; i < 9; i++) {
                    rand = random.nextInt(3 - 1 + 1) + 1;
                    if(i != 7  || !container.contains(i)){
                        if (rand == 1)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.black));
                        if (rand == 2)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.purple_200));
                        if (rand == 3)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.white));
                        container.add(i);
                    }
                }
                container.add(7);
            }
        });
        btn[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container = new ArrayList<Integer>();
                rand = random.nextInt(3 - 1 + 1) + 1;
                if (rand == 1)
                    btn[8].setBackgroundColor(getResources().getColor(R.color.black));
                if (rand == 2)
                    btn[8].setBackgroundColor(getResources().getColor(R.color.purple_200));
                if (rand == 3)
                    btn[8].setBackgroundColor(getResources().getColor(R.color.white));
                for (int i = 0; i < 9; i++) {
                    rand = random.nextInt(3 - 1 + 1) + 1;
                    if(i != 8  || !container.contains(i)){
                        if (rand == 1)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.black));
                        if (rand == 2)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.purple_200));
                        if (rand == 3)
                            btn[i].setBackgroundColor(getResources().getColor(R.color.white));
                        container.add(i);
                    }
                }
                container.add(8);
            }
        });
    }
}