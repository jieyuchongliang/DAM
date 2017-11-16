package info.chenghuan.com.dam;

import android.app.Application;
import android.content.Context;

/**
 * Created by 860617010 on 2017/5/24.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        //获取Context
        super.onCreate();
        context = getApplicationContext();
    }

    /**
     * 获取全局的上下文
     * @return
     */
    public static Context getContext() {
        return context;
    }
}
