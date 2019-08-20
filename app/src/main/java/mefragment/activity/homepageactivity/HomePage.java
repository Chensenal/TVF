package mefragment.activity.homepageactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.master.tvf.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import mefragment.activity.homepageactivity.homepageadapter.HomePageAdapter;
import utilsbean.RequestCode;
import utilsbean.ResultCode;

/**
 * Created by master on 2019/8/5.
 */

public class HomePage extends FragmentActivity{
    String username;
    String imagepath;
    @Bind(R.id.homepage_recyclerview)
    RecyclerView homwpage_recyclerview;
    View mRootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_layout);
        ButterKnife.bind(this);

        homwpage_recyclerview.setAdapter(new HomePageAdapter(getBaseContext(),HomePage.this,username,imagepath));
        homwpage_recyclerview.setLayoutManager(new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:{
                if(resultCode== ResultCode.RESULT_HOMEPAGE_CODE){
                    if(data!=null){
                        Log.e("用户名",data.getStringExtra("username"));
                        Log.e("地址",data.getStringExtra("imagepath"));
                    }
                }
            }
        }
    }
}
