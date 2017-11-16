package info.chenghuan.com.dam.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import info.chenghuan.com.dam.R;
import info.chenghuan.com.dam.fragment.GatherFragment;
import info.chenghuan.com.dam.fragment.ShowFragment;

public class InfoGatherActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTvGather,mTvShow;
    private Fragment mGatherFragment,mShowFragment;
    private boolean mGatherFragmentIsShowing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_gather);
        mGatherFragment= new GatherFragment();
        mShowFragment = new ShowFragment();
        initView();
        initEvent();
    }

    private void initView() {
        mTvGather = (TextView) findViewById(R.id.tv_gather);
        mTvShow = (TextView) findViewById(R.id.tv_show);
        mTvGather.setOnClickListener(this);
        mTvShow.setOnClickListener(this);
    }

    private void initEvent() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_content,mGatherFragment,"gather");
       
        mGatherFragmentIsShowing =true;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft =fm.beginTransaction();
        switch (v.getId()){
            case R.id.tv_gather:
                if (mGatherFragmentIsShowing){
                    return;
                }else {
                    ft.replace(R.id.fragment_content, mGatherFragment);
                    mGatherFragmentIsShowing = true;
                }
                break;
            case R.id.tv_show:
                if (!mGatherFragmentIsShowing){
                    return;
                }else {
                    ft.replace(R.id.fragment_content,mShowFragment);
                    mGatherFragmentIsShowing = false;
                }
                break;
        }
        ft.commit();
    }
}
