package com.example.ex06_19;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    // 자체적으로 리스너를 가진 TabListener 인터페이스를 사용

    // 액션바의 탭 만들기
    ActionBar.Tab tabSong, tabArtist, tabAlbum; // 프래그먼트 연동을 위해 멤버변수로

    // 프래그먼트가 생성되면 저장될 3개짜리 배열을 만들어 놓음
    MyTabFragment myFrags[] = new MyTabFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        // 액션바 (메뉴부분) 만들기
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabSong = bar.newTab();
        tabSong.setText("음악별");
        tabSong.setTabListener(this); // 리스너 연결
        bar.addTab(tabSong);

        tabArtist = bar.newTab();
        tabArtist.setText("가수별");
        tabArtist.setTabListener(this);
        bar.addTab(tabArtist);

        tabAlbum = bar.newTab();
        tabAlbum.setText("앨범별");
        tabAlbum.setTabListener(this);
        bar.addTab(tabAlbum);
    }

    // 프래그먼트 만들기(내부 클래스로 만듦)
    // Fragment <-> View 와 동급 레벨, 화면 분할을 위해 프래그먼트를 뷰 대신 사용, 액티비티가 가지고 있음
    // static : 메모리가 고정적으로 불러오고 공유하기위해 사용
    public static class MyTabFragment extends Fragment {
        String tabName;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName"); // 액션바에 있는 탭네임을 번들을 통해 가져옴
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // 프래그먼트의 디자인 만들기
            // 방법 1 : xml 만들어서 해당 xml을 연결
            // 방법 2 : java 코드로 직접 코딩
            // 여기서는 java 코드로 직접 코딩하여 디자인 만듦

            // static 에서는 내부도 모두 static을 사용해야 함
            // this는 static이 아니기때문에 getActivity()라는 메소드로 액티비티를 가져옴
//            LinearLayout baseLayout = new LinearLayout(this);
            LinearLayout baseLayout = new LinearLayout(super.getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(params);

            // 액션바의 탭에서 가져온 탭이름에 해당하는 프래그먼트의 화면(View)을 설정
            if (tabName == "음악별") baseLayout.setBackgroundColor(Color.RED);
            if (tabName == "가수별") baseLayout.setBackgroundColor(Color.GREEN);
            if (tabName == "앨범별") baseLayout.setBackgroundColor(Color.BLUE);

            return baseLayout;
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // 1개의 프래그먼트 생성
        MyTabFragment myTabFrag = null;

        // 처음 탭을 눌렀을 때, 프래그먼트 생성이 안되어 있어서 만들어 줌
        if (myFrags[tab.getPosition()] == null) {
            myTabFrag = new MyTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()] = myTabFrag;
        } else {
            myTabFrag = myFrags[tab.getPosition()];
        }
        ft.replace(android.R.id.content, myTabFrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

}



