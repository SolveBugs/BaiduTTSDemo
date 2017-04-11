package com.example.zq.baiduttsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button start, pause, resume, stop;
    private EditText content;
    private SpeechUtils speechUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.btn_start);
        pause = (Button) findViewById(R.id.btn_pause);
        resume = (Button) findViewById(R.id.btn_resume);
        stop = (Button) findViewById(R.id.btn_stop);
        content = (EditText) findViewById(R.id.et_content);

        start.setOnClickListener(this);
        pause.setOnClickListener(this);
        resume.setOnClickListener(this);
        stop.setOnClickListener(this);

        speechUtils = SpeechUtils.getsSpeechUtils(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                if (!TextUtils.isEmpty(content.getText().toString())) {
                    speechUtils.speak(content.getText().toString());
                }
                break;
            case R.id.btn_pause:
                speechUtils.pause();
                break;
            case R.id.btn_resume:
                speechUtils.resume();
                break;
            case R.id.btn_stop:
                speechUtils.stop();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        speechUtils.stop();
        speechUtils.release();
    }
}
