package interfaceutils;

/**
 * Created by master on 2019/8/15.
 */

public interface Iservice {
    public int callPlayMusic(String musicname);
    public int callPauseMusic();
    public int callRePlayMusic();
    public void callSeekTo(int position);


}
