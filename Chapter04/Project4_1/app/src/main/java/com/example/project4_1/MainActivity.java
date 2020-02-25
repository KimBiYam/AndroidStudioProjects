package com.example.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnRem;
    TextView textResult;
    Double num1, num2;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnRem = (Button) findViewById(R.id.BtnRem);
        textResult = (TextView) findViewById(R.id.TextResult);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = edit1.getText().toString();
                String s2 = edit2.getText().toString();
                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값이 없습니다!", Toast.LENGTH_SHORT).show();
                } else {
                    num1 = Double.parseDouble(s1);
                    num2 = Double.parseDouble(s2);
                    int num3 = (int) (num1 + num2);
                    textResult.setText("계산 결과 : " + num3);
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = edit1.getText().toString();
                String s2 = edit2.getText().toString();
                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값이 없습니다!", Toast.LENGTH_SHORT).show();
                } else {
                    num1 = Double.parseDouble(s1);
                    num2 = Double.parseDouble(s2);
                    int num3 = (int) (num1 - num2);
                    textResult.setText("계산 결과 : " + num3);
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = edit1.getText().toString();
                String s2 = edit2.getText().toString();
                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값이 없습니다!", Toast.LENGTH_SHORT).show();
                } else {
                    num1 = Double.parseDouble(s1);
                    num2 = Double.parseDouble(s2);
                    int num3 = (int) (num1 * num2);
                    textResult.setText("계산 결과 : " + num3);
                }

            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = edit1.getText().toString();
                String s2 = edit2.getText().toString();
                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값이 없습니다!", Toast.LENGTH_SHORT).show();
                } else {
                    num1 = Double.parseDouble(s1);
                    num2 = Double.parseDouble(s2);
                    if (num2 == 0) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌수 없음", Toast.LENGTH_SHORT).show();
                    }
                    double num3 = num1 / num2;
                    num3 = (int) (num3 * 100) / 100.0;
                    textResult.setText("계산 결과 : " + num3);
                }
            }
        });
        btnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = edit1.getText().toString();
                String s2 = edit2.getText().toString();
                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값이 없습니다!", Toast.LENGTH_SHORT).show();

                } else {
                    num1 = Double.parseDouble(s1);
                    num2 = Double.parseDouble(s2);
                    if (num2 == 0) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌수 없음", Toast.LENGTH_SHORT).show();

                    }
                    int num3 = (int) (num1 % num2);
                    textResult.setText("계산 결과 : " + num3);

                }

            }
        });

    }
}
