package com.eagle.kindle.ireader.ui.adapter;

import android.content.Context;

import com.eagle.kindle.ireader.model.bean.BookReviewBean;
import com.eagle.kindle.ireader.ui.adapter.view.DiscReviewHolder;
import com.eagle.kindle.ireader.ui.base.adapter.IViewHolder;
import com.eagle.kindle.ireader.widget.adapter.WholeAdapter;

/**
 * Created by newbiechen on 17-4-21.
 */

public class DiscReviewAdapter extends WholeAdapter<BookReviewBean> {

    public DiscReviewAdapter(Context context, Options options) {
        super(context, options);
    }

    @Override
    protected IViewHolder<BookReviewBean> createViewHolder(int viewType) {
        return new DiscReviewHolder();
    }
}
