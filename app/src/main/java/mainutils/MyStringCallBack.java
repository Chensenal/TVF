package mainutils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.zhy.http.okhttp.callback.StringCallback;
import okhttp3.Call;
import okhttp3.Request;
/**
 * Created by master on 2019/8/12.
 */

public class MyStringCallBack extends StringCallback{



        @Override
        public void onBefore(Request request, int id) {
            Log.e("Request", "Request：complete");
        }

        @Override
        public void onAfter(int id) {
            Log.e("onAfter", "onAfter：complete");
        }

        @Override
        public void onError(Call call, Exception e, int id) {
            e.printStackTrace();
            Log.e("onError", "onError：complete");
        }

        @Override
        public void onResponse(String response, int id) {
            Log.e("onResponse", "onResponse：complete");

        }

        @Override
        public void inProgress(float progress, long total, int id) {
            Log.e("inProgress", "inProgress:" + progress);
        }

}
