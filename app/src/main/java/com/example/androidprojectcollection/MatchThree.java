package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidprojectcollection.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MatchThree extends AppCompatActivity implements View.OnClickListener, MakeToast {
    ArrayList<Button> twoView = new ArrayList<>();
    ArrayList<Integer> twoColor = new ArrayList<>();
    Button btnArray[][];
    int colorArray[][] = new int[5][5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_three);
        btnArray = new Button[5][5];

        // Initialize buttons in the array by finding them with findViewById
        btnArray[0][0] = findViewById(R.id.btn1);
        btnArray[0][1] = findViewById(R.id.btn2);
        btnArray[0][2] = findViewById(R.id.btn3);
        btnArray[0][3] = findViewById(R.id.btn4);
        btnArray[0][4] = findViewById(R.id.btn5);
        btnArray[1][0] = findViewById(R.id.btn6);
        btnArray[1][1] = findViewById(R.id.btn7);
        btnArray[1][2] = findViewById(R.id.btn8);
        btnArray[1][3] = findViewById(R.id.btn9);
        btnArray[1][4] = findViewById(R.id.btn10);
        btnArray[2][0] = findViewById(R.id.btn11);
        btnArray[2][1] = findViewById(R.id.btn12);
        btnArray[2][2] = findViewById(R.id.btn13);
        btnArray[2][3] = findViewById(R.id.btn14);
        btnArray[2][4] = findViewById(R.id.btn15);
        btnArray[3][0] = findViewById(R.id.btn16);
        btnArray[3][1] = findViewById(R.id.btn17);
        btnArray[3][2] = findViewById(R.id.btn18);
        btnArray[3][3] = findViewById(R.id.btn19);
        btnArray[3][4] = findViewById(R.id.btn20);
        btnArray[4][0] = findViewById(R.id.btn21);
        btnArray[4][1] = findViewById(R.id.btn22);
        btnArray[4][2] = findViewById(R.id.btn23);
        btnArray[4][3] = findViewById(R.id.btn24);
        btnArray[4][4] = findViewById(R.id.btn25);

        Random rand = new Random();
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                int color = rand.nextInt(3) + 1;
                if(color == 1){
                    btnArray[i][j].setBackgroundColor(Color.RED);
                    colorArray[i][j] = Color.RED;
                }
                else if(color == 2){
                    btnArray[i][j].setBackgroundColor(Color.BLACK);
                    colorArray[i][j] = Color.BLACK;
                }
                else if(color == 3){
                    btnArray[i][j].setBackgroundColor(Color.BLUE);
                    colorArray[i][j] = Color.BLUE;
                }
                else if(color == 4){
                    btnArray[i][j].setBackgroundColor(Color.RED);
                    colorArray[i][j] = Color.RED;
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(twoView.size() == 2){
            twoView.get(0).setBackgroundColor(twoColor.get(1));
            twoView.get(1).setBackgroundColor(twoColor.get(0));
            twoView.clear();
            twoColor.clear();
        }
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(v.getId() == btnArray[i][j].getId()){
                    twoView.add((Button) v);
                    twoColor.add(colorArray[i][j]);
                }
            }
        }
    }
}
