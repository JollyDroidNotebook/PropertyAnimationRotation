package ru.jollydroid.propertyanimationrotation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView green;
    private TextView red;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        green = (TextView) findViewById(R.id.green);
        red = (TextView) findViewById(R.id.red);

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grin2red();
            }
        });

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red2green();
            }
        });
    }

    private static final long DURATION = 200;

    public void grin2red() {
        green.setRotationY(0);
        red.setVisibility(View.INVISIBLE);
        red.setRotationY(-90);

        green.animate()
                .setDuration(DURATION)
                .rotationY(90)
                .setInterpolator(new AccelerateInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        red.setVisibility(View.VISIBLE);
                        green.setVisibility(View.GONE);

                        red.animate()
                                .setDuration(DURATION)
                                .rotationY(0)
                                .setInterpolator(new DecelerateInterpolator())
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        green.animate().setListener(null);
                                        red.animate().setListener(null);
                                    }
                                });

                    }
                });
    }

    public void red2green() {
        red.setRotationY(0);
        green.setVisibility(View.INVISIBLE);
        green.setRotationY(90);

        red.animate()
                .setDuration(DURATION)
                .rotationY(-90)
                .setInterpolator(new AccelerateInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        red.setVisibility(View.GONE);
                        green.setVisibility(View.VISIBLE);

                        green.animate()
                                .setDuration(DURATION)
                                .rotationY(0)
                                .setInterpolator(new DecelerateInterpolator())
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        green.animate().setListener(null);
                                        red.animate().setListener(null);
                                    }
                                });

                    }
                });
    }

}

