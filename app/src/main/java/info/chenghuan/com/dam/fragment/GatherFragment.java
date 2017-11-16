package info.chenghuan.com.dam.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import info.chenghuan.com.dam.MyApplication;
import info.chenghuan.com.dam.R;
import info.chenghuan.com.dam.activity.GatherInfoActivity;
import info.chenghuan.com.dam.adapter.ShowPhotoAdapter;
import info.chenghuan.com.dam.adapter.TsidListAdapter;
import info.chenghuan.com.dam.api.RetrofitManager;
import info.chenghuan.com.dam.bean.GatherBean;
import info.chenghuan.com.dam.bean.LoginBean;
import info.chenghuan.com.dam.bean.ProjectInfoBean;
import info.chenghuan.com.dam.bean.SaveBean;
import info.chenghuan.com.dam.bean.SaveParameterBean;
import info.chenghuan.com.dam.bean.UploadingPhotoBean;
import info.chenghuan.com.dam.utils.Base64Util;
import info.chenghuan.com.dam.utils.TakePhotoUtils;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/10/24 0024.
 */

public class GatherFragment extends Fragment implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    private static final int REQ_CODE_PERMISSION = 0x1111;
    private static final int CAMERA_PERMISSIONS_REQUEST_CODE = 0x2222;//申请权限的标记
    @BindView(R.id.tv_gather_mileage)
    TextView tvGatherMileage;
    @BindView(R.id.tv_gather_date)
    TextView tvGatherDate;
    @BindView(R.id.tv_gather_m)
    TextView tvGatherM;
    @BindView(R.id.tv_gather_mpa)
    TextView tvGatherMpa;
    @BindView(R.id.tv_gather_grouting_date)
    TextView tvGatherGroutingDate;
    @BindView(R.id.iv_product_number1)
    ImageView ivProductNumber1;
    @BindView(R.id.iv_product_number2)
    ImageView ivProductNumber2;
    @BindView(R.id.iv_product_number3)
    ImageView ivProductNumber3;
    @BindView(R.id.iv_product_number4)
    ImageView ivProductNumber4;
    @BindView(R.id.iv_product_number5)
    ImageView ivProductNumber5;
    @BindView(R.id.iv_product_number6)
    ImageView ivProductNumber6;
    @BindView(R.id.iv_product_number7)
    ImageView ivProductNumber7;
    @BindView(R.id.iv_product_number8)
    ImageView ivProductNumber8;
    @BindView(R.id.iv_product_number9)
    ImageView ivProductNumber9;
    @BindView(R.id.tv_gather_project_name)
    TextView tvGatherProjectName;
    @BindView(R.id.tv_gather_work_unit)
    TextView tvGatherWorkUnit;
    Unbinder unbinder;
    @BindView(R.id.et_ring_number)
    EditText etRingNumber;
    @BindView(R.id.tv_syn)
    TextView tvSyn;
    @BindView(R.id.et_grouting_quantity)
    EditText etGroutingQuantity;
    @BindView(R.id.et_grouting_pressure)
    EditText etGroutingPressure;
    @BindView(R.id.production_number_a1)
    TextView productionNumberA1;
    @BindView(R.id.production_number_a2)
    TextView productionNumberA2;
    @BindView(R.id.production_number_a3)
    TextView productionNumberA3;
    @BindView(R.id.production_number_a4)
    TextView productionNumberA4;
    @BindView(R.id.production_number_a5)
    TextView productionNumberA5;
    @BindView(R.id.production_number_a6)
    TextView productionNumberA6;
    @BindView(R.id.production_number_b1)
    TextView productionNumberB1;
    @BindView(R.id.production_number_b2)
    TextView productionNumberB2;
    @BindView(R.id.production_number_k)
    TextView productionNumberK;
    @BindView(R.id.image_take_photo)
    ImageView imageTakePhoto;
    @BindView(R.id.et_horizontal_offset)
    EditText etHorizontalOffset;
    @BindView(R.id.et_vertical_offset)
    EditText etVerticalOffset;
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.ll_image_container)
    LinearLayout llImageContainer;
    @BindView(R.id.tv_show_tsid)
    TextView tvShowTsid;
    @BindView(R.id.tv_show_tsid_pop)
    TextView tvShowTsidPop;
    private Activity mActivity;
    private String mQulityRingNum;//质量状况
    private View mView;
    private List<String> mImageList = new ArrayList<>();
    private String strImage;//拍照所得图片的string表示形式
    private List<String> mImageResponseId = new ArrayList<>();//上传图片所得id的集合
    private ShowPhotoAdapter mShowPhotoAdapter;
    private RecyclerView mLvShowPhoto;
    private String preFixList;
    private boolean photoIsSave = false;//图片是否保存成功的标记
    private String sdPath;//SD卡的路径
    private String picPath;//图片存储路径
    private int position = 0;//当前正在上传的图片，在集合中的位置
    private List<Bitmap> mBitmapList = new ArrayList<>();//将所有拍照后的照片保存到此集合中，用来展示。
    private ProgressDialog progressDialog;
    private PopupWindow popWnd;//盾构段号选择popupwindow
    private TsidListAdapter tsidListAdapter;
    private List<ProjectInfoBean.RowsBean> tsidList = new ArrayList<>();
    private Uri uri;//拍照存储图片的uri

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_gather, container, false);
        initEvent();
        unbinder = ButterKnife.bind(this, mView);
