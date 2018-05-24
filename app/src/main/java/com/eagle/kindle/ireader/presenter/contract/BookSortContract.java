package com.eagle.kindle.ireader.presenter.contract;

import com.eagle.kindle.ireader.model.bean.packages.BookSortPackage;
import com.eagle.kindle.ireader.model.bean.packages.BookSubSortPackage;
import com.eagle.kindle.ireader.ui.base.BaseContract;

/**
 * Created by newbiechen on 17-4-23.
 */

public interface BookSortContract {

    interface View extends BaseContract.BaseView{
        void finishRefresh(BookSortPackage sortPackage, BookSubSortPackage subSortPackage);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void refreshSortBean();
    }
}
