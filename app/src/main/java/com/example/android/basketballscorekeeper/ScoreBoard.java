package com.example.android.basketballscorekeeper;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ScoreBoard extends AppCompatActivity {
    private int mTeamAScore = 0;
    private int mTeamBScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        //Setting up Team A name from intent extra
        TextView team1 = (TextView) findViewById(R.id.team_A_name);
        team1.setText(getIntent().getStringExtra("teamName1"));
        //Display intial result of 0 for team A
        displayForTeamA();
        //Setting up Team A name from intent extra
        TextView team2 = (TextView) findViewById(R.id.team_B_name);
        team2.setText(getIntent().getStringExtra("teamName2"));
        //Display intial result of 0 for team B
        displayForTeamB();
    }
    //Displays current score for team A
    public void displayForTeamA(){
        TextView scoreView = (TextView) findViewById(R.id.team_A_score);
        scoreView.setText(String.valueOf(mTeamAScore));
    }
    //Add Three points for team A
    public void addThreeForTeamA(View v){
        mTeamAScore += 3;
        displayForTeamA();
    }
    //Add Two points for team A
    public void addTwoForTeamA(View v){
        mTeamAScore += 2;
        displayForTeamA();
    }
    //Add One points for team A
    public void addOneForTeamA(View v){
        ++mTeamAScore;
        displayForTeamA();
    }
    //Displays current score for team B
    public void displayForTeamB(){
        TextView scoreView = (TextView) findViewById(R.id.team_B_score);
        scoreView.setText(String.valueOf(mTeamBScore));
    }
    //Add Three points for team A
    public void addThreeForTeamB(View v){
        mTeamBScore += 3;
        displayForTeamB();
    }
    //Add Two points for team A
    public void addTwoForTeamB(View v){
        mTeamBScore += 2;
        displayForTeamB();
    }
    //Add One points for team A
    public void addOneForTeamB(View v){
        ++mTeamBScore;
        displayForTeamB();
    }
    //Reset Scores for both teams
    public void resetScores(View v){
        mTeamAScore = 0;
        mTeamBScore = 0;
        displayForTeamA();
        displayForTeamB();
    }
}
