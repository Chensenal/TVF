package mefragment.activity.mycollectactivity.mycollectbookshelffagment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.master.tvf.R;

import base.BaseFragment;
import mefragment.activity.mycollectactivity.mycollectbookshelffagment.mycollectbookshelfadapter.MyCollectBookShelfAdapter;
import mefragment.activity.mycollectactivity.mycollectvediofragment.mycollectvedioadapter.MyCollectVedioAdapter;

/**
 * Created by master on 2019/8/9.
 */

public class MyCollectBookShelfFragment  extends BaseFragment {
    View rootView;
    RecyclerView mycollectbookshelf_recyclerview;

    @Override
    public View initView() {
        if (rootView == null) {
            rootView = View.inflate(mContext, R.layout.mycollectbookshelf_layout, null);
        }
        mycollectbookshelf_recyclerview = (RecyclerView) rootView.findViewById(R.id.mycollectbookshelf_recyclerview);
        mycollectbookshelf_recyclerview.setAdapter(new MyCollectBookShelfAdapter(mContext));
        mycollectbookshelf_recyclerview.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (rootView != null) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
    }

    @Override
    public void initData() {
        super.initData();
    }
}
