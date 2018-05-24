package com.eagle.kindle.ireader.model.local;

import com.eagle.kindle.ireader.model.bean.AuthorBean;
import com.eagle.kindle.ireader.model.bean.ReviewBookBean;
import com.eagle.kindle.ireader.model.bean.BookCommentBean;
import com.eagle.kindle.ireader.model.bean.BookHelpfulBean;
import com.eagle.kindle.ireader.model.bean.BookHelpsBean;
import com.eagle.kindle.ireader.model.bean.BookReviewBean;

import java.util.List;

/**
 * Created by newbiechen on 17-4-28.
 */

public interface DeleteDbHelper {
    void deleteBookComments(List<BookCommentBean> beans);
    void deleteBookReviews(List<BookReviewBean> beans);
    void deleteBookHelps(List<BookHelpsBean> beans);
    void deleteAuthors(List<AuthorBean> beans);
    void deleteBooks(List<ReviewBookBean> beans);
    void deleteBookHelpful(List<BookHelpfulBean> beans);
    void deleteAll();
}
