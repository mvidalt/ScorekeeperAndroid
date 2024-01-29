package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    // Added constants for saving instance state
    private static final String STATE_SCORE_TEAM_1 = "state_score_team_1";
    private static final String STATE_SCORE_TEAM_2 = "state_score_team_2";

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


        if (savedInstanceState != null) {
            // Retrieve the saved scores
            scoreTeam1Value = savedInstanceState.getInt(STATE_SCORE_TEAM_1);
            scoreTeam2Value = savedInstanceState.getInt(STATE_SCORE_TEAM_2);

            // Update the TextViews with the saved scores
            scoreTeam1Text.setText(String.valueOf(scoreTeam1Value));
            scoreTeam2Text.setText(String.valueOf(scoreTeam2Value));
        }

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
            if (scoreTeam1Value > 0 && view.getId() == R.id.Team1Decrease) {
                scoreTeam1Value--;
                scoreTeam1Text.setText(String.valueOf(scoreTeam1Value));
            } else if (scoreTeam2Value > 0 && view.getId() == R.id.Team2Decrease) {
                scoreTeam2Value--;
                scoreTeam2Text.setText(String.valueOf(scoreTeam2Value));
            }
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the scores in the instance state
        outState.putInt(STATE_SCORE_TEAM_1, scoreTeam1Value);
        outState.putInt(STATE_SCORE_TEAM_2, scoreTeam2Value);
        super.onSaveInstanceState(outState);
    }



}
