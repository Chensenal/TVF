package mefragment.activity.localmusicactivity.singlefragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.master.tvf.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import base.BaseFragment;
import mefragment.activity.localmusicactivity.singlefragment.singleadapter.SingleAdapter;
import mefragment.activity.utils.ChineseToPinyinHelper;
import mefragment.activity.utils.PinYinView;
import mefragment.bean.SongList;
import okhttp3.Call;
import utilsbean.UrlPath;
import utilsbean.User;

/**
 * Created by master on 2019/8/7.
 */

public class SingleFragment extends BaseFragment {
    View rootView;
    ListView single_lv;
    private List<SongList> list;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.single_layout, null);
        }
        single_lv = (ListView) rootView.findViewById(R.id.single_lv);

        initData();

        final SingleAdapter singleAdapter = new SingleAdapter(mContext,list);
        single_lv.setAdapter(singleAdapter);


        TextView textView = (TextView)rootView.findViewById(R.id.show_letter_in_center);
        final PinYinView pinYinView = (PinYinView) rootView.findViewById(R.id.single_pinyinview);
        pinYinView.setTextViewDialot(textView);
        pinYinView.setUpdateListView(new PinYinView.UpdateListView(){

            @Override
            public void updateListview(String currentChar) {
                int positionForSection = singleAdapter.getPositionForSection(currentChar.charAt(0));
                single_lv.setSelection(positionForSection);
            }
        });
        single_lv.setOnScrollListener(new AbsListView.OnScrollListener(){

            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {


            }
            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int sectionForPosition = singleAdapter.getSectionForPosition(firstVisibleItem);
                pinYinView.updateLetterIndexView(sectionForPosition);

            }
        });
        return rootView;
    }
    @Override
    public void initData() {
        super.initData();
        list = new ArrayList<>();
        String[] allSonglistNames = {"我","你","非","真是的","我","你","非","真是的","我","你","非","真是的","我","你","非","真是的"};
        OkHttpUtils
                .post()
                .url(UrlPath.ECHOCOLLECTMUSIC)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {

                    }
                });

        for(String allSonglistName :allSonglistNames){
            SongList songList = new SongList();
            songList.setUsername(allSonglistName);
            String convert = ChineseToPinyinHelper.getIntence().getPinyin(allSonglistName).toUpperCase();
            songList.setPinyin(convert);
            String substring = convert.substring(0,1);
            if(substring.matches("^[A-Z]+$")){
                songList.setFirstLetter(substring);
            }else{
                songList.setFirstLetter("#");
            }
            list.add(songList);
        }
        Collections.sort(list, new Comparator<SongList>() {
            @Override
            public int compare(SongList lhs, SongList rhs) {
                if(lhs.getFirstLetter().contains("#")){
                    return 1;
                }else if(rhs.getFirstLetter().contains("#")){
                    return -1;
                }else {
                    return lhs.getFirstLetter().compareTo(rhs.getFirstLetter());
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (rootView != null) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
    }
}

