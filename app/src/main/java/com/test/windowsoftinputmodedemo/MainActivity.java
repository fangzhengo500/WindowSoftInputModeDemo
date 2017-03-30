package com.test.windowsoftinputmodedemo;

import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private Button mBtnStateUnspecified;
    private Button mBtnStateUnchanged;
    private Button mBtnStateAlwaysHidden;
    private Button mBtnStateVisible;
    private Button mBtnStateAlwaysVisible;
    private Button mBtnAdjustUnspecified;
    private Button mBtnAdjustResize;
    private Button mBtnAdjustPan;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mBtnStateUnspecified = (Button) findViewById(R.id.btnStateUnspecified);
        mBtnStateUnchanged = (Button) findViewById(R.id.btnStateUnchanged);
        mBtnStateAlwaysHidden = (Button) findViewById(R.id.btnStateAlwaysHidden);
        mBtnStateVisible = (Button) findViewById(R.id.btnStateVisible);
        mBtnStateAlwaysVisible = (Button) findViewById(R.id.btnStateAlwaysVisible);
        mBtnAdjustUnspecified = (Button) findViewById(R.id.btnAdjustUnspecified);
        mBtnAdjustResize = (Button) findViewById(R.id.btnAdjustResize);
        mBtnAdjustPan = (Button) findViewById(R.id.btnAdjustPan);
    }

    @Override
    protected void initListener() {
        mBtnStateUnspecified.setOnClickListener(this);
        mBtnStateUnchanged.setOnClickListener(this);
        mBtnStateAlwaysHidden.setOnClickListener(this);
        mBtnStateVisible.setOnClickListener(this);
        mBtnStateAlwaysVisible.setOnClickListener(this);
        mBtnAdjustUnspecified.setOnClickListener(this);
        mBtnAdjustResize.setOnClickListener(this);
        mBtnAdjustPan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStateUnspecified:
                jump2Activity(StateUnspecifiedActivity.class);
                break;

            case R.id.btnStateUnchanged:
                jump2Activity(StateUnchangedActivity.class);
                break;

            case R.id.btnStateAlwaysHidden:
                jump2Activity(StateAlwaysHiddenActivity.class);
                break;

            case R.id.btnStateVisible:
                jump2Activity(StateVisibleActivity.class);
                break;

            case R.id.btnStateAlwaysVisible:
                jump2Activity(StateAlwaysVisibleActivity.class);
                break;

            case R.id.btnAdjustUnspecified:
                jump2Activity(AdjustUnspecifiedActivity.class);
                break;

            case R.id.btnAdjustResize:
                jump2Activity(AdjustResizeActivity.class);
                break;

            case R.id.btnAdjustPan:
                jump2Activity(AdjustPanActivity.class);
                break;

        }
    }
}
