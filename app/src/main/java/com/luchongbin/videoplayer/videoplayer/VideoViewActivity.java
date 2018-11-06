package com.luchongbin.videoplayer.videoplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.luchongbin.videoplayer.lcbvideoplayer.LCBVideoPlayer;

public class VideoViewActivity extends AppCompatActivity {
    private LCBVideoPlayer mLCBVideoPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        mLCBVideoPlayer = findViewById(R.id.videoView);
        String mImageUri = "https://pic.vjshi.com/2018-11-06/be3d03b4cf7e8468461de294db0757c2/online/puzzle.jpg?x-oss-process=style/watermark";
        String mVideoUri = "https://mp4.vjshi.com/2018-11-06/be3d03b4cf7e8468461de294db0757c2.mp4";
        /***
         *  * @param url         视频地址 | Video address
         * @param thumb       缩略图地址 | Thumbnail address
         * @param title       标题 | title
         * @param ifShowTitle 是否在非全屏下显示标题 | The title is displayed in full-screen under
         */
        mLCBVideoPlayer.setUp(mVideoUri,mImageUri,"标题",false);
    }
}
