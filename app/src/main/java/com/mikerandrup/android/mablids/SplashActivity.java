package com.mikerandrup.android.mablids;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SplashActivity extends ActionBarActivity {

    private TextView tvPrefix;
    private TextView tvWord;
    private TextView tvSuffix;

    private String[] wordList = new String[] {
            "substitution",
            "confusion",
            "replacement",
            "mutilation"
    };
    int wordIndex = 0;

    private int delayMs = 1000;

    private Handler mHandler = new Handler();

    private final Runnable mUpdateWordOrLaunchMainActivity = new Runnable() {
        @Override
        public void run() {
            if (wordIndex<wordList.length) {
                tvWord.setText(wordList[wordIndex]);
                wordIndex++;

                tvPrefix.setVisibility(View.VISIBLE);
                tvWord.setVisibility(View.VISIBLE);
                tvSuffix.setVisibility(View.VISIBLE);

                mHandler.postDelayed(mUpdateWordOrLaunchMainActivity, delayMs);
            }
            else {
                Intent openMain = new Intent(SplashActivity.this, EssayActivity.class);
                startActivity(openMain);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tvPrefix = (TextView) findViewById(R.id.tvPrefix);
        tvWord = (TextView) findViewById(R.id.tvWord);
        tvSuffix = (TextView) findViewById(R.id.tvSuffix);

        mHandler.postDelayed(mUpdateWordOrLaunchMainActivity, delayMs);
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}