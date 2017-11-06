package com.example.tony.mustapp.view;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.transition.Fade;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tony.mustapp.R;

public class PosterFragment extends Fragment {

    ImageView posterImageView;
    Fragment fragment;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_poster, container, false);

        posterImageView = (ImageView) view.findViewById(R.id.poster_image_view);

        posterImageView.setOnClickListener((View v) -> {

          /*
            InfoFragment infoFragment= new InfoFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, infoFragment,"infoFragmentTag")
                    .addToBackStack(null)
                    .commit();
            */





            InfoFragment info = new InfoFragment();



            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                info.setSharedElementEnterTransition(new InfoTransition());
                info.setEnterTransition(new Fade());
                setExitTransition(new Fade());
                info.setSharedElementReturnTransition(new InfoTransition());
            }

            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .addSharedElement(posterImageView, "sharedPoster")
                    .replace(R.id.container, info)
                    .addToBackStack(null)
                    .commit();

        });



        return view;
    }
}
