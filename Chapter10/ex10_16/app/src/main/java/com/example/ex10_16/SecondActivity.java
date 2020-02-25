package com.example.ex10_16;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        Intent inIntent = getIntent();
        int hapValue = 0;
        final String operator = inIntent.getStringExtra("operator");
        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        if (operator.equals("+")) {
            hapValue = inIntent.getIntExtra("Num1", 0) +
                    inIntent.getIntExtra("Num2", 0);
        } else if (operator.equals("-")) {
            hapValue = inIntent.getIntExtra("Num1", 0) -
                    inIntent.getIntExtra("Num2", 0);
        } else if (operator.equals("*")) {
            hapValue = inIntent.getIntExtra("Num1", 0) *
                    inIntent.getIntExtra("Num2", 0);
        } else if (operator.equals("/")) {
            hapValue = inIntent.getIntExtra("Num1", 0) /
                    inIntent.getIntExtra("Num2", 0);
        }
        final int finalHapValue = hapValue;

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Hap", finalHapValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}

