package com.example.xqq407.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xqq407.R;

public class LoginView extends LinearLayout {
    private TextView phoneview;
    private EditText edPhoneview;
    private TextView pwdview;
    private EditText edPwdview;
    private Button btnLoginview;

    public LoginView(Context context) {
        this(context, null);
    }

    public LoginView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoginView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context);
    }

    private void initData(Context context) {
        LayoutInflater.from(context).inflate(R.layout.login_view, this, true);
        initView();
    }

    private void initView() {
        phoneview = (TextView) findViewById(R.id.phoneview);
        edPhoneview = (EditText) findViewById(R.id.ed_phoneview);
        pwdview = (TextView) findViewById(R.id.pwdview);
        edPwdview = (EditText) findViewById(R.id.ed_pwdview);
        btnLoginview = (Button) findViewById(R.id.btn_loginview);
    }
}
