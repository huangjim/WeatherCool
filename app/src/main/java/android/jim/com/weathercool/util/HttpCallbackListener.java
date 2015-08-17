package android.jim.com.weathercool.util;

/**
 * Created by Jim Huang on 2015/8/17.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
