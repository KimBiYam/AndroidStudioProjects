package com.example.ch07_test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex07_14);


        // ex07_12
        /* setContentView(R.layout.ex07_12);

        setTitle("토스트 연습");


        final Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast tMsg = Toast.makeText(MainActivity.this, "토스트 연습", Toast.LENGTH_SHORT);

                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int xOffest = (int) (Math.random() * display.getWidth());
                int yOffest = (int) (Math.random() * display.getHeight());

                tMsg.setGravity(Gravity.TOP | Gravity.LEFT, xOffest, yOffest);
                tMsg.show();
            }
        });*/

        // ex07_14
        setTitle("대화상자 연습");
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            // ex 07_14
            /*@Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("제목입니다");
                dlg.setMessage("이곳이 내용입니다");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "확인을 눌렀네요"
                                , Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            });*/


            public void onClick(View v) {
                // ex07_18
                final String[] versionArray = new String[]{"롤리팝", "마시멜로", "누가"};
                final boolean[] checkArray = new boolean[]{true, false, false};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 버전은?");
                dlg.setIcon(R.mipmap.ic_launcher);
                // 라디오버튼 목록 대화상자
                /*dlg.setSingleChoiceItems(versionArray,0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        button1.setText(versionArray[which]);
                    }
                });*/
                final ArrayList<String> arr = new ArrayList<>();
                arr.add(versionArray[0]);
                dlg.setMultiChoiceItems(versionArray, checkArray,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    arr.add(versionArray[which]);
                                } else {
                                    arr.remove(versionArray[which]);
                                }
                            }
                        });
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String btnStr = button1.getText().toString();
                        if (arr.size() == 0) {
                            button1.setText(btnStr);
                        } else {
                            button1.setText("");
                            for (int i = 0; i < arr.size(); i++) {
                                if (i != 0) {
                                    button1.append(",");
                                }
                                button1.append(arr.get(i));
                            }
                        }
                    }
                });
                dlg.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "취소했습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }

        });

    }
}