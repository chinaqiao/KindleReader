package com.eagle.kindle.ireader.ui.adapter;

import com.eagle.kindle.ireader.model.bean.packages.SearchBookPackage;
import com.eagle.kindle.ireader.ui.adapter.view.SearchBookHolder;
import com.eagle.kindle.ireader.ui.base.adapter.BaseListAdapter;
import com.eagle.kindle.ireader.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-6-2.
 */

public class SearchBookAdapter extends BaseListAdapter<SearchBookPackage.BooksBean>{
    @Override
    protected IViewHolder<SearchBookPackage.BooksBean> createViewHolder(int viewType) {
        return new SearchBookHolder();
    }
}
