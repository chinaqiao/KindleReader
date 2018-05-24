package com.eagle.kindle.ireader.ui.adapter;

import com.eagle.kindle.ireader.model.bean.DownloadTaskBean;
import com.eagle.kindle.ireader.ui.adapter.view.DownloadHolder;
import com.eagle.kindle.ireader.ui.base.adapter.BaseListAdapter;
import com.eagle.kindle.ireader.ui.base.adapter.IViewHolder;

/**
 * Created by newbiechen on 17-5-12.
 */

public class DownLoadAdapter extends BaseListAdapter<DownloadTaskBean>{

    @Override
    protected IViewHolder<DownloadTaskBean> createViewHolder(int viewType) {
        return new DownloadHolder();
    }
}
