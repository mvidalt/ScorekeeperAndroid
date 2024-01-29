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
}
