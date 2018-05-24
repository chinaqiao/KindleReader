package com.eagle.kindle.ireader.ui.adapter;

import com.eagle.kindle.ireader.model.bean.CommentBean;
import com.eagle.kindle.ireader.ui.adapter.view.CommentHolder;
import com.eagle.kindle.ireader.ui.base.adapter.BaseListAdapter;
import com.eagle.kindle.ireader.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-4-29.
 */

public class GodCommentAdapter extends BaseListAdapter<CommentBean>{
    @Override
    protected IViewHolder<CommentBean> createViewHolder(int viewType) {
        return new CommentHolder(true);
    }
}
