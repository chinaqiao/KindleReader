package com.eagle.kindle.ireader.ui.activity;

import android.app.Activity;
import android.support.v7.widget.Toolbar;

import com.eagle.kindle.ireader.R;
import com.eagle.kindle.ireader.ui.base.BaseActivity;

/**
 * Created by newbiechen on 17-5-26.
 */

public class CommunityActivity extends BaseActivity{

    @Override
    protected int getContentId() {
        return R.layout.activity_community;
    }

    @Override
    protected void setUpToolbar(Toolbar toolbar) {
        super.setUpToolbar(toolbar);
        getSupportActionBar().setTitle("社区");
    }
}
