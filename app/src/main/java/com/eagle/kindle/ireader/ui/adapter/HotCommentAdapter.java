package com.eagle.kindle.ireader.ui.adapter;

import com.eagle.kindle.ireader.model.bean.HotCommentBean;
import com.eagle.kindle.ireader.ui.adapter.view.HotCommentHolder;
import com.eagle.kindle.ireader.ui.base.adapter.BaseListAdapter;
import com.eagle.kindle.ireader.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-5-4.
 */

public class HotCommentAdapter extends BaseListAdapter<HotCommentBean>{
    @Override
    protected IViewHolder<HotCommentBean> createViewHolder(int viewType) {
        return new HotCommentHolder();
    }
}
