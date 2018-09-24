package com.anupamchugh.androidhackernewsproject;

import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.animation.AnticipateOvershootInterpolator;

public class LoginActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    Handler handler = new Handler();
    static boolean handlerOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (handlerOver) {
            setContentView(R.layout.activity_login_final);
            initViews();

        } else {
            setContentView(R.layout.activity_login_initial);
            initViews();
            handler.postDelayed(new Runnable() {


                @Override
                public void run() {
                    showAnimation();
                    handlerOver = true;
                    handler.removeCallbacks(this);
                }
            }, 200);
        }

    }

    private void initViews() {
        constraintLayout = findViewById(R.id.constraintLayout);

    }

    private void showAnimation() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.activity_login_final);

        ChangeBounds transition = new ChangeBounds();
        transition.setInterpolator(new AnticipateOvershootInterpolator(1.5f));
        transition.setDuration(500);

        TransitionManager.beginDelayedTransition(constraintLayout, transition);
        constraintSet.applyTo(constraintLayout);
    }
}
