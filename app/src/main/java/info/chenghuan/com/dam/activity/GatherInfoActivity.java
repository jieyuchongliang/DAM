package info.chenghuan.com.dam.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import info.chenghuan.com.dam.R;
import info.chenghuan.com.dam.fragment.GatherFragment;
import info.chenghuan.com.dam.fragment.ShowFragment;

public class GatherInfoActivity extends AppCompatActivity {
    private int type;//扫描时，传过来的类型。
    private Fragment mGatherFragment;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.setCustomAnimations(android.R.animator.fade_in,
                            android.R.animator.fade_out);
//                    ft.setCustomAnimations(R.animator.in_from_right,R.animator.out_to_left);
                    ft.replace(R.id.content, new GatherFragment());
                    ft.commit();
                    return true;
                case R.id.navigation_dashboard:
                    FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                    ft2.setCustomAnimations(android.R.animator.fade_in,
                            android.R.animator.fade_out);
//                    ft2.setCustomAnimations(R.animator.in_from_right,R.animator.out_to_left);
                    ft2.replace(R.id.content, new ShowFragment());
                    ft2.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);
        mGatherFragment = new GatherFragment();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initEvent();
    }

    private void initEvent() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.animator.fade_in,
                android.R.animator.fade_out);
        ft.replace(R.id.content, mGatherFragment, "gather");
        ft.commit();
//        mGatherFragmentIsShowing = true;
    }

    /**
     * 扫码获取信息
     */
    public void startCaptureActivityForResult(int type) {
        this.type = type;
        new IntentIntegrator(this)
                .setOrientationLocked(false)
                .setCaptureActivity(CustomScanActivity.class) // 设置自定义的activity是CustomActivity
                .initiateScan(); // 初始化扫描
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(this, "内容为空", Toast.LENGTH_LONG).show();
            } else {
                // ScanResult 为 获取到的字符串
                String scan = intentResult.getContents();
                setText(scan);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    private TextView mProductNum1, mProductNum2, mProductNum3, mProductNum4, mProductNum5, mProductNum6, mProductNum7, mProductNum8, mProductNum9;

    /**
     * 显示扫描结果
     */
    private void setText(String scan) {
        switch (type) {
            case 1:
                mProductNum1 = (TextView) mGatherFragment.getView().findViewById(R.id.production_number_a1);
                mProductNum1.setText(scan);
                break;
            case 2:
                mProductNum2 = (TextView) mGatherFragment.getView().findViewById(R.id.production_number_a2);
                mProductNum2.setText(scan);
                break;
            case 3:
                mProductNum3 = (TextView) mGatherFragment.getView().findViewById(R.id.production_number_a3);
                mProductNum3.setText(scan);
                break;
            case 4:
                mProductNum4 = (TextView) mGatherFragment.getView().findViewById(R.id.production_number_a4);
                mProductNum4.setText(scan);
                break;
            case 5:
                mProductNum5 = (TextView) mGatherFragment.getView().findViewById(R.id.production_number_a5);
                mProductNum5.setText(scan);
                break;
            case 6:
                mProductNum6 = (TextView) mGatherFragment.getView().findViewById(R.id.production_number_a6);
                mProductNum6.setText(scan);
                break;
            case 7:

                mProductNum7 = (TextView) mGatherFragment.getView().findViewById(R.id.production_number_b1);
                mProductNum7.setText(scan);
                break;
            case 8:
                mProductNum8 = (TextView) mGatherFragment.getView().findViewById(R.id.production_number_b2);
                mProductNum8.setText(scan);
                break;
            case 9:
                mProductNum9.setText(scan);
                mProductNum9 = (TextView) mGatherFragment.getView().findViewById(R.id.production_number_k);
                break;
        }
    }
}
