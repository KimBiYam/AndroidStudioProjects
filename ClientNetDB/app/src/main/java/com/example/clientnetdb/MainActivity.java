package com.example.clientnetdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button refreshBtn, addBtn;
    private ListView listView;
    private Custom_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        adapter = new Custom_Adapter(MainActivity.this, R.layout.adapter_userinfo, new ArrayList<UserInfo>());
        listView.setAdapter(adapter);

        refreshBtn = (Button) findViewById(R.id.btnRefresh);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NetworkGet((Custom_Adapter) listView.getAdapter()).execute("");
            }
        });



    }
}
