package com.cherondesigns.cheronapp.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cherondesigns.cheronapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppVersionFragment extends Fragment {


    public AppVersionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app_version, container, false);
    }

}
