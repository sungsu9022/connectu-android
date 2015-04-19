package com.connectu.meet.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.connectu.activity.R;

@SuppressLint("ValidFragment")
public class MeetActivity extends Fragment {
    Context mContext;

    public MeetActivity(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_second_tab, null);

        return view;
    }

}