package com.mikerandrup.android.mablids;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mikerandrup.essaybuilder.AppReviewEssayBuilder;
import com.mikerandrup.essaycomposable.Essay;
import com.mikerandrup.essaycomposable.components.BaseComponent;
import com.mikerandrup.essaycomposable.components.dynamicwords.DynamicWordComponent;

public class EssayActivity extends ActionBarActivity {

    private Essay essay;

    private TextView promptLabel;
    private Button nextButton;
    private EditText prompt;
    private EditText essayOutput;

    private TextView progressLabel;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essay);

        promptLabel = (TextView) findViewById(R.id.tvPrompt);
        nextButton = (Button) findViewById(R.id.btNext);
        prompt = (EditText) findViewById(R.id.etPrompt);
        essayOutput = (EditText) findViewById(R.id.etEssayOutput);

        progressLabel = (TextView) findViewById(R.id.tvProgressLabel);
        progressBar = (ProgressBar) findViewById(R.id.pbProgress);

        essay = new AppReviewEssayBuilder().build();
        advancePromptOrFinish();

        nextButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String providedValue = prompt.getText().toString();
                BaseComponent essayComponentForValue = essay.getNextUnansweredComponent();
                essayComponentForValue.setValue(providedValue);

                advancePromptOrFinish();
            }
        });
    }

    private void advancePromptOrFinish() {
        if (essay.hasUnansweredComponent()) {
            String nextNeededWordType = ((DynamicWordComponent) essay.getNextUnansweredComponent()).getWordTypeAndHint();
            showPrompt(nextNeededWordType);
        }
        else {
            showOutput();
        }
    }

    private void showPrompt(String promptText) {
        essayOutput.setVisibility(View.INVISIBLE);

        promptLabel.setText(promptText);
        promptLabel.setVisibility(View.VISIBLE);

        nextButton.setVisibility(View.VISIBLE);

        updateProgress();
        progressLabel.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);

        prompt.setHint("Enter " + promptText);
        prompt.setText("");
        prompt.setVisibility(View.VISIBLE);
    }

    private void updateProgress() {

        float total = essay.getMaxUnansweredCount();
        float remaining = essay.getUnansweredCount();
        float complete = total - remaining;
        int percentComplete = 0;

        if (total > 0) {
            percentComplete = (int)(complete/total * 100);
        }

        progressBar.setProgress(percentComplete);

        String pluralGrammar = remaining == 1 ? " word needs " : " words need ";
        progressLabel.setText((int)remaining + " of " + (int)total + pluralGrammar + "answering.");
    }

    private void showOutput() {
        promptLabel.setVisibility(View.INVISIBLE);
        nextButton.setVisibility(View.INVISIBLE);
        prompt.setVisibility(View.INVISIBLE);

        progressLabel.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(prompt.getWindowToken(), 0);

        essayOutput.setText(essay.toString());
        essayOutput.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up nextButton, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
