package com.example.kvizko;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import com.example.kvizko.Models.QuestionModel;

import java.util.concurrent.TimeUnit;

public class ScoreActivity extends AppCompatActivity {

    private TextView scoreTV, timeTV, totalQTV, correctQTV, wrongQTV, unattemptedQTV;
    private AppCompatButton leaderB, reAttemptB, viewAnsB;
    private long timeTaken;
    private Dialog progressDialog;
    private TextView dialogText;
    private int finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Result");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        progressDialog = new Dialog(ScoreActivity.this);
        progressDialog.setContentView(R.layout.dialog_layout);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogText = progressDialog.findViewById(R.id.dialog_text);
        dialogText.setText("Loading...");

        progressDialog.show();


        init();

        loadData();

        setBookMarks();

        viewAnsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ScoreActivity.this, AnswersActivity.class);
                startActivity(intent);

            }
        });
        reAttemptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reAttempt();
            }
        });
        saveResult();

    }

    private void init() {
        scoreTV = findViewById(R.id.score);
        timeTV = findViewById(R.id.time);
        totalQTV = findViewById(R.id.totalQ);
        correctQTV = findViewById(R.id.correctQ);
        wrongQTV = findViewById(R.id.wrongQ);
        unattemptedQTV = findViewById(R.id.un_attempted);
        leaderB = findViewById(R.id.leaderB);
        reAttemptB = findViewById(R.id.reattemptB);
        viewAnsB = findViewById(R.id.view_answerB);

    }

    private void loadData() {
        int correctQ = 0, wrongQ = 0, unattemptedQ = 0;

        for (int i = 0; i < DbQuery.g_questList.size(); i++) {

            if (DbQuery.g_questList.get(i).getSelectedAns() == -1) {
                unattemptedQ++;
            } else {
                if (DbQuery.g_questList.get(i).getSelectedAns() == DbQuery.g_questList.get(i).getCorrectAns()) {
                    correctQ++;
                } else {
                    wrongQ++;
                }
            }

        }

        correctQTV.setText(String.valueOf(correctQ));
        wrongQTV.setText(String.valueOf(wrongQ));
        unattemptedQTV.setText(String.valueOf(unattemptedQ));

        totalQTV.setText(String.valueOf(DbQuery.g_questList.size()));

        finalScore = (correctQ * 100) / DbQuery.g_questList.size();
        scoreTV.setText(String.valueOf(finalScore));

        timeTaken = getIntent().getLongExtra("TIME_TAKEN", 0);

        String time = String.format("%02d : %02d min",
                TimeUnit.MILLISECONDS.toMinutes(timeTaken),
                TimeUnit.MILLISECONDS.toSeconds(timeTaken) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeTaken))
        );

        timeTV.setText(time);

    }

    private void reAttempt() {
        for (int i = 0; i < DbQuery.g_questList.size(); i++) {
            DbQuery.g_questList.get(i).setSelectedAns(-1);
            DbQuery.g_questList.get(i).setStatus(DbQuery.NOT_VISITED);

        }
        Intent intent = new Intent(ScoreActivity.this, StartTestActivity.class);
        startActivity(intent);
        finish();
    }

    private void saveResult() {
        DbQuery.saveResult(finalScore, new MyCompleteListener() {
            @Override
            public void onSuccess() {
                progressDialog.dismiss();
            }

            @Override
            public void onFailure() {
                Toast.makeText(ScoreActivity.this, "Something went wrong! Please try again later!", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }

    private void setBookMarks() {
        for (int i = 0; i < DbQuery.g_questList.size(); i++) {

            QuestionModel question = DbQuery.g_questList.get(i);
            if (question.isBookmarked()) {
                if (!DbQuery.g_bmIdList.contains(question.getqID())) {
                    DbQuery.g_bmIdList.add(question.getqID());
                    DbQuery.myProfile.setBookmarksCount(DbQuery.g_bmIdList.size());
                }
            } else {
                if (DbQuery.g_bmIdList.contains(question.getqID())) {
                    DbQuery.g_bmIdList.remove(question.getqID());
                    DbQuery.myProfile.setBookmarksCount(DbQuery.g_bmIdList.size());
                }
            }
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            ScoreActivity.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}