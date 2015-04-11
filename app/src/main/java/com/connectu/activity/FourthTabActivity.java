package com.connectu.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.connectu.controller.SharedPreferenceController;

@SuppressLint("ValidFragment")
public class FourthTabActivity extends Fragment {
    Context mContext;
    CheckBox checkBox_autologin;
    Boolean boolean_yn;
    public FourthTabActivity(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fourth_tab, null);

        checkBox_autologin = (CheckBox) view.findViewById(R.id.checkbox_mainautologin);

        SharedPreferenceController pref = new SharedPreferenceController(getActivity());
        checkBox_autologin.setChecked(pref.getValue(SharedPreferenceController.PREF_USER_AUTOLOGIN, false));

        checkBox_autologin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (checkBox_autologin.isChecked())
                {
                    SharedPreferenceController pref = new SharedPreferenceController(getActivity());
                    pref.put(SharedPreferenceController.PREF_USER_AUTOLOGIN, true);
                }
                else
                {
                    SharedPreferenceController pref = new SharedPreferenceController(getActivity());
                    pref.put(SharedPreferenceController.PREF_USER_AUTOLOGIN, false);
                }
            }
        });

        return view;
    }
}