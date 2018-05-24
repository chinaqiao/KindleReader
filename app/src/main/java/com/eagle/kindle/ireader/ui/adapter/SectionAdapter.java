package com.eagle.kindle.ireader.ui.adapter;

import com.eagle.kindle.ireader.model.bean.SectionBean;
import com.eagle.kindle.ireader.ui.adapter.view.SectionHolder;
import com.eagle.kindle.ireader.ui.base.adapter.BaseListAdapter;
import com.eagle.kindle.ireader.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-4-16.
 */

public class SectionAdapter extends BaseListAdapter<SectionBean> {
    @Override
    protected IViewHolder<SectionBean> createViewHolder(int viewType) {
        return new SectionHolder();
    }
}
