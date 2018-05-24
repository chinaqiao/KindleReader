package com.eagle.kindle.ireader.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.eagle.kindle.ireader.model.bean.BookChapterBean;
import com.eagle.kindle.ireader.ui.adapter.view.CategoryHolder;
import com.eagle.kindle.ireader.ui.base.EasyAdapter;
import com.eagle.kindle.ireader.ui.base.adapter.IViewHolder;
import com.eagle.kindle.ireader.widget.page.TxtChapter;

import java.util.List;

/**
 * Created by newbiechen on 17-6-5.
 */

public class CategoryAdapter extends EasyAdapter<TxtChapter> {
    private int currentSelected = 0;
    @Override
    protected IViewHolder<TxtChapter> onCreateViewHolder(int viewType) {
        return new CategoryHolder();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        CategoryHolder holder = (CategoryHolder) view.getTag();

        if (position == currentSelected){
            holder.setSelectedChapter();
        }

        return view;
    }

    public void setChapter(int pos){
        currentSelected = pos;
        notifyDataSetChanged();
    }
}
