package com.eagle.kindle.ireader.ui.adapter;

import com.eagle.kindle.ireader.ui.adapter.view.KeyWordHolder;
import com.eagle.kindle.ireader.ui.base.adapter.BaseListAdapter;
import com.eagle.kindle.ireader.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-6-2.
 */

public class KeyWordAdapter extends BaseListAdapter<String> {
    @Override
    protected IViewHolder<String> createViewHolder(int viewType) {
        return new KeyWordHolder();
    }
}
