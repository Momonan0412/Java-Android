package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class PassingIntentsExercise extends AppCompatActivity {
    String radioResult;
    EditText tvFirstName,  tvLastName, tvEmail, tvPhoneNumber, tvBirthDate, tvProgram, tvFood;
    RadioGroup radioBtnGroup;
    Button submitButton, clearButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);
        tvFirstName  = findViewById(R.id.textFirstName);
        tvLastName = findViewById(R.id.textLastName);
        tvEmail = findViewById(R.id.textEmail);
        tvPhoneNumber = findViewById(R.id.textPhoneNumber);
        tvBirthDate = findViewById(R.id.textBirthDate);
        tvProgram = findViewById(R.id.textProgram);
        tvFood = findViewById(R.id.textFood);
        radioBtnGroup = findViewById(R.id.radioBtnGroup);
        submitButton = findViewById(R.id.btn_SubmitForm);
        clearButton = findViewById(R.id.btn_FormClear);
        radioBtnGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radbtnMale) {
                    radioResult = "Male";
                } else if (checkedId == R.id.radbtnFemale) {
                    radioResult = "Female";
                } else {
                    radioResult = "Other";
                }
            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioResult = new String("");
                tvFirstName.setText("");
                tvLastName.setText("");
                tvEmail.setText("");
                tvPhoneNumber.setText("");
                tvBirthDate.setText("");
                tvProgram.setText("");
                tvFood.setText("");
                radioBtnGroup.clearCheck();
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
                i.putExtra("tvFirstName", tvFirstName.getText().toString());
                i.putExtra("tvLastName", tvLastName.getText().toString());
                i.putExtra("tvEmail", tvEmail.getText().toString());
                i.putExtra("tvPhoneNumber", tvPhoneNumber.getText().toString());
                i.putExtra("tvBirthDate", tvBirthDate.getText().toString());
                i.putExtra("tvProgram", tvProgram.getText().toString());
                i.putExtra("tvFood", tvFood.getText().toString());
                i.putExtra("radioResult", radioResult);
                startActivity(i);
            }
        });
    }
}