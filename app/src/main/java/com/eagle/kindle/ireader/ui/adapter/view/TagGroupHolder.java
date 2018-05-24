package com.eagle.kindle.ireader.ui.adapter.view;

import android.widget.TextView;

import com.eagle.kindle.ireader.R;
import com.eagle.kindle.ireader.ui.base.adapter.ViewHolderImpl;

/**
 * Created by newbiechen on 17-5-5.
 */

public class TagGroupHolder extends ViewHolderImpl<String> {
    private TextView mTvGroupName;

    @Override
    public void initView() {
        mTvGroupName = findById(R.id.tag_group_name);
    }

    @Override
    public void onBind(String value, int pos) {
        mTvGroupName.setText(value);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_tag_group;
    }
}
