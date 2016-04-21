package com.example.administrator.helloworldapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        Intent intent = getIntent();
        int problemsCorrect = intent.getIntExtra(MainActivity.EXTRA_PROBLEMS_CORRECT, 0);

        TextView finalText = (TextView) findViewById(R.id.gameOverText);
        finalText.setText("Game Over: You got " + problemsCorrect + " of 10 correct.");
    }
}
