package com.example.exam02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    RadioButton rdoBtn1, rdoBtn2;
    Spinner spinner;
    CheckBox checkBox1, checkBox2, checkBox3;
    Button btn1;
    TextView textView1, textView2;
    String bType, gender;
    Gallery gallery;

    View dialogView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        spinner = findViewById(R.id.spinner1);
        rdoBtn1 = findViewById(R.id.rdoBtn1);
        rdoBtn2 = findViewById(R.id.rdoBtn2);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        btn1 = findViewById(R.id.btn1);
        gallery = findViewById(R.id.gallery1);
        gender = "여자";
        rdoBtn1.setChecked(true);

        final String bTypeArr[] = {"A", "B", "O", "AB"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, bTypeArr
        );
        spinner.setAdapter(adapter1);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bType = bTypeArr[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        rdoBtn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    gender = "여자";
                }
            }
        });
        rdoBtn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    gender = "남자";
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText1.getText().toString().equals("") | editText2.getText().toString().equals("")) {
                    View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    AlertDialog dialogView1 = dlg.create();
                    dialogView1.setView(dialogView);
                    dialogView1.show();

                    // 대화상자 크기 직접 조절하는 코드
                    // params로 width, height를 조절한다
                    WindowManager.LayoutParams params = new WindowManager.LayoutParams();
                    params.copyFrom(dialogView1.getWindow().getAttributes());
                    params.width=750;
                    params.height=750;
                    dialogView1.getWindow().setAttributes(params);

                } else {
                    textView1.setText("1." + bType + "형 " + gender + "입니다!");
                    DecimalFormat form = new DecimalFormat("#.#");
                    double height = Double.parseDouble(editText1.getText().toString());
                    double weight = Double.parseDouble(editText2.getText().toString());
                    double result = weight / ((height / 100) * 2);
                    textView2.setText("2.신체질량지수는 " + form.format(result) + "입니다!");
                    ArrayList<Integer> imageId = new ArrayList<>();
                    if (checkBox1.isChecked()) {
                        imageId.add(R.drawable.drinking);
                    }
                    if (checkBox2.isChecked()) {
                        imageId.add(R.drawable.ciga);
                    }
                    if (!checkBox3.isChecked()) {
                        imageId.add(R.drawable.running);
                    }

                    final ImageAdapter adapter2 = new ImageAdapter(MainActivity.this, imageId);
                    gallery.setAdapter(adapter2);
                }
            }
        });

    }

    public class ImageAdapter extends BaseAdapter {
        Context context;
        ArrayList<Integer> imageId;


        public ImageAdapter(Context context, ArrayList<Integer> imageId) {
            this.context = context;
            this.imageId = imageId;
        }

        @Override
        public int getCount() {
            return imageId.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(MainActivity.this);
            imageview.setLayoutParams(new Gallery.LayoutParams(500, 450));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(30, 30, 30, 30);

            imageview.setImageResource(imageId.get(position));

            return imageview;
        }
    }

}


