package com.example.android.androidjokedisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    TextView mJokeTextView;
    private static final String JOKE_TAG = "joke_intent_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        mJokeTextView = findViewById(R.id.joke_text_view);
        Intent intentThatStartedThisActivity = getIntent();
        if(intentThatStartedThisActivity.hasExtra(JOKE_TAG)){
            String joke = intentThatStartedThisActivity.getStringExtra(JOKE_TAG);
            mJokeTextView.setText(joke);
        }
    }
}
