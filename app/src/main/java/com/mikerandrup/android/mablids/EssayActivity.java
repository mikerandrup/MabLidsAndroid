package com.mikerandrup.android.mablids;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mikerandrup.essaycomposable.Essay;

public class EssayActivity extends ActionBarActivity {

    private Essay essay;

    private TextView promptLabel;
    private Button nextButton;
    private EditText prompt;
    private TextView essayOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essay);

        promptLabel = (TextView) findViewById(R.id.tvPrompt);
        nextButton = (Button) findViewById(R.id.btNext);
        prompt = (EditText) findViewById(R.id.etPrompt);
        essayOutput = (TextView) findViewById(R.id.tvEssayOutput);

        essay = new Essay();

        nextButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOutput();
            }
        });

        ShowPrompt("expletive");
    }

    private void ShowPrompt(String thingToPromptFor) {
        essayOutput.setVisibility(View.INVISIBLE);

        String promptText = "Provide " + thingToPromptFor;

        promptLabel.setText(promptText);
        promptLabel.setVisibility(View.VISIBLE);

        nextButton.setVisibility(View.VISIBLE);

        prompt.setHint(promptText);
        prompt.setVisibility(View.VISIBLE);
    }

    private void ShowOutput() {
        promptLabel.setVisibility(View.INVISIBLE);
        nextButton.setVisibility(View.INVISIBLE);
        prompt.setVisibility(View.INVISIBLE);

        essayOutput.setText(essay.toString());
        essayOutput.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
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
