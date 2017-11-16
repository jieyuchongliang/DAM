package info.chenghuan.com.dam.activity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

import info.chenghuan.com.dam.R;

public class CustomScanActivity extends AppCompatActivity implements DecoratedBarcodeView.TorchListener, View.OnClickListener {
    private ImageView swichLight;
    private DecoratedBarcodeView mDBV;

    private CaptureManager captureManager;
    private boolean isLightOn = false;


    @Override
    protected void onPause() {
        super.onPause();
        captureManager.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        captureManager.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        captureManager.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        captureManager.onSaveInstanceState(outState);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return mDBV.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_scan);
        getSupportActionBar().hide();
        initView();
        mDBV.setTorchListener(this);

        // 如果没有闪光灯功能，就去掉相关按钮
        if (!hasFlash()) {
            swichLight.setVisibility(View.GONE);
        }

        //重要代码，初始化捕获
        captureManager = new CaptureManager(this, mDBV);
        captureManager.initializeFromIntent(getIntent(), savedInstanceState);
        captureManager.decode();
    }

    @Override
    public void onTorchOn() {
        isLightOn = true;
    }

    @Override
    public void onTorchOff() {
        isLightOn = false;
    }

    // 判断是否有闪光灯功能
    private boolean hasFlash() {
        return getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    private void initView() {
        swichLight = (ImageView) findViewById(R.id.btn_switch);
        swichLight.setOnClickListener(this);
        mDBV = (DecoratedBarcodeView) findViewById(R.id.dbv_custom);
    }


    @Override
    public void onClick(View v) {
        if (isLightOn) {
            mDBV.setTorchOff();
            swichLight.setImageResource(R.drawable.ic_off);
        } else {
            mDBV.setTorchOn();
            swichLight.setImageResource(R.drawable.ic_on);
        }
    }
}
