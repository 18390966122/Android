package com.wh.myapplication;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

/*
 * 创建者 曹晓丽
 * 创建时间 2018/9/29 9:49
 */
public class NormalActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private ImageView imageView;
    private ProgressBar bar;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.normal_layout);
        Button btn1 = (Button) findViewById(R.id.btn1);
        editText = (EditText) findViewById(R.id.txt1);
        imageView = (ImageView) findViewById(R.id.img2);
        bar = (ProgressBar) findViewById(R.id.progress);
        btn1.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                String inputText = editText.getText().toString();
                Toast.makeText(NormalActivity.this, inputText, Toast.LENGTH_SHORT).show();

                imageView.setImageResource(R.mipmap.ic_launcher);

                if (bar.getVisibility() == View.GONE) {
                    bar.setVisibility(View.VISIBLE);
                } else {
                    bar.setVisibility(View.GONE);
                }

                int progress = bar.getProgress();
                progress = progress + 10;
                bar.setProgress(progress);

                break;
            default:
                break;
        }
    }
}
