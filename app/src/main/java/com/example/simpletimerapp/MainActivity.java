package com.example.simpletimerapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTimer;
    private Button buttonStart;

    private CountDownTimer countDownTimer;
    private final long startTimeInMillis = 10000; // 10 seconds in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTimer = findViewById(R.id.textViewTimer);
        buttonStart = findViewById(R.id.buttonStart);

        buttonStart.setOnClickListener(v -> startTimer());
    }

    private void startTimer() {
        buttonStart.setEnabled(false); // disable button after starting

        countDownTimer = new CountDownTimer(startTimeInMillis, 1000) {
            public void onTick(long millisUntilFinished) {
                textViewTimer.setText("Timer: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textViewTimer.setText("Timer: 0");
                Toast.makeText(MainActivity.this, "Time's up!", Toast.LENGTH_SHORT).show();
                buttonStart.setEnabled(true); // re-enable button
            }
        }.start();
    }
}
