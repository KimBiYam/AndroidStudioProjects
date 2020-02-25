package com.example.exam03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    RadioGroup rGroup;
    TextView textView1;
    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer[] rdoBtnId = {R.id.rdoBtn1, R.id.rdoBtn2, R.id.rdoBtn3, R.id.rdoBtn4};


        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        textView1 = (TextView) findViewById(R.id.textView1);

        rGroup = (RadioGroup) findViewById(R.id.rGroup);
        btn1 = (Button) findViewById(R.id.btn1);


        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                textView1.setText(rb.getText().toString());
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    double num1, num2;
                    num1 = Double.parseDouble(editText1.getText().toString());
                    num2 = Double.parseDouble(editText2.getText().toString());
                    String operator = textView1.getText().toString();
                    switch (operator) {
                        case "+":
                            editText3.setText(Double.toString((num1 + num2)));
                            break;
                        case "-":
                            editText3.setText(Double.toString((num1 - num2)));
                            break;
                        case "*":
                            editText3.setText(Double.toString((num1 * num2)));
                            break;
                        case "/":
                            editText3.setText(Double.toString((num1 / num2)));
                            break;
                        default:
                            Toast.makeText(MainActivity.this, "연산자를 선택하세요", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });


    }
}
