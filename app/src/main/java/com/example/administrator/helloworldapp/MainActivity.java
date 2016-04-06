package com.example.administrator.helloworldapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rng = new Random();
    int num1;
    int num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateProblem();
    }

    public void generateProblem() {
        num1 = rng.nextInt(10)+1;
        num2 = rng.nextInt(10)+1;

        TextView problem = (TextView)findViewById(R.id.actualQuestion);

        problem.setText(num1 + "+" + num2 + "=");
    }

    public void checkAnswer() {

    }
}
