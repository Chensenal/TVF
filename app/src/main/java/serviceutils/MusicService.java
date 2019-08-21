package serviceutils;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import interfaceutils.Iservice;
import searchactivity.SearchActivity;
import utilsbean.Requestnews;
import utilsbean.UrlPath;

/**
 * Created by master on 2019/8/15.
 */

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;

    //[2]把我们定义的中间人对象返回
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    //服务一开启 就执行这个方法
    @Override
    public void onCreate() {

        //[1]初始化mediaplayer

        mediaPlayer = new MediaPlayer();

        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //实现指定播放的位置
    public void seekTo(int position){
        mediaPlayer.seekTo(position);
    }


    // 播放音乐的方法
    public int playMusic(String musicname) {

        //[2]设置要播放的资源位置  path 可以是网络 路径 也可是本地路径
        try {
            mediaPlayer.reset();
            String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/kgmusic/download/"+musicname+".mp3";
            mediaPlayer.setDataSource(UrlPath.DOWNLOAD+musicname+".mp3");
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                    updateSeekBar();
                }
            });




            //[5]更新进度条



        } catch (Exception e) {
            e.printStackTrace();
        }
        return 3;


    }
    //更新进度条的方法
    private void updateSeekBar() {
        //[1]获取到当前播放的总长度
        final int duration = mediaPlayer.getDuration();

        //[2]使用Timer 定时器去定时获取当前进度
        final Timer timer = new Timer();
        final TimerTask task = new TimerTask(){

            @Override
            public void run() {
                //[3]一秒钟获取一次当前进度
                int currentPosition = mediaPlayer.getCurrentPosition();

                //[4]拿着我们在MainActivity 创建的handler 发消息 消息就可以携带数据

                Message msg = Message.obtain();
                Bundle bundle = new Bundle(); //map
                bundle.putInt("duration", duration);
                bundle.putInt("currentPosition", currentPosition);
                msg.setData(bundle);
                //发送一条消息  mainActivity里面的handlemessage方法就会执行
                SearchActivity.handler.sendMessage(msg);

            }
        };
        //100 毫秒后 每隔1秒执行一次run方法
        timer.schedule(task, 300, 1000);
        //当歌曲执行完毕后 把timer 和 timertask取消
        //设置播放完成的监听

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                System.out.println("歌曲播放完成了");
                //把timer 和 timertast 取消
                timer.cancel();
                task.cancel();


            }
        });

    }

    // 暂停音乐的方法
    public int pauseMusic() {

        //暂停音乐
        mediaPlayer.pause();
        return 2;


    }

    // 继续播放音乐的方法
    public int rePlayMusic() {

        mediaPlayer.start();
        return 3;
    }

    //[1]在服务的内部定义一中间人对象(IBinder)
    private class MyBinder extends Binder implements Iservice {

        //调用播放音乐的方法
        @Override
        public int callPlayMusic(String musicname) {
            return  playMusic(musicname);
        }

        //调用暂停音乐的方法
        @Override
        public int callPauseMusic() {

            return pauseMusic();
        }

        //调用继续播放音乐的方法
        @Override
        public int callRePlayMusic() {

            return rePlayMusic();
        }

        @Override
        public void callSeekTo(int position) {

            seekTo(position);
        }


    }
}
