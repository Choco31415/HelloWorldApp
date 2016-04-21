package com.example.administrator.helloworldapp;

import android.content.Intent;
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
    int problemNum = 1;
    int attempts = 0;
    int correctOnFirstTry = 0;

    static final String SAVED_NUM1 = "num1";
    static final String SAVED_NUM2 = "num2";
    static final String SAVED_PROBLEM_NUMBER = "problemNumber";
    static final String EXTRA_PROBLEMS_CORRECT = "problemsCorrect";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            num1 = savedInstanceState.getInt(SAVED_NUM1);
            num2 = savedInstanceState.getInt(SAVED_NUM2);
            problemNum = savedInstanceState.getInt(SAVED_PROBLEM_NUMBER);

            TextView problem = (TextView)findViewById(R.id.actualQuestion);
            problem.setText(num1 + "+" + num2 + "=");

            Button nextQuestionButton = (Button) findViewById(R.id.nextProblemButton);
            nextQuestionButton.setEnabled(false);

        } else {
            generateProblem();
        }
    }

    public void generateProblem() {
        num1 = rng.nextInt(10)+1;
        num2 = rng.nextInt(10)+1;

        TextView problem = (TextView)findViewById(R.id.actualQuestion);
        problem.setText(num1 + "+" + num2 + "=");

        Button nextQuestionButton = (Button) findViewById(R.id.nextProblemButton);
        nextQuestionButton.setEnabled(false);
    }

    public void checkAnswer(View view) {
        EditText input = (EditText) findViewById(R.id.answer);

        if (input.getText().toString() != null && Integer.parseInt(input.getText().toString()) == num1 + num2) {
            Button nextQuestionButton = (Button) findViewById(R.id.nextProblemButton);
            nextQuestionButton.setEnabled(true);
        }
    }

    public void nextQuestion(View view) {
        if (problemNum < 10) {
            generateProblem();
            TextView problemText = (TextView) findViewById(R.id.questionText);
            problemNum++;

            if (attempts == 0) {
                correctOnFirstTry += 1;
            }

            problemText.setText("Question #" + problemNum + "of 10");
        } else {
            Intent intent = new Intent(this, GameOver.class);
            intent.putExtra(EXTRA_PROBLEMS_CORRECT, correctOnFirstTry);
            startActivity(intent);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(SAVED_NUM1, num1);
        savedInstanceState.putInt(SAVED_NUM2, num2);
        savedInstanceState.putInt(SAVED_PROBLEM_NUMBER, problemNum);

        super.onSaveInstanceState(savedInstanceState);
    }
}
