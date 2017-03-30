package com.test.windowsoftinputmodedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by TNT_17306 on 2017/3/30.
 */

public class BaseActivity extends AppCompatActivity implements View.OnClickListener, View.OnLayoutChangeListener {

    public final String TAG = this.getClass().getSimpleName();

    protected InputMethodManager mImm;
    protected View mRootView;

    protected TextView mTextView;
    protected EditText mEditText1;
    private ViewGroup mDecorView;
    private Button mBtnMainActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        init();
        initView();
        initListener();
    }

    protected void init() {
        mImm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mRootView = getContentView();
        mRootView.addOnLayoutChangeListener(this);
        initToolBar();
    }

    protected void initToolBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) {
            return;
        }

        actionBar.setTitle(TAG);
    }

    protected int getLayoutId() {
        return R.layout.activity_base_input_meth;
    }

    protected void initView() {
        mTextView = (TextView) findViewById(R.id.textView);
        mEditText1 = (EditText) findViewById(R.id.editText1);
        mBtnMainActivity = (Button) findViewById(R.id.btnMainActivity);
        mTextView.setText(getString(getStringId()));
    }

    protected int getStringId() {
        return -1;
    }


    protected void initListener() {
        mTextView.setOnClickListener(this);
        mEditText1.setOnClickListener(this);
        mBtnMainActivity.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView:
                mTextView.requestFocus();
                mImm.hideSoftInputFromWindow(mEditText1.getWindowToken(), 0);
                break;

            case R.id.editText1:

                break;

            case R.id.btnMainActivity:
                jump2Activity(MainActivity.class);
                break;
        }
        Log.e(TAG, "mDecorView top = " + mDecorView.getTop() + " ,bottom =" + mDecorView.getHeight());
        Log.e(TAG, "mRootView top = " + mRootView.getTop() + " ,bottom =" + mRootView.getHeight());
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Log.e(TAG, "onLayoutChange: " + v.toString() + " ,top = " + top + " ,bottom =" + bottom + " | oldTop = " + oldTop + " , oldBottom = " + oldBottom);
    }

    private View getContentView() {
        mDecorView = (ViewGroup) getWindow().getDecorView();
        ViewGroup content = (ViewGroup) mDecorView.getChildAt(0);
        return content.getChildAt(0);
    }

    protected void jump2Activity(Class clazz) {
        startActivity(new Intent(this, clazz));
    }

}
