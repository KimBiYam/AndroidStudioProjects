/*
package com.example.ex06_19;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

// 이너클래스 아니고 다른 클래스로 만들어도 상관 X

public class MyTabFragment extends Fragment {
    String tabName;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getArguments();
        tabName = data.getString("tabName");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout baseLayout = new LinearLayout(super.getActivity());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setLayoutParams(params);

        if (tabName == "음악별") baseLayout.setBackgroundColor(Color.RED);
        if (tabName == "가수별") baseLayout.setBackgroundColor(Color.GREEN);
        if (tabName == "앨범별") baseLayout.setBackgroundColor(Color.BLUE);

        return baseLayout;
    }
}
*/
