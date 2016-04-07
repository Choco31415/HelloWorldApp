package com.example.administrator.helloworldapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rng = new Random();
    int num1;
    int num2;
    int problemNum = 0;

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

    public void checkAnswer(View view) {
        EditText input = (EditText) findViewById(R.id.answer);

        if (Integer.parseInt(input.getText().toString()) == num1 + num2) {
            Button nextQuestionButton = (Button) findViewById(R.id.nextProblemButton);
            nextQuestionButton.setEnabled(true);
        }
    }

    public void nextQuestion(View view) {
        generateProblem();
    }
}
