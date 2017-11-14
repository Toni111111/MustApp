package com.example.tony.mustapp.view;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionSet;
import android.util.AttributeSet;

import android.view.ViewGroup;

import static android.support.transition.TransitionSet.ORDERING_TOGETHER;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class InfoTransition extends TransitionSet {

    public InfoTransition() {
        init();
    }


    public InfoTransition(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setOrdering(ORDERING_TOGETHER);
        addTransition(new ChangeBounds()).
                addTransition(new ChangeTransform()).
                addTransition(new ChangeImageTransform());
    }


}