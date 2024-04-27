package com.example.androidprojectcollection.Calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidprojectcollection.R;
import com.google.android.material.button.MaterialButton;

public class CalculatorExercise extends AppCompatActivity{

    String data = "";
    TextView TextView1, TextView2;
    MaterialButton[] btn = new MaterialButton[10];
    MaterialButton  btnAdd,  btnSub,  btnDiv,  btnMul,  btnEqual;
    MaterialButton  btnClear, btnAllClear, btnOpen, btnClose, btnDot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);

        TextView1 = findViewById(R.id.solutionView);
        TextView2 = findViewById(R.id.resultView);
        OnClickHandler onClickHandler = new OnClickHandler(data, new Calculator(), this);
        initializedViewObjects(onClickHandler);
        onClickHandler.setTextView1(TextView1);
        onClickHandler.setTextView2(TextView2);
    }
    private void initializedViewObjects(OnClickHandler onClickHandler){
        onClickHandler.assignView(btn[0],R.id.btn_0);
        onClickHandler.assignView(btn[1],R.id.btn_1);
        onClickHandler.assignView(btn[2],R.id.btn_2);
        onClickHandler.assignView(btn[3],R.id.btn_3);
        onClickHandler.assignView(btn[4],R.id.btn_4);
        onClickHandler.assignView(btn[5],R.id.btn_5);
        onClickHandler.assignView(btn[6],R.id.btn_6);
        onClickHandler.assignView(btn[7],R.id.btn_7);
        onClickHandler.assignView(btn[8],R.id.btn_8);
        onClickHandler.assignView(btn[9],R.id.btn_9);
        onClickHandler.assignView(btnAdd,R.id.btn_add);
        onClickHandler.assignView(btnSub,R.id.btn_sub);
        onClickHandler.assignView(btnDiv,R.id.btn_divide);
        onClickHandler.assignView(btnMul,R.id.btn_multi);
        onClickHandler.assignView(btnEqual,R.id.btn_equal);
        onClickHandler.assignView(btnClear,R.id.btn_c);
        onClickHandler.assignView(btnAllClear,R.id.btn_AllClear);
        onClickHandler.assignView(btnOpen,R.id.btn_open_b);
        onClickHandler.assignView(btnClose,R.id.btn_close_c);
        onClickHandler.assignView(btnDot,R.id.btn_dot);
    }
}