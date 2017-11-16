package info.chenghuan.com.dam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.chenghuan.com.dam.R;
import info.chenghuan.com.dam.api.RetrofitManager;
import info.chenghuan.com.dam.bean.CertainRingDetailBean;
import info.chenghuan.com.dam.bean.ProjectInfoBean;
import rx.Subscriber;

public class DetailShowActivity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_detail_ring_num)
    TextView tvDetailRingNum;
    @BindView(R.id.tv_detail_belong_mileage)
    TextView tvDetailBelongMileage;
    @BindView(R.id.tv_detail_install_date)
    TextView tvDetailInstallDate;
    @BindView(R.id.tv_detail_syn_grouting)
    TextView tvDetailSynGrouting;
    @BindView(R.id.tv_detail_second_grouting)
    TextView tvDetailSecondGrouting;
    @BindView(R.id.tv_detail_appearance_check)
    TextView tvDetailAppearanceCheck;
    @BindView(R.id.tv_detail_work_measure)
    TextView tvDetailWorkMeasure;
    @BindView(R.id.tv_detail_out_factory_number)
    TextView tvDetailOutFactoryNumber;
    @BindView(R.id.iv_detail_check_pi)
    ImageView ivDetailCheckPi;
    @BindView(R.id.iv_detail_every_duct)
    ImageView ivDetailEveryDuct;
    @BindView(R.id.tv_detail_project_name)
    TextView tvDetailProjectName;
    @BindView(R.id.tv_detail_line_name)
    TextView tvDetailLineName;
    @BindView(R.id.tv_detail_product_unit)
    TextView tvDetailProductUnit;
    @BindView(R.id.tv_detail_title)
    TextView tvDetailTitle;
    private ImageView mIvBack;
    private String ringId;//当前显示信息的环号
    private String tsId;//当前显示信息的盾构号
    private String pieceMfidA1, pieceMfidA2, pieceMfidA3, pieceMfidA4, pieceMfidA5, pieceMfidA6, pieceMfidB1, pieceMfidB2, pieceMfidK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_show);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        tsId = intent.getStringExtra("tsId");
        ringId = intent.getStringExtra("ringId");
        pieceMfidA1 = intent.getStringExtra("pieceMfidA1");
        pieceMfidA2 = intent.getStringExtra("pieceMfidA2");
        pieceMfidA3 = intent.getStringExtra("pieceMfidA3");
        pieceMfidA4 = intent.getStringExtra("pieceMfidA4");
        pieceMfidA5 = intent.getStringExtra("pieceMfidA5");
        pieceMfidA6 = intent.getStringExtra("pieceMfidA6");
        pieceMfidB1 = intent.getStringExtra("pieceMfidB1");
        pieceMfidB2 = intent.getStringExtra("pieceMfidB2");
        pieceMfidK = intent.getStringExtra("pieceMfidK1");
        loadData(tsId, ringId);
    }

    /**
     * 数据加载
     */
    private void loadData(String tsId, String ringId) {
        RetrofitManager.toSubscribe(RetrofitManager.getApiService().getCertainRingDetailBean(tsId, ringId), new Subscriber<CertainRingDetailBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError------------: " + e.toString());
            }

            @Override
            public void onNext(CertainRingDetailBean certainRingDetailBean) {
                bindData(certainRingDetailBean);
            }
        });
        RetrofitManager.toSubscribe(RetrofitManager.getApiService().getProjectInfo(tsId), new Subscriber<ProjectInfoBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onNext: " + e.toString());
            }

            @Override
            public void onNext(ProjectInfoBean projectInfoBean) {
                Log.i(TAG, "onNext: " + projectInfoBean.getRows().size());
                bindProjectInfo(projectInfoBean);
            }
        });
    }

    /**
     * 显示工程信息数据
     *
     * @param projectInfoBean
     */
    private void bindProjectInfo(ProjectInfoBean projectInfoBean) {
        tvDetailProjectName.setText(getResources().getString(R.string.projectName) + projectInfoBean.getRows().get(0).getProjectName());
        tvDetailLineName.setText(getResources().getString(R.string.lineName) + projectInfoBean.getRows().get(0).getLineName());
        tvDetailProductUnit.setText(getResources().getString(R.string.workUnit) + projectInfoBean.getRows().get(0).getWorkCompany());
    }

    /**
     * 绑定数据
     *
     * @param certainRingDetailBean 详情数据bean
     */
    private void bindData(CertainRingDetailBean certainRingDetailBean) {
        tvDetailTitle.setText("第" + certainRingDetailBean.getRows().get(0).getRingId() + "环信息");
        tvDetailRingNum.setText(getResources().getString(R.string.ringNum) + certainRingDetailBean.getRows().get(0).getRingId());
        tvDetailBelongMileage.setText(getResources().getString(R.string.belongMile) + certainRingDetailBean.getRows().get(0).getDistance() / 1000 + "+" + certainRingDetailBean.getRows().get(0).getDistance() % 1000);
        tvDetailInstallDate.setText(getResources().getString(R.string.installDate) + certainRingDetailBean.getRows().get(0).getFinishTime());
        tvDetailSynGrouting.setText(getResources().getString(R.string.synGrouting)
                + (certainRingDetailBean.getRows().get(0).getGroutAmount1() == null ? "" : (certainRingDetailBean.getRows().get(0).getGroutAmount1() + "m  "))
                + (certainRingDetailBean.getRows().get(0).getGroutPressure1() == null ? "" : (certainRingDetailBean.getRows().get(0).getGroutPressure1() + "Mpa  "))
                + (certainRingDetailBean.getRows().get(0).getGroutTime1() == null ? "" : certainRingDetailBean.getRows().get(0).getGroutTime1()));
        tvDetailSecondGrouting.setText(getResources().getString(R.string.secondGrouting)
                + (TextUtils.isEmpty(certainRingDetailBean.getRows().get(0).getGroutAmount2()) ? "" : (certainRingDetailBean.getRows().get(0).getGroutAmount2() + "m  "))
                + (TextUtils.isEmpty(certainRingDetailBean.getRows().get(0).getGroutPressure2()) ? "" : (certainRingDetailBean.getRows().get(0).getGroutPressure2() + "Mpa  "))
                + (certainRingDetailBean.getRows().get(0).getGroutTime2() == null ? "" : certainRingDetailBean.getRows().get(0).getGroutTime2()));
        switch (certainRingDetailBean.getRows().get(0).getStatus()) {
            case 0:
                tvDetailAppearanceCheck.setText(getResources().getString(R.string.appearanceCheck) + "正常");
                break;
            case 1:
                tvDetailAppearanceCheck.setText(getResources().getString(R.string.appearanceCheck) + "破损");
                break;
            case 2:
                tvDetailAppearanceCheck.setText(getResources().getString(R.string.appearanceCheck) + "开裂");
                break;
            case 3:
                tvDetailAppearanceCheck.setText(getResources().getString(R.string.appearanceCheck) + "渗漏水");
                break;
            case 4:
                tvDetailAppearanceCheck.setText(getResources().getString(R.string.appearanceCheck) + "错台");
                break;
        }

        tvDetailWorkMeasure.setText(getResources().getString(R.string.workMeasure) + certainRingDetailBean.getRows().get(0).getTailHoffset() + "、" + certainRingDetailBean.getRows().get(0).getTailVoffset());
        tvDetailOutFactoryNumber.setText(getResources().getString(R.string.outFactoryNum) + certainRingDetailBean.getRows().get(0).getTailVoffset());
    }

    private static final String TAG = "DetailShowActivity";

    public void jianYanPi() {
        Toast.makeText(this, "检验批", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, InspectionLotActivity.class));
    }

    /**
     * 各管片的点击事件
     */
    public void geGuanPian() {
        Intent intent = new Intent(this, EveryDuctActivity.class);
        intent.putExtra("ringNum", ringId);
        intent.putExtra("pieceMfidA1", pieceMfidA1);
        intent.putExtra("pieceMfidA2", pieceMfidA2);
        intent.putExtra("pieceMfidA3", pieceMfidA3);
        intent.putExtra("pieceMfidA4", pieceMfidA4);
        intent.putExtra("pieceMfidA5", pieceMfidA5);
        intent.putExtra("pieceMfidA6", pieceMfidA6);
        intent.putExtra("pieceMfidB1", pieceMfidB1);
        intent.putExtra("pieceMfidB2", pieceMfidB2);
        intent.putExtra("pieceMfidK1", pieceMfidK );
        startActivity(intent);
    }

    @OnClick({R.id.iv_back, R.id.iv_detail_check_pi, R.id.iv_detail_every_duct})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_detail_check_pi:
                jianYanPi();
                break;
            case R.id.iv_detail_every_duct:
                geGuanPian();
                break;
        }
    }
}
