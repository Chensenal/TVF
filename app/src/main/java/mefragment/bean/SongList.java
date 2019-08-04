package mefragment.bean;

import android.widget.ImageView;

/**
 * Created by master on 2019/7/28.
 */

public class SongList {

    private String SonglistText;
    private int CollectCount;
    private int Download;


    public SongList(String SonglistText,int CollectCount,int Download) {
        this.SonglistText = SonglistText;
        this.CollectCount = CollectCount;
        this.Download = Download;

    }
    public String getSonglistText() {
        return SonglistText;
    }
    public void setSonglistText(String songlistText) {
        SonglistText = songlistText;
    }
    public int getCollectCount() {
        return CollectCount;
    }
    public void setCollectCount(int collectCount) {
        CollectCount = collectCount;
    }
    public int getDownload() {
        return Download;
    }
    public void setDownload(int download) {
        Download = download;
    }

}
