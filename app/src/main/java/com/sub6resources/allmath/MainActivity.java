package com.sub6resources.allmath;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCalculator(View view) { openCalculator();
    }

    public void openCalculator() {
        openActivityWithAnimation(findViewById(R.id.calculator_preview), new Intent(this, CalculatorActivity.class));
    }
    public void openActivityWithAnimation(View commonView, Intent intent) {
        // create the transition animation - the images in the layouts
        // of both activities are defined with android:transitionName="robot"
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions
                    .makeSceneTransitionAnimation(this, commonView, "recorderImage");
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
        // start the new activity
    }

}
