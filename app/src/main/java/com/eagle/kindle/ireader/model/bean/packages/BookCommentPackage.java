package com.eagle.kindle.ireader.model.bean.packages;

import com.eagle.kindle.ireader.model.bean.BaseBean;
import com.eagle.kindle.ireader.model.bean.BookCommentBean;

import java.util.List;

/**
 * Created by newbiechen on 17-4-20.
 */
public class BookCommentPackage extends BaseBean {

    private List<BookCommentBean> posts;

    public List<BookCommentBean> getPosts() {
        return posts;
    }

    public void setPosts(List<BookCommentBean> posts) {
        this.posts = posts;
    }
}
