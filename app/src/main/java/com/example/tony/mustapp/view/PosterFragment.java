package com.example.tony.mustapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.CardView;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.example.tony.mustapp.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PosterFragment extends Fragment {



    ImageView posterImageView;
    Fragment fragment;
    ImageView blurImageView;
    RelativeLayout relativeLayoutPoster;

    private Context mContext;
    private Resources mResources;
    private RelativeLayout mRelativeLayout;
    private Bitmap mBitmap;
    CardView cardView;



    public static final String TAG = PosterFragment.class.getSimpleName();



    public static PosterFragment newInstance() {
        return new PosterFragment();
    }






    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_poster, container, false);


        relativeLayoutPoster = (RelativeLayout)view.findViewById(R.id.rl_fragment_poster);
      //  blurImageView = (ImageView) view.findViewById(R.id.lmage_view_fragment_poster_blur);
        posterImageView = (ImageView) view.findViewById(R.id.poster_image_view);


        mContext = getActivity().getApplicationContext();

        mResources = getResources();

        posterImageView.setImageResource(R.drawable.poster);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            posterImageView.setClipToOutline(true);
        }


        // blurImageView.setImageResource(R.drawable.poster);

        doRoundCorners(posterImageView);
//        doRoundCorners(blurImageView);





/* Блюрим картинку(задним фоном)

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Blurry.with(getContext())
                        .radius(25)
                        .sampling(8)
                        .async()
                        .capture(blurImageView)
                        .into(blurImageView);
            }
        }, 1500);

        */



        /*Обрезаем углы вьюхи с блюром
        final Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                doRoundCorners(blurImageView);
            }
        }, 1800);

*/


                posterImageView.setOnClickListener((View v) -> {

              InfoFragment fragmentInfo = InfoFragment.newInstance();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                fragmentInfo.setSharedElementEnterTransition(new InfoTransition().setDuration(1000)); // setSharedElementEnterTransaction - метод для перехода с первого фрагмента на второй( передаем кастомную transation)
                fragmentInfo.setEnterTransition(new Fade());
                fragmentInfo.setSharedElementReturnTransition(new InfoTransition().setDuration(1000)); //метод возврата со 2-го фрагмента на 1
            }

            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .addSharedElement(posterImageView, "kittenImage")
                    .replace(R.id.container, fragmentInfo)
                    .addToBackStack(null)
                    .commit();
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
       // posterImageView.setImageResource(R.drawable.poster);
        //doRoundCorners(posterImageView);

    }


    void doRoundCorners(ImageView imageView){
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();

        float cornerRadius = 50.0f;

        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(
                mResources,
                bitmap
        );

        roundedBitmapDrawable.setCornerRadius(cornerRadius);
        roundedBitmapDrawable.setAntiAlias(true);

        imageView.setImageDrawable(roundedBitmapDrawable);
    }








}
