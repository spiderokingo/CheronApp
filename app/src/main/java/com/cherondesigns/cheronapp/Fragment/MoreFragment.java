package com.cherondesigns.cheronapp.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cherondesigns.cheronapp.MainActivity;
import com.cherondesigns.cheronapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {


    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView appVer = (TextView) view.findViewById(R.id.app_version);
        appVer.setOnClickListener(textviewOnClick);
    }

    TextView.OnClickListener textviewOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.app_version:
                    ((MainActivity) getActivity()).switchFragment(new AppVersionFragment());
                    break;
            }
        }
    };

}
