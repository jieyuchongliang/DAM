package info.chenghuan.com.dam.activity;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.chenghuan.com.dam.R;

public class InspectionLotActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    private ListView mLvInspectionLot;
    private ImageView mIvBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection_lot);
        mLvInspectionLot = (ListView) findViewById(R.id.lv_inspection_lot);
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mIvBack.setOnClickListener(this);
        mLvInspectionLot.setOnItemClickListener(this);
        loadData();
    }

    /**
     * 加载数据
     */
    private void loadData() {
        // TODO: 2017/10/27 0027 模拟加载数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                final List<String> data = new ArrayList<String>();
                data.add("测试数据1");
                data.add("测试数据2");
                data.add("测试数据3");
                data.add("测试数据4");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mLvInspectionLot.setAdapter(new ArrayAdapter<String>(InspectionLotActivity.this,android.R.layout.simple_list_item_1,data));
                    }
                });
            }
        }).start();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"加载H5:"+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
