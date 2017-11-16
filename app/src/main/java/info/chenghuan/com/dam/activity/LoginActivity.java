package info.chenghuan.com.dam.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.TtsSpan;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chaychan.viewlib.PowerfulEditText;

import info.chenghuan.com.dam.R;
import info.chenghuan.com.dam.api.RetrofitManager;
import info.chenghuan.com.dam.bean.LoginBean;
import rx.Subscriber;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnLogin;
    private EditText mEtName;
    private PowerfulEditText mEtPassword;
    private String mName, mPassword;
    private ProgressDialog dialog;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtPassword = (PowerfulEditText) findViewById(R.id.et_password);
        mBtnLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
        }
    }

    private void login() {
        mName = mEtName.getText().toString().trim();
        mPassword = mEtPassword.getText().toString().trim();

        if (TextUtils.isEmpty(mName)) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(mPassword)) {
            // TODO: 2017/10/24 0024 网络
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String password = new String(Base64.encode(mPassword.getBytes(),Base64.DEFAULT));
        RetrofitManager.toSubscribe(RetrofitManager.getApiService().login(mName,password,"1F6C8BBB65ABA48CFEB959B7D4642FCB"), new Subscriber<LoginBean>() {
            @Override
            public void onStart() {
                dialog = ProgressDialog.show(LoginActivity.this, null, "正在登陆中");
            }

            @Override
            public void onCompleted() {
                dialog.hide();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(LoginActivity.this,"出现意外，请稍后重试"+e.toString(),Toast.LENGTH_SHORT).show();
                dialog.hide();
            }

            @Override
            public void onNext(LoginBean loginBean) {
                if (loginBean.getResult()){
                    startActivity(new Intent(LoginActivity.this, GatherInfoActivity.class));
                    finish();
                }else {
                    dialog.hide();
                    Toast.makeText(LoginActivity.this,"账号或密码有误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        if (dialog!=null){
            dialog.dismiss();
        }
        super.onPause();
    }

    private static final String TAG = "LoginActivity";
}
