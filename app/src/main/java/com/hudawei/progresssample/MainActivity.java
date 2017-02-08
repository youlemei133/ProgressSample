package com.hudawei.progresssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView text_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        text_progress = (TextView) findViewById(R.id.text_progress);
        setSeekBar(seekBar);

        setRatingBar();
    }

    private void setRatingBar() {
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(MainActivity.this,"平分："+v,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setSeekBar(SeekBar seekBar) {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //进度改变时调用
                text_progress.setText("当前进度："+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //按下进度时调用
                Toast.makeText(MainActivity.this,"按下",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //松开进度时调用
                Toast.makeText(MainActivity.this,"松开",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
