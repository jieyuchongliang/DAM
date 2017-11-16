package info.chenghuan.com.dam.api;

import info.chenghuan.com.dam.bean.CertainRingDetailBean;
import info.chenghuan.com.dam.bean.EveryDuctBean;
import info.chenghuan.com.dam.bean.LoginBean;
import info.chenghuan.com.dam.bean.ProjectInfoBean;
import info.chenghuan.com.dam.bean.SaveBean;
import info.chenghuan.com.dam.bean.ShowBean;
import info.chenghuan.com.dam.bean.UploadingPhotoBean;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 860617010 on 2017/6/6.
 */

public interface ApiService {
//    String BASE_URL = "http://61.237.239.217:10084/";
//    String BASE_URL = "http://www.r93535.com/dg/";
//    String BASE_URL = "http://61.237.239.217:10084/dgzl/" ;
    String BASE_URL = "http://cars.crbim.win/QHY-Shield/" ;


    /**
     * 登陆接口
     * @param account 用户名
     * @param password 密码
     * @param DESpd
     * @return
     */
    @FormUrlEncoded
    @POST("sso/login")
    Observable<LoginBean> login(@Field("account") String account,
                                   @Field("password") String password,
                                   @Field("DESpd") String DESpd);

    /**
     * 获取工程信息
     * @return
     */
    @GET("appRingQuality/getRingWorksiteMap")
    Observable<ProjectInfoBean> getProjectInfo(@Query("tsId") String tsId);


    /**
     * 获取一览列表
     * @param page
     * @param rows
     * @param tsId
     * @return
     */
    @FormUrlEncoded
    @POST("ringQuality/getRingQualityList")
    Observable<ShowBean> getShowBean(@Field("page") int page,
                                     @Field("rows") String rows,
                                     @Field("tsId") String tsId);

    /**
     * 某一环详细信息接口
     * @param tsId 盾构号
     * @param ringId 环号
     * @return
     */
    @FormUrlEncoded
    @POST("appRingQuality/getRingDetail")
    Observable<CertainRingDetailBean> getCertainRingDetailBean(@Field("tsId") String tsId,
                                                               @Field("ringId") String ringId);

    /**
     * 上传图片的接口
     * @return
     */
    @Multipart
    @POST("appRingQuality/upload")
    Observable<UploadingPhotoBean> getUploadingPhotoBean(@Part MultipartBody.Part file);

    /**
     *  保存信息到服务器的接口
     * @param body 数据bean的body对象
     * @return
     */
    @POST("appRingQuality/newRingInfo")
    Observable<SaveBean> saveMessage(@Body RequestBody body);

    /**
     * 获取各管片信息list
     * @param page 页数
     * @param rows 每页多少条
     * @return
     */
    @FormUrlEncoded
    @POST("appPiece/queryDetailListByPiece")
    Observable<EveryDuctBean> getEveryDuctBean(@Field("page") int page,
                                               @Field("rows") String rows,
                                               @Field("manufacturingRingCode") String manufacturingRingCode);

    @GET("indexapp/indexnews.app")
    Observable<Object> getGatherBean();
}
