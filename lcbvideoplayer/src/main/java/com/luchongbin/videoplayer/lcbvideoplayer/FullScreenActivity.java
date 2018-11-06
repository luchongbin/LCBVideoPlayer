package com.luchongbin.videoplayer.lcbvideoplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * <p>全屏的activity</p>
 * <p>fullscreen activity</p>
 * On Created by luchongbin on 2018/3/9.
 */
public class FullScreenActivity extends Activity {

    static void toActivityFromNormal(Context context, int state, String url, String thumb, String title) {
        STATE = state;
        URL = url;
        THUMB = thumb;
        TITLE = title;
        start = false;
        Intent intent = new Intent(context, FullScreenActivity.class);
        context.startActivity(intent);
    }

    public static void toActivity(Context context, String url, String thumb, String title) {
        STATE = LCBVideoPlayer.CURRENT_STATE_NORMAL;
        URL = url;
        THUMB = thumb;
        TITLE = title;
        start = true;
        Intent intent = new Intent(context, FullScreenActivity.class);
        context.startActivity(intent);
    }

    LCBVideoPlayer jcVideoPlayer;
    /**
     * 刚启动全屏时的播放状态
     */
    public static int STATE = -1;
    public static String URL;
    public static String TITLE;
    public static String THUMB;
    public static boolean manualQuit = false;
    protected static Skin skin;
    static boolean start = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        View decor = this.getWindow().getDecorView();
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_fullscreen);

        jcVideoPlayer = (LCBVideoPlayer) findViewById(R.id.jcvideoplayer);
        if (skin != null) {
            jcVideoPlayer.setSkin(skin.titleColor, skin.timeColor, skin.seekDrawable, skin.bottomControlBackground,
                    skin.enlargRecId, skin.shrinkRecId);
        }
        jcVideoPlayer.setUpForFullscreen(URL, THUMB, TITLE);
        jcVideoPlayer.setState(STATE);
        LCBMediaManager.intance().setUuid(jcVideoPlayer.uuid);
        manualQuit = false;
        if (start) {
            jcVideoPlayer.ivStart.performClick();
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(VideoEvents videoEvents) {
        if (videoEvents.type == VideoEvents.VE_SURFACEHOLDER_FINISH_FULLSCREEN || videoEvents.type == VideoEvents.VE_MEDIAPLAYER_FINISH_COMPLETE) {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        jcVideoPlayer.quitFullScreen();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!manualQuit) {
            jcVideoPlayer.isClickFullscreen = false;
            LCBVideoPlayer.releaseAllVideos();
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

}
