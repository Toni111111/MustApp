package com.example.tony.mustapp.view;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tony.mustapp.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;


public  class YoutubeFragment extends Fragment {



    private static final String API_KEY = "AIzaSyBv-65Fgk36DcAG4CtexFb5Kl1PsF514Xo";

    private YouTubePlayer YPlayer;
    // YouTubeのビデオID
    private static String VIDEO_ID = "EGy39OMyHzw";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_youtube, container, false);

        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();

        youTubePlayerFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {

                if (!wasRestored) {
                    YPlayer = player;
                    YPlayer.setFullscreen(true);
                    YPlayer.loadVideo("EGy39OMyHzw");
                    YPlayer.play();
                }

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
                Log.d("YouTubeFailure","Failure");
            }
        });
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_fragment, youTubePlayerFragment).commit();
return rootView;
    }
}