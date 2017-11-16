package info.chenghuan.com.dam.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import info.chenghuan.com.dam.MyApplication;
import info.chenghuan.com.dam.R;
import info.chenghuan.com.dam.activity.DetailShowActivity;
import info.chenghuan.com.dam.adapter.ShowFragmentAdapter;
import info.chenghuan.com.dam.adapter.TsidListAdapter;
import info.chenghuan.com.dam.api.RetrofitManager;
import info.chenghuan.com.dam.bean.ProjectInfoBean;
import info.chenghuan.com.dam.bean.ShowBean;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/10/24 0024.
 */

public class ShowFragment extends Fragment implements OnLoadmoreListener, View.OnClickListener, AdapterView.OnItemClickListener {
    private View view;
    private ListView listView;
    private ShowFragmentAdapter adapter;
    private int pageNumber;
    private List<ShowBean.RowsBean> rowsBeanList = new ArrayList<>();
    private SmartRefreshLayout refreshLayout;
    private ProgressDialog dialog;//加载提示
    private LinearLayout llEmpty;//空试图
    private LinearLayout llTsidSeclect;//盾构段号选择按钮
    private LinearLayout llTopLayout;//页面顶部布局
    private PopupWindow popWnd;//盾构段号选择popupwindow
    private String tsid = "1";//盾构段号默认是1
    private List<ProjectInfoBean.RowsBean> tsidList = new ArrayList<>();//盾构段号List

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_show, container, false);
        init();
        return view;
    }

    /**
     * 初始化操作
     */
    private void init() {
        listView = (ListView) view.findViewById(R.id.rv_show);
        refreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh);
        llEmpty = (LinearLayout) view.findViewById(R.id.ll_empty);
        llTsidSeclect = (LinearLayout) view.findViewById(R.id.ll_tsid_select);
        llTopLayout = (LinearLayout) view.findViewById(R.id.ll_top_layout);
        llTsidSeclect.setOnClickListener(this);
        llEmpty.setOnClickListener(this);
        refreshLayout.setOnLoadmoreListener(this);
        pageNumber = 1;
        initEvent();
        RetrofitManager.getInstance().setOnInternetListener(new RetrofitManager.OnInternetListener() {
            @Override
            public void internetListener() {
                llEmpty.setVisibility(View.VISIBLE);
            }
        });
        loadData(1,"1");//默认加载的是盾构段号1的数据
        loadTsid();
    }

    /**
     * 获取Tsid信息
     */
    private void loadTsid() {
        RetrofitManager.toSubscribe(RetrofitManager.getApiService().getProjectInfo(""), new Subscriber<ProjectInfoBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ProjectInfoBean projectInfoBean) {
                Log.i(TAG, "onNext: " + projectInfoBean.getRows().size());
                tsidList.addAll(projectInfoBean.getRows());
            }
        });
    }

    /**
     * 事件操作
     */
    private void initEvent() {
        adapter = new ShowFragmentAdapter(MyApplication.getContext(), null);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MyApplication.getContext(), DetailShowActivity.class);
                intent.putExtra("tsId", rowsBeanList.get(position).getTsId());
                intent.putExtra("ringId", rowsBeanList.get(position).getRingId());
                intent.putExtra("pieceMfidA1", rowsBeanList.get(position).getPieceMfidA1());
                intent.putExtra("pieceMfidA2", rowsBeanList.get(position).getPieceMfidA2());
                intent.putExtra("pieceMfidA3", rowsBeanList.get(position).getPieceMfidA3());
                intent.putExtra("pieceMfidA4", rowsBeanList.get(position).getPieceMfidA4());
                intent.putExtra("pieceMfidA5", rowsBeanList.get(position).getPieceMfidA5());
                intent.putExtra("pieceMfidA6", rowsBeanList.get(position).getPieceMfidA6());
                intent.putExtra("pieceMfidB1", rowsBeanList.get(position).getPieceMfidB1());
                intent.putExtra("pieceMfidB2", rowsBeanList.get(position).getPieceMfidB2());
                intent.putExtra("pieceMfidK1", rowsBeanList.get(position).getPieceMfidK1());
                startActivity(intent);
            }
        });
    }

    /**
     * 数据加载
     */
    // TODO: 2017/10/31 0031 请求参数问题待解决
    private void loadData(final int page,String tsid) {
        RetrofitManager.toSubscribe(RetrofitManager.getApiService().getShowBean(page, "20", tsid), new Subscriber<ShowBean>() {
            @Override
            public void onStart() {
                super.onStart();
                if (page == 1) {
                    dialog = ProgressDialog.show(getActivity(), null, "加载数据...");
                }
            }

            @Override
            public void onCompleted() {
                if (dialog.isShowing()) {
                    dialog.hide();
                    dialog.dismiss();
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "------------------onError: " + e.toString());
                llEmpty.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNext(ShowBean showBean) {
                llEmpty.setVisibility(View.GONE);
                rowsBeanList.addAll(showBean.getRows());
                refreshLayout.finishLoadmore();
                refreshLayout.finishRefresh();
                adapter.setmData(rowsBeanList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private static final String TAG = "ShowFragment";

    /**
     * 加载更多的方法回调
     *
     * @param refreshlayout
     */
    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        loadData(++pageNumber,tsid);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_empty:
                loadData(1,"1");
                break;
            case R.id.ll_tsid_select:
                showTsIdSelectPop();
                break;
        }
    }

    /**
     * 盾构段号的选择下列框
     */
    private void showTsIdSelectPop() {
        View contentView = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.item_tsid_select, null);
        ListView tsidListView = (ListView) contentView.findViewById(R.id.lv_tsid);
        tsidListView.setAdapter(new TsidListAdapter(MyApplication.getContext(),tsidList));
        tsidListView.setOnItemClickListener(this);
        popWnd = new PopupWindow(MyApplication.getContext());
        popWnd.setFocusable(true);
        popWnd.setContentView(contentView);
        popWnd.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popWnd.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popWnd.showAsDropDown(llTopLayout);
    }

    /**
     * 点击盾构段号的回调方法
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        loadData(1,tsidList.get(position).getTsId());
        tsid = tsidList.get(position).getTsId();
        rowsBeanList.clear();
        popWnd.dismiss();
    }
}
