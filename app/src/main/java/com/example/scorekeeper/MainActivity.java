package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeam1Value = 0;

    int scoreTeam2Value = 0;

    TextView scoreTeam1Text;

    TextView scoreTeam2Text;

    ImageView imageTeam1Decrease;

    ImageView imageTeam1Increase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTeam1Text = findViewById(R.id.Team1Score);
        scoreTeam2Text = findViewById(R.id.Team2Score);

        findViewById(R.id.Team1Increase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseScore(v);
            }
        });

        findViewById(R.id.Team1Decrease).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseScore(v);
            }
        });

        findViewById(R.id.Team2Increase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseScore(v);
            }
        });

        findViewById(R.id.Team2Decrease).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseScore(v);
            }
        });
    }

    public void increaseScore(View view) {
        if (view.getId() == R.id.Team1Increase) {
            scoreTeam1Value++;
            scoreTeam1Text.setText(String.valueOf(scoreTeam1Value));
        } else {
            scoreTeam2Value++;
            scoreTeam2Text.setText(String.valueOf(scoreTeam2Value));
        }
    }

    public void decreaseScore(View view) {

            // Checking which button is clicked

            if (scoreTeam1Value > 0 && view.getId() == R.id.Team1Decrease) {
                scoreTeam1Value--;
                scoreTeam1Text.setText(String.valueOf(scoreTeam1Value));
            } else if (scoreTeam2Value > 0 && view.getId() == R.id.Team2Decrease) {
                scoreTeam2Value--;
                scoreTeam2Text.setText(String.valueOf(scoreTeam2Value));
            }
        }


}