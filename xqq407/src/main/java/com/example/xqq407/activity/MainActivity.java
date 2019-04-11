package com.example.xqq407.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xqq407.R;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    private TextView phone;
    private EditText edPhone;
    private TextView pwd;
    private EditText edPwd;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //ButterKnife
        ButterKnife.bind(this);
        //点击按钮登录
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edPhone.getText().toString();
                String pwd = edPwd.getText().toString();
                //判断手机号码跟密码
                if (phone.equals("18201642540") && pwd.equals("123456")) {
                    //与输入框一致跳转
                    Intent intent1 = new Intent(MainActivity.this, SJActivity.class);
                    startActivity(intent1);
                    finish();

                } else {
                    //与输入框不一致则吐司
                    Toast.makeText(MainActivity.this, "输入有误", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void initView() {
        phone = (TextView) findViewById(R.id.phone);
        edPhone = (EditText) findViewById(R.id.ed_phone);
        pwd = (TextView) findViewById(R.id.pwd);
        edPwd = (EditText) findViewById(R.id.ed_pwd);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }
}
