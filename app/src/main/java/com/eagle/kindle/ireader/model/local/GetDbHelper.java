package com.eagle.kindle.ireader.model.local;

import com.eagle.kindle.ireader.model.bean.AuthorBean;
import com.eagle.kindle.ireader.model.bean.DownloadTaskBean;
import com.eagle.kindle.ireader.model.bean.packages.BillboardPackage;
import com.eagle.kindle.ireader.model.bean.ReviewBookBean;
import com.eagle.kindle.ireader.model.bean.BookCommentBean;
import com.eagle.kindle.ireader.model.bean.BookHelpfulBean;
import com.eagle.kindle.ireader.model.bean.BookHelpsBean;
import com.eagle.kindle.ireader.model.bean.BookReviewBean;
import com.eagle.kindle.ireader.model.bean.packages.BookSortPackage;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by newbiechen on 17-4-28.
 */

public interface GetDbHelper {
    Single<List<BookCommentBean>> getBookComments(String block, String sort, int start, int limited, String distillate);
    Single<List<BookHelpsBean>> getBookHelps(String sort, int start, int limited, String distillate);
    Single<List<BookReviewBean>> getBookReviews(String sort, String bookType, int start, int limited, String distillate);
    BookSortPackage getBookSortPackage();
    BillboardPackage getBillboardPackage();

    AuthorBean getAuthor(String id);
    ReviewBookBean getReviewBook(String id);
    BookHelpfulBean getBookHelpful(String id);

    /******************************/
    List<DownloadTaskBean> getDownloadTaskList();
}
