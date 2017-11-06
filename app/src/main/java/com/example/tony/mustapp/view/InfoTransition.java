package com.example.tony.mustapp.view;

import android.content.Context;
import android.support.transition.ChangeBounds;
import android.support.transition.ChangeImageTransform;
import android.support.transition.ChangeTransform;
import android.support.transition.TransitionSet;
import android.util.AttributeSet;

import static android.support.transition.TransitionSet.ORDERING_TOGETHER;

/**
 * Created by Asus on 06.11.2017.
 */

public class InfoTransition extends TransitionSet {
    public InfoTransition() {
        init();
    }

    /**
     * This constructor allows us to use this transition in XML
     */
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

