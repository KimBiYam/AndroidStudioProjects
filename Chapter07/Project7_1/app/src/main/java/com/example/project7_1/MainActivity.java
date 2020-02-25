package com.example.project7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RelativeLayout baseLayout;
    Button button1;
    EditText editText;
    ImageView imageView;
    int rotate;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // xml 파일에 접근하는 방법
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        // 직접 java 코드로 코딩하는 방법
/*
        menu.add(0, 1, 0, "배경색 (빨강)");
        menu.add(0, 2, 0, "배경색 (초록)");
        menu.add(0, 3, 0, "배경색 (파랑)");

        SubMenu sMenu = menu.addSubMenu("버튼 변경 >>");
        sMenu.add(0, 4, 0, "버튼 45도 회전");
        sMenu.add(0, 5, 0, "버튼 2배 확대");
         */

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
//            직접 java 코드로 코딩했을때 case
/*//            case R.id.itemRed:
            case 1:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
//            case R.id.itemBlue:
            case 2:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
//            case R.id.itemGreen:
            case 3:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
//            case R.id.subRotate:
            case 4:
                button1.setRotation(45);
                return true;
//            case R.id.subSize:
            case 5:
                button1.setScaleX(2);
                return true;*/
//              xml 파일에서 item id로 가져올때 case
            case R.id.itemRotate:
                rotate += Integer.parseInt(editText.getText().toString());
                imageView.setRotation(rotate);
                return true;
            case R.id.img1:
                imageView.setImageResource(R.drawable.jeju1);
                item.setChecked(true);
                return true;
            case R.id.img2:
                imageView.setImageResource(R.drawable.jeju2);
                item.setChecked(true);
                return true;
            case R.id.img3:
                imageView.setImageResource(R.drawable.jeju3);
                item.setChecked(true);
                return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 풍경");
        baseLayout = (RelativeLayout) findViewById(R.id.baseLayout);
//        button1 = (Button) findViewById(R.id.button1);
        imageView = (ImageView) findViewById(R.id.imageView);
        editText = (EditText) findViewById(R.id.editText1);
    }
}
