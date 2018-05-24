package com.eagle.kindle.ireader.presenter.contract;

import com.eagle.kindle.ireader.model.bean.BookReviewBean;
import com.eagle.kindle.ireader.model.flag.BookDistillate;
import com.eagle.kindle.ireader.model.flag.BookSort;
import com.eagle.kindle.ireader.model.flag.BookType;
import com.eagle.kindle.ireader.ui.base.BaseContract;

import java.util.List;

/**
 * Created by newbiechen on 17-4-21.
 */

public interface DiscReviewContract {
    interface View extends BaseContract.BaseView {
        void finishRefresh(List<BookReviewBean> beans);
        void finishLoading(List<BookReviewBean> beans);
        void showErrorTip();
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void firstLoading(BookSort sort, BookType bookType, int start, int limited, BookDistillate distillate);
        void refreshBookReview(BookSort sort, BookType bookType, int start, int limited, BookDistillate distillate);
        void loadingBookReview(BookSort sort, BookType bookType, int start, int limited, BookDistillate distillate);
        void saveBookReview(List<BookReviewBean> beans);
    }
}
