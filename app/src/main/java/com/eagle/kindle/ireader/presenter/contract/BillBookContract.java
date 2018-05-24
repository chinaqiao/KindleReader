package com.eagle.kindle.ireader.presenter.contract;

import com.eagle.kindle.ireader.model.bean.BillBookBean;
import com.eagle.kindle.ireader.ui.base.BaseContract;

import java.util.List;

/**
 * Created by newbiechen on 17-5-3.
 */

public interface BillBookContract {
    interface View extends BaseContract.BaseView{
        void finishRefresh(List<BillBookBean> beans);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void refreshBookBrief(String billId);
    }
}
