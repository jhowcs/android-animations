package com.example.jonathan.animations;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class SecondActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mAppBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mFab = (FloatingActionButton) findViewById(R.id.fab);

        mAppBarLayout.addOnOffsetChangedListener(this);

        String title = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        mToolbar.setTitle(title);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        final int diff = Math.abs(verticalOffset);

        if (diff < (appBarLayout.getTotalScrollRange() / 2)) {
            mFab.animate().alpha(1);
            //mFab.setVisibility(View.VISIBLE);
        } else {
            mFab.animate().alpha(0);
            //mFab.setVisibility(View.GONE);
        }
    }
}
