package com.eagle.kindle.ireader.presenter.contract;

import com.eagle.kindle.ireader.model.bean.packages.BillboardPackage;
import com.eagle.kindle.ireader.ui.base.BaseContract;

/**
 * Created by newbiechen on 17-4-23.
 */

public interface BillboardContract {

    interface View extends BaseContract.BaseView{
        void finishRefresh(BillboardPackage beans);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void loadBillboardList();
    }
}
