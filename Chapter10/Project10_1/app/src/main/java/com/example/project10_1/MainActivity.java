package com.example.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton rdSecond, rdThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        rdSecond = (RadioButton) findViewById(R.id.rdSecond);
        rdThird = (RadioButton) findViewById(R.id.rdThird);
        rdSecond.setChecked(true);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rdSecond.isChecked()) {
                    Intent intent = new Intent(getApplicationContext(),
                            SecondActivity.class);
                    startActivity(intent);
                }
                if (rdThird.isChecked()) {
                    Intent intent = new Intent(getApplicationContext(),
                            ThirdActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
