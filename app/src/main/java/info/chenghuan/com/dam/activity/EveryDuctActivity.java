package info.chenghuan.com.dam.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import info.chenghuan.com.dam.R;
import info.chenghuan.com.dam.adapter.EDRecyclerAdapter;
import info.chenghuan.com.dam.api.RetrofitManager;
import info.chenghuan.com.dam.bean.EveryDuctBean;
import rx.Subscriber;

public class EveryDuctActivity extends AppCompatActivity implements View.OnClickListener, OnLoadmoreListener, RetrofitManager.OnInternetListener {

    private RecyclerView mRecyclerView;
    private ImageView mIvBack;
    private SmartRefreshLayout smartRefreshLayout;//分页加载控件
    private List<EveryDuctBean.PieceListBean.RowsBean> everyDuctBeanList = new ArrayList<>();//各管片集合
    private int page = 1;//首次打开页面加载的是第一页
    private String ringNum;//当前显示信息的环号
    private EDRecyclerAdapter adapter;
    private String pieceMfidA1, pieceMfidA2, pieceMfidA3, pieceMfidA4, pieceMfidA5, pieceMfidA6, pieceMfidB1, pieceMfidB2, pieceMfidK;
    private String pieceInfo = new String("");//生产批号拼接
    private List<String> pieceInfoList = new ArrayList<>();//存储管片生成批号信息
    private LinearLayout emptyLayout;
    private LinearLayout noEnternet;//无网视图
    private ProgressDialog dialog;//加载提示
    private int responseNumber = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_every_duct);
        getIntentInfo();
        init();
    }

    /**
     * 初始化操作
     */
    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_every_duct);
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        emptyLayout = (LinearLayout) findViewById(R.id.no_content);
        smartRefreshLayout = (SmartRefreshLayout) findViewById(R.id.every_duct_refresh);
        noEnternet = (LinearLayout) findViewById(R.id.ll_empty);
        noEnternet.setOnClickListener(this);
        RetrofitManager.getInstance().setOnInternetListener(this);
        smartRefreshLayout.setOnLoadmoreListener(this);
        mIvBack.setOnClickListener(this);
        initEvent();
        loadData(page);
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new EDRecyclerAdapter(null, this);
        mRecyclerView.setAdapter(adapter);
    }

    private void loadData(final int page) {
        RetrofitManager.toSubscribe(RetrofitManager.getApiService().getEveryDuctBean(page, "10", pieceInfo), new Subscriber<EveryDuctBean>() {
            @Override
            public void onStart() {
                super.onStart();
                if (page == 1) {
                    dialog = ProgressDialog.show(EveryDuctActivity.this, null, "数据下载中...");
                }
            }

            @Override
            public void onCompleted() {
                smartRefreshLayout.finishLoadmore();
                noEnternet.setVisibility(View.GONE);
                dialog.hide();
            }

            @Override
            public void onError(Throwable e) {
                smartRefreshLayout.finishLoadmore();
                //首次加载如果出现问题则显示异常视图，分页加载不用显示。
                if (page == 1) {
                    emptyLayout.setVisibility(View.VISIBLE);
                }
                noEnternet.setVisibility(View.GONE);
                dialog.hide();
            }

            @Override
            public void onNext(EveryDuctBean everyDuctBean) {
                if (everyDuctBean.getPieceList().getRows().size() < 10) {
                    smartRefreshLayout.setEnableLoadmore(false);
                }
                dialog.hide();
                if (page == 1 && everyDuctBean.getPieceList().getRows().size() == 0) {
                    emptyLayout.setVisibility(View.VISIBLE);
                } else {
                    emptyLayout.setVisibility(View.GONE);
                }
                //将数据bean加入集合，刷新adapter
                everyDuctBeanList.addAll(everyDuctBean.getPieceList().getRows());
                adapter.setmList(everyDuctBeanList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private static final String TAG = "EveryDuctActivity";

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_empty:
                loadData(1);
                break;
        }
    }

    /**
     * 分页加载的回调监听
     *
     * @param refreshlayout
     */
    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        loadData(++page);
    }

    /**
     * 获取传递过来的数据
     *
     * @return
     */
    public void getIntentInfo() {
        Intent intent = getIntent();
        ringNum = intent.getStringExtra("ringNum");
        pieceMfidA1 = intent.getStringExtra("pieceMfidA1");
        pieceMfidA2 = intent.getStringExtra("pieceMfidA2");
        pieceMfidA3 = intent.getStringExtra("pieceMfidA3");
        pieceMfidA4 = intent.getStringExtra("pieceMfidA4");
        pieceMfidA5 = intent.getStringExtra("pieceMfidA5");
        pieceMfidA6 = intent.getStringExtra("pieceMfidA6");
        pieceMfidB1 = intent.getStringExtra("pieceMfidB1");
        pieceMfidB2 = intent.getStringExtra("pieceMfidB2");
        pieceMfidK = intent.getStringExtra("pieceMfidK1");
        pieceInfoList.add(pieceMfidA1);
        pieceInfoList.add(pieceMfidA2);
        pieceInfoList.add(pieceMfidA3);
        pieceInfoList.add(pieceMfidA4);
        pieceInfoList.add(pieceMfidA5);
        pieceInfoList.add(pieceMfidA6);
        pieceInfoList.add(pieceMfidB1);
        pieceInfoList.add(pieceMfidB2);
        pieceInfoList.add(pieceMfidK);
        if (pieceInfoList.size() > 0) {
            for (int i = 0; i < pieceInfoList.size(); i++) {
                if (i != (pieceInfoList.size() - 1)) {
                    pieceInfo += pieceInfoList.get(i) + ",";
                } else {
                    pieceInfo += pieceInfoList.get(i);
                }
            }
        }
    }

    /**
     * 没有网络时回调此方法
     */
    @Override
    public void internetListener() {
        noEnternet.setVisibility(View.VISIBLE);
    }

    /**
     * 当页面不可见时，推出dialog
     */
    @Override
    protected void onPause() {
        if (dialog != null) {
            dialog.dismiss();
        }
        super.onPause();
    }

}
