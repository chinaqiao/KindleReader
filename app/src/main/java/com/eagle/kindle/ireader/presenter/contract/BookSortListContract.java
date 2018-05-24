package com.eagle.kindle.ireader.presenter.contract;

import com.eagle.kindle.ireader.model.bean.SortBookBean;
import com.eagle.kindle.ireader.model.flag.BookSortListType;
import com.eagle.kindle.ireader.ui.base.BaseContract;

import java.util.List;

/**
 * Created by newbiechen on 17-5-3.
 */

public interface BookSortListContract {
    interface View extends BaseContract.BaseView{
        void finishRefresh(List<SortBookBean> beans);
        void finishLoad(List<SortBookBean> beans);
        void showLoadError();
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void refreshSortBook(String gender, BookSortListType type, String major, String minor, int start, int limit);
        void loadSortBook(String gender,BookSortListType type,String major,String minor,int start,int limit);
    }
}
