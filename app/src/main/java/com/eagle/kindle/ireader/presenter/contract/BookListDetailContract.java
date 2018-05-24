package com.eagle.kindle.ireader.presenter.contract;

import com.eagle.kindle.ireader.model.bean.BookListDetailBean;
import com.eagle.kindle.ireader.ui.base.BaseContract;

/**
 * Created by newbiechen on 17-5-1.
 */

public interface BookListDetailContract {

    interface View extends BaseContract.BaseView{
        void finishRefresh(BookListDetailBean bean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void refreshBookListDetail(String detailId);
    }
}
