package com.example.android.basketballscorekeeper;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Typeface mHeadLines;
    private TextInputEditText mTeamName1;
    private TextInputEditText mTeamName2;
    private TextInputLayout mInputLayoutTeamName1;
    private TextInputLayout mInputLayoutTeamName2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Font path
        String fontPath = "junegull.ttf";
        mHeadLines = Typeface.createFromAsset(getResources().getAssets(), fontPath);

        TextView logoText = (TextView) findViewById(R.id.logoText);
        TextView logoText1 = (TextView) findViewById(R.id.logoText1);
        Button startButton = (Button) findViewById(R.id.start_button);

        startButton.setTypeface(mHeadLines);
        logoText.setTypeface(mHeadLines);
        logoText1.setTypeface(mHeadLines);

        mInputLayoutTeamName1 = (TextInputLayout) findViewById(R.id.input_layout_team1);
        mInputLayoutTeamName2 = (TextInputLayout) findViewById(R.id.input_layout_team2);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTeamName1 = (TextInputEditText) findViewById(R.id.input_team1);
                mTeamName2 = (TextInputEditText) findViewById(R.id.input_team2);
                startScoreKeeper();
            }
        });


    }

    public void startScoreKeeper(){
        if(!validateTeamNames()) return;

        Toast.makeText(getApplicationContext(),"Enjoy Score Keeper",Toast.LENGTH_LONG).show();
        Intent goToScoreBoard = new Intent(MainActivity.this,ScoreBoard.class);
        goToScoreBoard.putExtra("teamName1", mTeamName1.getText().toString().trim());
        goToScoreBoard.putExtra("teamName2", mTeamName2.getText().toString().trim());
        startActivity(goToScoreBoard);
    }

    public boolean validateTeamNames(){
        //Validate Team #1 name
        if(mTeamName1.getText().toString().trim().isEmpty()){
            mInputLayoutTeamName1.setError(getString(R.string.team1_name_error_msg));
            return false;
        }else mInputLayoutTeamName1.setErrorEnabled(false);

        //Validate Team #2 name
        if(mTeamName2.getText().toString().trim().isEmpty()){
            mInputLayoutTeamName2.setError(getString(R.string.team2_name_error_msg));
            return false;
        }else mInputLayoutTeamName2.setErrorEnabled(false);

        return true;
    }
}
