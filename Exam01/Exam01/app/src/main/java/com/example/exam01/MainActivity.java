package com.example.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    Button btn1, btn2;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        listView = (ListView) findViewById(R.id.listView1);

        final ArrayList<String> arr = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arr);
        listView.setAdapter(adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rand1 = new Random().nextInt(8) + 2;
                int rand2 = new Random().nextInt(8) + 2;
                editText1.setText(Integer.toString(rand1));
                editText2.setText(Integer.toString(rand2));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText1.getText().toString().equals("")||
                        editText2.getText().toString().equals("")||
                        editText3.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "값을 입력하세요", Toast.LENGTH_SHORT).show();
                }else{
                    int num1 = Integer.parseInt(editText1.getText().toString());
                    int num2 = Integer.parseInt(editText2.getText().toString());
                    int dap = Integer.parseInt(editText3.getText().toString());
                    if (dap == num1 * num2) {
                        Toast.makeText(MainActivity.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                        arr.clear();
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(MainActivity.this, "틀렸습니다!", Toast.LENGTH_SHORT).show();
                        for (int i = 1; i < 10; i++) {
                            String str = num1 + " x " + i + " = " + num1 * i;
                            System.out.println(str);
                            arr.add(str);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }

            }
        });
    }
}


