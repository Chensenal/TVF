package mefragment.bean;

import android.widget.ImageView;

/**
 * Created by master on 2019/7/28.
 */

public class SongList {
    private int img;
    private String username;
    private String pinyin;
    private String firstLetter;



    public  SongList(){}
    public SongList(String firstLetter,int img,String pinyin,String username){

        this.firstLetter = firstLetter;
        this.img = img;
        this.pinyin = pinyin;
        this.username = username;

    }

    public int getImg() {
        return img;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public String getPinyin() {
        return pinyin;
    }

    public String getUsername() {
        return username;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
