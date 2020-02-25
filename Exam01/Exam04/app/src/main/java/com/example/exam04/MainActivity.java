package com.example.exam04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CheckBox[] checkBoxArray = new CheckBox[4];
    EditText[] editTextArray = new EditText[4];
    EditText editText1;
    TextView textView1, textView2, textView3;
    Button btnResult;
    Spinner spinner;
    Gallery gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        btnResult = (Button) findViewById(R.id.btnResult);

        spinner = (Spinner) findViewById(R.id.spinner);
        gallery = (Gallery) findViewById(R.id.gallery);

        String[] spinnerValue = {"Appearanc(외모)", "Ability(능력)", "Personality(성격)", "Lineage(가문)", "Faith(신앙)"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerValue);
        spinner.setAdapter(spinnerAdapter);


        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dreamTime = 0;
                int[] checkBoxId = {R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4};
                int[] editTextId = {R.id.editText2, R.id.editText3, R.id.editText4, R.id.editText5};
                int[] imageSrcArray = {R.drawable.programming,R.drawable.book_reading,R.drawable.engligh_study,R.drawable.work_out};
                ArrayList<Integer> galleryArray = new ArrayList<>();
                if (editText1.getText().toString().equals("")) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    View dialogView = View.inflate(MainActivity.this,R.layout.dialog,null);
                    dlg.setView(dialogView);
                    dlg.show();
                } else {
                    textView1.setText("1.나는 " + editText1.getText().toString() + "시간 잠을 잡니다!");
                    for (int i = 0; i < checkBoxArray.length; i++) {
                        checkBoxArray[i] = (CheckBox) findViewById(checkBoxId[i]);
                        editTextArray[i] = (EditText) findViewById(editTextId[i]);
                        if (checkBoxArray[i].isChecked()) {
                            if (editTextArray[i].getText().toString().equals("")) {
                                Toast.makeText(MainActivity.this, "체크한 선택지의 값을 입력하세요", Toast.LENGTH_SHORT).show();
                            } else {
                                dreamTime += Integer.parseInt(editTextArray[i].getText().toString());
                                galleryArray.add(imageSrcArray[i]);
                            }
                        }
                    }
                    textView2.setText("2.나는 꿈을 위해 " + dreamTime + "시간 투자합니다!");
                    textView3.setText("3.나의 이상형은 "+spinner.getSelectedItem().toString()+"입니다!");
                    MyGalleryAdapter galleryAdapter = new MyGalleryAdapter(galleryArray);
                    gallery.setAdapter(galleryAdapter);
                }
            }
        });


    }

    public class MyGalleryAdapter extends BaseAdapter {
        ArrayList<Integer> galleryArray;

        public MyGalleryAdapter(ArrayList<Integer> galleryArray){
            this.galleryArray = galleryArray;
        }

        @Override
        public int getCount() {
            return galleryArray.size();
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
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setLayoutParams(new Gallery.LayoutParams(350, 350));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(30,30,30,30);

            imageView.setImageResource(galleryArray.get((position)));

            return imageView;
        }
    }

}
