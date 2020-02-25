package com.example.project7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //    TextView tvName, tvEmail;
    Button button1;
    EditText dlgEdtName, dlgEdtEmail, editText1, editText2;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

//        tvName = (TextView) findViewById(R.id.tvName);
//        tvEmail = (TextView) findViewById(R.id.tvEmail);
        button1 = (Button) findViewById(R.id.button1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 다이얼로그 뷰 만들기
                dialogView = (View) View.inflate(MainActivity.this,
                        R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                // 뷰를 다이얼로그 객체에 연결
                dlg.setView(dialogView);

                // 다이얼로그 위젯을 바인딩 (dialogView에서 가져옴)
                dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                dlgEdtEmail = (EditText) dialogView.findViewById(R.id.dlgEdt2);
                dlgEdtName.setText(editText1.getText().toString());
                dlgEdtEmail.setText(editText2.getText().toString());

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editText1.setText(dlgEdtName.getText().toString());
                        editText2.setText(dlgEdtEmail.getText().toString());
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(MainActivity.this);
                        // 토스트 뷰 만들기
                        toastView = (View) View.inflate(MainActivity.this,
                                R.layout.toast1, null);
                        toastText = (TextView) toastView.findViewById(R.id.toastText1);
                        toastText.setText("취소했습니다");
                        // 뷰를 토스트 객체에 연결
                        toast.setView(toastView);
                        toast.setDuration(Toast.LENGTH_SHORT);

                        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int xOffset = (int) (Math.random() * display.getWidth());
                        int yOffset = (int) (Math.random() * display.getHeight());
                        toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);

                        toast.show();
                    }
                });
                dlg.show();

            }
        });


    }
}

