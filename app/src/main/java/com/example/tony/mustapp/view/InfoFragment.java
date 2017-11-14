package com.example.tony.mustapp.view;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tony.mustapp.R;


public class InfoFragment extends Fragment {
    private Resources mResources;
    ImageView posterInfoFragment;


    public static InfoFragment newInstance() {
        return new InfoFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info,
                container, false);

        mResources = getResources();

        posterInfoFragment = (ImageView) view.findViewById(R.id.image);
        posterInfoFragment.setImageResource(R.drawable.poster);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            posterInfoFragment.setClipToOutline(true);
        }


        doRoundCorners(posterInfoFragment);

        posterInfoFragment.setOnClickListener((View v) -> {
            YoutubeFragment fragment = new YoutubeFragment();
            FragmentManager manager = getActivity().getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }

    void doRoundCorners(ImageView imageView) {
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();

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
