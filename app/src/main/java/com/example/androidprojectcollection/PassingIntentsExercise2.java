package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {
    TextView tvFirstName, tvLastName, tvEmail, tvPhoneNumber, tvBirthDate, tvRadioResult, tvProgram, tvFood;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("tvFirstName");
            String value2 = extras.getString("tvLastName");
            String value3 = extras.getString("tvEmail");
            String value4 = extras.getString("tvPhoneNumber");
            String value5 = extras.getString("tvBirthDate");
            String value6 = extras.getString("radioResult");
            String value8 = extras.getString("tvProgram");
            String value7 = extras.getString("tvFood");
        tvFirstName = findViewById(R.id.tvFirstName);
        tvLastName = findViewById(R.id.tvLastName);
        tvEmail = findViewById(R.id.tvEMail);
        tvPhoneNumber = findViewById(R.id.tvPhoneNumber);
        tvBirthDate = findViewById(R.id.tvBDate);
        tvRadioResult = findViewById(R.id.tvRadioResult);
        tvProgram = findViewById(R.id.tvProgram);
        tvFood = findViewById(R.id.tvFood);
        btnBack = findViewById(R.id.btnBack);
        tvFirstName.setText(value);
        tvLastName.setText(value2);
        tvEmail.setText(value3);
        tvPhoneNumber.setText(value4);
        tvBirthDate.setText(value5);
        tvRadioResult.setText(value6);
        tvProgram.setText(value8);
        tvFood.setText(value7);
        btnBack.setOnClickListener(v -> {
            setResult(RESULT_OK);
            finish();
        });
        }
    }
}