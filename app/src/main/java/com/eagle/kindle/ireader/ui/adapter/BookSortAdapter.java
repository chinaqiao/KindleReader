package com.eagle.kindle.ireader.ui.adapter;

import com.eagle.kindle.ireader.model.bean.BookSortBean;
import com.eagle.kindle.ireader.ui.adapter.view.BookSortHolder;
import com.eagle.kindle.ireader.ui.base.adapter.BaseListAdapter;
import com.eagle.kindle.ireader.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-4-23.
 */

public class BookSortAdapter extends BaseListAdapter<BookSortBean>{

    @Override
    protected IViewHolder<BookSortBean> createViewHolder(int viewType) {
        return new BookSortHolder();
    }
}
