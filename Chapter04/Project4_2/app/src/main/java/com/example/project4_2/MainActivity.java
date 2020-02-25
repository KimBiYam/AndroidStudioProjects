package com.example.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch swiAgree;
    RadioGroup rGroup1;
    RadioButton radioArray[] = new RadioButton[3];
    Button btnExit, btnReset;
    ImageView imgAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        swiAgree = (Switch) findViewById(R.id.SwiAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        radioArray[0] = (RadioButton) findViewById(R.id.RdoOreo);
        radioArray[1] = (RadioButton) findViewById(R.id.RdoPie);
        radioArray[2] = (RadioButton) findViewById(R.id.RdoQ);

        btnExit = (Button) findViewById(R.id.BtnExit);
        btnReset = (Button) findViewById(R.id.BtnReset);
        imgAndroid = (ImageView) findViewById(R.id.ImgAndroid);

        swiAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    imgAndroid.setVisibility(View.VISIBLE);
                } else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    imgAndroid.setVisibility(View.INVISIBLE);
                }
            }

        });

        final int draw[] = {R.drawable.oreo,R.drawable.pie,R.drawable.q10};

        for(int i=0;i<radioArray.length;i++){
            final int index;
            index =i;
            radioArray[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    imgAndroid.setImageResource(draw[index]);
                    btnExit.setVisibility(View.VISIBLE);
                    btnReset.setVisibility(View.VISIBLE);
                }
            });
        }


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2.setVisibility(View.INVISIBLE);
                rGroup1.setVisibility(View.INVISIBLE);
                imgAndroid.setVisibility(View.INVISIBLE);
                btnExit.setVisibility(View.INVISIBLE);
                btnReset.setVisibility(View.INVISIBLE);

                rGroup1.clearCheck();
                swiAgree.setChecked(false);
                imgAndroid.setImageResource(0);
            }
        });




    }
}

