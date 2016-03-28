package com.dance2die.demoandroidudemybraintrainer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private ArrayList<Integer> answers = new ArrayList<>();
    private int locationOfCorrectAnswer;
    private TextView resultTextView;
    private int score;

    public void chooseAnswer(View view){
        if (view.getTag().equals(Integer.toString(locationOfCorrectAnswer))) {
            score++;
            resultTextView.setText("Correct!");
        } else {
            resultTextView.setText("Wrong!!!");
        }
    }

    public void start(View view){
        startButton.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        startButton = (Button) findViewById(R.id.startButton);

        Random random = new Random();
        int a = random.nextInt(21);
        int b = random.nextInt(21);
        int answer = a + b;

        TextView sumTextView = (TextView) findViewById(R.id.sumTextView);
        sumTextView.setText(String.format("%s + %s", Integer.toString(a), Integer.toString(b)));

        locationOfCorrectAnswer = random.nextInt(4);
        int incorrectAnswer;

        for(int i = 0; i < 4; i++){
            if (i == locationOfCorrectAnswer){
                answers.add(answer);
            } else {
                do {
                    incorrectAnswer = random.nextInt(41);
                } while (incorrectAnswer == answer);

                answers.add(incorrectAnswer);
            }
        }

        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

        resultTextView = (TextView) findViewById(R.id.resultTextView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
