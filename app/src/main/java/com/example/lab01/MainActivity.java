package com.example.lab01;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CountDownTimer myCountDownTimer;
    private long timeElapsed;
    private boolean timerHasStarted = false;
    private Button startB;
    private TextView text;
    private TextView timeElapsedView;
    private final long startTime = 50 * 1000;
    private final long interval = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startB = this.findViewById(R.id.button);
        startB.setOnClickListener(this);
        text = this.findViewById(R.id.timer);
        timeElapsedView = this.findViewById(R.id.timeElapsed);
        myCountDownTimer = new CountDownTimer(startTime, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                text.setText("Time remain: " + String.valueOf(startTime));
                timeElapsed = startTime - millisUntilFinished;
                timeElapsedView.setText("Time Elapsed: " + String.valueOf(timeElapsed));
            }

            @Override
            public void onFinish() {
                text.setText("Time's up!");
                timeElapsedView.setText("Time Elapsed: " + String.valueOf(startTime));
            }
        };
        String textToReturn = (text.getText() + String.valueOf(startTime));
        text.setText(textToReturn);


    }

    @Override
    public void onClick(View v) {
        if(!timerHasStarted){
            myCountDownTimer.start();
            timerHasStarted = true;
            startB.setText("Start");
        }
        else {
            myCountDownTimer.cancel();
            timerHasStarted = false;
            startB.setText("Reset");
        }
    }
}