package com.eagle.kindle.ireader.ui.adapter;

import com.eagle.kindle.ireader.model.bean.BillBookBean;
import com.eagle.kindle.ireader.ui.adapter.view.BillBookHolder;
import com.eagle.kindle.ireader.ui.base.adapter.BaseListAdapter;
import com.eagle.kindle.ireader.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-5-3.
 */

public class BillBookAdapter extends BaseListAdapter<BillBookBean> {
    @Override
    protected IViewHolder<BillBookBean> createViewHolder(int viewType) {
        return new BillBookHolder();
    }
}