//        getTsId();
        return mView;
    }

    /**
     * 联网获取盾构段号
     */
    private void getTsId() {
//        RetrofitManager.toSubscribe(RetrofitManager.getApiService().getProjectInfo(), new Subscriber<ProjectInfoBean>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.i(TAG, "onError: " +e.toString());
//            }
//
//            @Override
//            public void onNext(ProjectInfoBean projectInfoBean) {
//                Log.i(TAG, "onNext: " + projectInfoBean.getWorkCompany());
//            }
//        });
    }

    private void initEvent() {
        Spinner spinner = (Spinner) mView.findViewById(R.id.spinner_state);
        spinner.setOnItemSelectedListener(this);
        mLvShowPhoto = (RecyclerView) mView.findViewById(R.id.lv_show_photo);
        mShowPhotoAdapter = new ShowPhotoAdapter(getActivity(), mBitmapList);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mLvShowPhoto.setLayoutManager(manager);
        mLvShowPhoto.setAdapter(mShowPhotoAdapter);
    }


    /**
     * 网络加载数据
     */
    // TODO: 2017/10/24 0024 后期直接改掉   Subscriber<Object>  中的泛型为自己封装的bean，然后改一下接口就可以了。
    private void loadData() {
        RetrofitManager.toSubscribe(RetrofitManager.getApiService().login("", "", ""), new Subscriber<LoginBean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(LoginBean loginBean) {
                GatherBean bean = new GatherBean("DK18+516~DK18+518", "2017-10-16", "2.9m³", "0.17Mpa", "2017-10-16 10:31", "清华园隧道", "中国中铁十四局集团有限公司");
                tvGatherMileage.setText(bean.getMileage());
                tvGatherDate.setText(bean.getDate());
                tvGatherM.setText(bean.getGroutingM());
                tvGatherMpa.setText(bean.getGroutingMpa());
                tvGatherGroutingDate.setText(bean.getGroutingDate());
                tvGatherProjectName.setText(bean.getProgictName());
                tvGatherWorkUnit.setText(bean.getProgictUnit());
            }
        });
    }


    /**
     * 点击保存按钮调用的方法
     */
    private void save() {
        String groutPressure2 = etGroutingPressure.getText().toString().trim();
        String groutAmount2 = etGroutingQuantity.getText().toString().trim();
        String horizontalOffSet = etHorizontalOffset.getText().toString().trim();
        String verticalOffSet = etVerticalOffset.getText().toString().trim();
        if (TextUtils.isEmpty(groutAmount2)) {
            Toast.makeText(getActivity(), "注浆量不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(groutPressure2)) {
            Toast.makeText(getActivity(), "注浆压力不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(horizontalOffSet)) {
            Toast.makeText(getActivity(), "水平偏移不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(verticalOffSet)) {
            Toast.makeText(getActivity(), "竖向偏移不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        SaveParameterBean bean = new SaveParameterBean();
        bean.setTsId("2");
        bean.setRingId("19080");
        bean.setStatus("1");
        bean.setFinishTime("1509330360000");
        bean.setGroutTime2("1509330360000");
        bean.setGroutDuration2("4");
        bean.setKPosition("2");
        bean.setProblemPosition("问题位置");
        bean.setQualityDetail("质量问题描述");
        bean.setFixDetail("修复措施");
        bean.setFixer("修复人");
        bean.setFixTime("1509330480000");
        bean.setAuditor("审核人");
        bean.setAuditStatus("1");
        bean.setGroutAmount2(groutAmount2);
        bean.setGroutPressure2(groutPressure2);
        bean.setHorizonalOffset(horizontalOffSet);
        bean.setVerticalOffset(verticalOffSet);
        bean.setPieceMfidA1(productionNumberA1.getText().toString());
        bean.setPieceMfidA2(productionNumberA2.getText().toString());
        bean.setPieceMfidA3(productionNumberA3.getText().toString());
        bean.setPieceMfidA4(productionNumberA4.getText().toString());
        bean.setPieceMfidA5(productionNumberA5.getText().toString());
        bean.setPieceMfidA6(productionNumberA6.getText().toString());
        bean.setPieceMfidB1(productionNumberB2.getText().toString());
        bean.setPieceMfidB2(productionNumberB2.getText().toString());
        bean.setPieceMfidK1(productionNumberK.getText().toString());
        bean.setDistance("18200");
        bean.setPreFixList(mImageResponseId);
        bean.setPostFixList(mImageResponseId);
        Gson gson = new Gson();
        String postInfo = gson.toJson(bean);
        Log.i(TAG, postInfo);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), postInfo);
        RetrofitManager.toSubscribe(RetrofitManager.getApiService().saveMessage(body), new Subscriber<SaveBean>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onNext: " + e.toString());
                Toast.makeText(getActivity(), "保存数据异常，请重试", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(SaveBean saveBean) {
                if (saveBean.getSuccess()) {
                    Toast.makeText(getActivity(), "数据保存成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "数据保存失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 照片全部上传完毕会调用此方法，进行下一步的数据保存
     */
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Log.i(TAG, "图片上传完毕" + mImageResponseId.size());
                    photoIsSave = true;
                    save();
                    progressDialog.hide();
                    progressDialog.dismiss();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    /**
     * 点击保存时首先保存图片，获取图片ID
     */
    private void savePhoto() {
        Log.i(TAG, "savePhoto: " + mImageList.size());
        if (mImageList.size() > 0 && mImageList.size() > position) {
            if (mImageList.get(0) == null) {
                Log.e(TAG, "mImageList: 空");
                return;
            }
            RequestBody requestFile = RequestBody.create(MediaType.parse("text/plain"), mImageList.get(position++));
            MultipartBody.Part body = MultipartBody.Part.createFormData("strImage", null, requestFile);
            RetrofitManager.toSubscribe(RetrofitManager.getApiService().getUploadingPhotoBean(body), new Subscriber<UploadingPhotoBean>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    Log.i(TAG, "onError: " + e.toString());
                    Toast.makeText(getActivity(), " 保存图片出现问题，请重新点击保存", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onNext(UploadingPhotoBean uploadingPhotoBean) {
                    Log.i(TAG, "onNext: " + position + ":" + uploadingPhotoBean.getMessage());
                    mImageResponseId.add(uploadingPhotoBean.getMessage());
                    if (position == (mImageList.size())) {
                        Message message = new Message();
                        message.what = 1;
                        handler.sendMessage(message);
                    }
                    savePhoto();
                }
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 控件点击事件的处理
     *
     * @param view 控件
     */
    @OnClick({R.id.tv_show_tsid, R.id.btn_save, R.id.tv_syn, R.id.image_take_photo, R.id.iv_product_number1, R.id.iv_product_number2, R.id.iv_product_number3, R.id.iv_product_number4, R.id.iv_product_number5, R.id.iv_product_number6, R.id.iv_product_number7, R.id.iv_product_number8, R.id.iv_product_number9})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                position = 0;
                if (mBitmapList.size() == 0 || photoIsSave) {//判断图片是否保存成功，若成功则不再重复保存，直接进入下一步，保存数据bean。
                    save();
                    return;
                }
                savePhoto();
                progressDialog = ProgressDialog.show(getActivity(), null, "数据上传...");
                break;
            case R.id.tv_syn:
                String ringNum = etRingNumber.getText().toString().trim();
                if (TextUtils.isEmpty(ringNum)) {
                    Toast.makeText(getActivity(), "请先输入成隧环号", Toast.LENGTH_SHORT).show();
                } else {
                    loadData();
                }
                break;
            case R.id.image_take_photo:
                //如果手机版本大于6.0，则动态申请权限而后拍照。否则直接拍照获取图片。
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                            || ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, CAMERA_PERMISSIONS_REQUEST_CODE);
                    } else {//有权限直接调用系统相机拍照
                        takePhoto();
                    }
                } else {
                    takePhoto();
                }
                break;
            case R.id.tv_show_tsid:
                if (popWnd != null && popWnd.isShowing()) {
                    return;
                }
                showTsidSelect();
                break;
            case R.id.iv_product_number1:
                scan(1);
                break;
            case R.id.iv_product_number2:
                scan(2);
                break;
            case R.id.iv_product_number3:
                scan(3);
                break;
            case R.id.iv_product_number4:
                scan(4);
                break;
            case R.id.iv_product_number5:
                scan(5);
                break;
            case R.id.iv_product_number6:
                scan(6);
                break;
            case R.id.iv_product_number7:
                scan(7);
                break;
            case R.id.iv_product_number8:
                scan(8);
                break;
            case R.id.iv_product_number9:
                scan(9);
                break;
        }
    }

    /**
     * 调用相机拍照
     */
    private void takePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //获取SD卡的路径
        sdPath = Environment.getExternalStorageDirectory().getPath();
        picPath = sdPath + "/" + getTime() + ".png";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            uri = FileProvider.getUriForFile(getContext(), "info.chenghuan.com.dam", new File(picPath));
        } else {
            uri = Uri.fromFile(new File(picPath));
        }
        //为拍摄的图片指定一个存储的路径
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, 1);
    }

    /**
     * 盾构段号下啦框
     */
    private void showTsidSelect() {
        loadTsidInfo();
        View contentView = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.item_tsid_select, null);
        ListView tsidListView = (ListView) contentView.findViewById(R.id.lv_tsid);
        tsidListAdapter = new TsidListAdapter(MyApplication.getContext(), null);
        tsidListView.setAdapter(tsidListAdapter);
        tsidListView.setOnItemClickListener(this);
        popWnd = new PopupWindow(MyApplication.getContext());
        popWnd.setFocusable(true);
        popWnd.setContentView(contentView);
        popWnd.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popWnd.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popWnd.showAsDropDown(tvShowTsidPop, 0, 13);
    }

    /**
     * 获取Tsid信息
     */
    private void loadTsidInfo() {
        RetrofitManager.toSubscribe(RetrofitManager.getApiService().getProjectInfo(""), new Subscriber<ProjectInfoBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ProjectInfoBean projectInfoBean) {
                tsidList.addAll(projectInfoBean.getRows());
                Log.i(TAG, "onNext: " + projectInfoBean.getRows().size());
                tsidListAdapter.setList(projectInfoBean.getRows());
                tsidListAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * 点击扫描按钮调用的方法
     */
    public void scan(int type) {
        requestPermission();
        switch (type) {
            case 1:
                ((GatherInfoActivity) mActivity).startCaptureActivityForResult(1);
                break;
            case 2:
                ((GatherInfoActivity) mActivity).startCaptureActivityForResult(2);
                break;
            case 3:
                ((GatherInfoActivity) mActivity).startCaptureActivityForResult(3);
                break;
            case 4:
                ((GatherInfoActivity) mActivity).startCaptureActivityForResult(4);
                break;
            case 5:
                ((GatherInfoActivity) mActivity).startCaptureActivityForResult(5);
                break;
            case 6:
                ((GatherInfoActivity) mActivity).startCaptureActivityForResult(6);
                break;
            case 7:
                ((GatherInfoActivity) mActivity).startCaptureActivityForResult(7);
                break;
            case 8:
                ((GatherInfoActivity) mActivity).startCaptureActivityForResult(8);
                break;
            case 9:
                ((GatherInfoActivity) mActivity).startCaptureActivityForResult(9);
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1) {
                saveImageToList();
                /**
                 * 这种方法是通过内存卡的路径进行读取图片，所以得到的图片是拍摄的原图
                 */
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 16;//对图片进行压缩，压缩比为 1 : 16 * 16;
                Bitmap bitmap = BitmapFactory.decodeFile(picPath, options);
                mBitmapList.add(bitmap);
                mShowPhotoAdapter.setBitmapList(mBitmapList);
                mShowPhotoAdapter.notifyDataSetChanged();
                Log.e("sdPath2", picPath);
                llImageContainer.setVisibility(View.VISIBLE);
            }
        }
    }

    /**
     * 将返回的图片存储到文件再存储到集合中
     */
    private void saveImageToList() {
        BitmapFactory.Options options = TakePhotoUtils.getOptions(picPath, 6);
        Bitmap bitmap = BitmapFactory.decodeFile(picPath, options);
        strImage = Base64Util.bitmapToBase64(bitmap);
        mImageList.add(strImage);
        Toast.makeText(getActivity(), "" + mImageList.size(), Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取时间戳
     *
     * @return
     */
    public String getTime() {
        long time = System.currentTimeMillis() / 1000;//获取系统时间的10位的时间戳
        String str = String.valueOf(time);
        return str;
    }


    /**
     * 请求相机拍照权限
     */
    private void requestPermission() {
        //打开扫码Activity
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //没有相机权限，申请
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, REQ_CODE_PERMISSION);
        } else {
            // 有相机权限，继续。
            return;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQ_CODE_PERMISSION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 用户早已同意权限
                    return;
                } else {
                    // 用户还未同意权限
                    Toast.makeText(getActivity(), "请先设置相机权限为同意", Toast.LENGTH_LONG).show();
                }
            }
            break;
            case CAMERA_PERMISSIONS_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    takePhoto();
                } else {
                    Toast.makeText(getActivity(), "请允许相应的权限", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    /**
     * spnner的选择监听回调方法
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] languages = getResources().getStringArray(R.array.state);
        mQulityRingNum = languages[position];
//                Toast.makeText(MyApplication.getContext(), "你点击的是:"+languages[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private static final String TAG = "GatherFragment";

    /**
     * 点击盾构段号条目的回调
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tvShowTsid.setText(tsidList.get(position).getWorksiteName());
        popWnd.dismiss();
    }
}
