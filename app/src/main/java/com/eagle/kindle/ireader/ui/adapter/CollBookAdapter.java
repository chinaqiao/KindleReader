package com.eagle.kindle.ireader.ui.adapter;

import com.eagle.kindle.ireader.model.bean.CollBookBean;
import com.eagle.kindle.ireader.ui.adapter.view.CollBookHolder;
import com.eagle.kindle.ireader.ui.base.adapter.IViewHolder;
import com.eagle.kindle.ireader.widget.adapter.WholeAdapter;

/**
 * Created by newbiechen on 17-5-8.
 */

public class CollBookAdapter extends WholeAdapter<CollBookBean> {

    @Override
    protected IViewHolder<CollBookBean> createViewHolder(int viewType) {
        return new CollBookHolder();
    }

}
