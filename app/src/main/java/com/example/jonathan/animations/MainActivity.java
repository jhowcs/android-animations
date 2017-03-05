package com.example.jonathan.animations;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgLogo = (ImageView) findViewById(R.id.imgLogo);

        imgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = "Vikings";

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, title);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat
                            .makeSceneTransitionAnimation(MainActivity.this, (View) imgLogo, "anim");

                    Log.i(TAG, "Lollipop");

                    startActivity(intent, options.toBundle());
                } else {
                    Log.i(TAG, "Minor than Lollipop");
                    startActivity(intent);
                }

            }
        });
    }
}
