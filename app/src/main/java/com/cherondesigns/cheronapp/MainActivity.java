package com.cherondesigns.cheronapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cherondesigns.cheronapp.Fragment.LightFragment;
import com.cherondesigns.cheronapp.Fragment.MoreFragment;
import com.cherondesigns.cheronapp.Fragment.PairFragment;
import com.cherondesigns.cheronapp.Fragment.StreamingFragment;
import com.cherondesigns.cheronapp.Fragment.TimerFragment;

public class MainActivity extends AppCompatActivity {

    private PairFragment pairFragment;
    private ActionBar actionBar;
    private MoreFragment moreFragment;
    private LightFragment lightFragment;
    private StreamingFragment streamingFragment;
    private TimerFragment timerFragment;
    private ImageView pairBtn;

    private Toolbar toolbar;
    private TextView mTitle;
    private ImageView lightBtn;
    private ImageView streamingBtn;
    private ImageView timerBtn;
    private ImageView moreBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        setButtonNavigator();
        initFragment();
    }

    private void initFragment() {
        pairFragment = new PairFragment();
        lightFragment = new LightFragment();
        streamingFragment = new StreamingFragment();
        timerFragment = new TimerFragment();
        moreFragment = new MoreFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.content, pairFragment).commit();
        mTitle.setText(R.string.title_pair);
        pairBtn.setImageResource(R.mipmap.bluetooth_active_nav);
    }

    private void setButtonNavigator() {
        pairBtn = (ImageView) findViewById(R.id.pair_btn);
        lightBtn = (ImageView) findViewById(R.id.light_btn);
        streamingBtn = (ImageView) findViewById(R.id.streaming_btn);
        timerBtn = (ImageView) findViewById(R.id.timer_btn);
        moreBtn = (ImageView) findViewById(R.id.more_btn);

        pairBtn.setOnClickListener(onClickListener);
        lightBtn.setOnClickListener(onClickListener);
        streamingBtn.setOnClickListener(onClickListener);
        timerBtn.setOnClickListener(onClickListener);
        moreBtn.setOnClickListener(onClickListener);
    }

    public void switchFragment(Fragment target){
        getSupportFragmentManager().beginTransaction().replace(R.id.content, target).commit();
    }

    private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());

        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private ImageView.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View item) {
            pairBtn.setImageResource(R.mipmap.bluetooth_normal_nav);
            lightBtn.setImageResource(R.mipmap.light_normal_nav);
            streamingBtn.setImageResource(R.mipmap.music_normal_nav);
            timerBtn.setImageResource(R.mipmap.timer_normal_nav);
            moreBtn.setImageResource(R.mipmap.more_normal_nav);
            switch (item.getId()) {
                case R.id.pair_btn:
                    pairBtn.setImageResource(R.mipmap.bluetooth_active_nav);
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, pairFragment).commit();
                    mTitle.setText(R.string.title_pair);
                    break;
                case R.id.light_btn:
                    lightBtn.setImageResource(R.mipmap.light_active_nav);
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, lightFragment).commit();
                    mTitle.setText(R.string.title_light);
                    break;
                case R.id.streaming_btn:
                    streamingBtn.setImageResource(R.mipmap.music_active_nav);
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, streamingFragment).commit();
                    mTitle.setText(R.string.title_streaming);
                    break;
                case R.id.timer_btn:
                    timerBtn.setImageResource(R.mipmap.timer_active_nav);
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, timerFragment).commit();
                    mTitle.setText(R.string.title_timer);
                    break;
                case R.id.more_btn:
                    moreBtn.setImageResource(R.mipmap.more_active_nav);
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, moreFragment).commit();
                    mTitle.setText(R.string.title_more);
                    break;
            }
        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_pair:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, pairFragment).commit();
//                    actionBar.setTitle(R.string.title_pair);
                    return true;
                case R.id.navigation_light:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, lightFragment).commit();
//                    actionBar.setTitle(R.string.title_light);
                    return true;
                case R.id.navigation_streaming:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, streamingFragment).commit();
//                    actionBar.setTitle(R.string.title_streaming);
                    return true;
                case R.id.navigation_timer:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, timerFragment).commit();
//                    actionBar.setTitle(R.string.title_timer);
                    return true;
                case R.id.navigation_more:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, moreFragment).commit();
//                    actionBar.setTitle(R.string.title_more);
                    return true;
            }
            return false;
        }

    };

}
