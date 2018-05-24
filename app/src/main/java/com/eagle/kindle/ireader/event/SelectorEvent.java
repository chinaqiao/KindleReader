package com.eagle.kindle.ireader.event;

import com.eagle.kindle.ireader.model.flag.BookDistillate;
import com.eagle.kindle.ireader.model.flag.BookSort;
import com.eagle.kindle.ireader.model.flag.BookType;
import com.eagle.kindle.ireader.utils.Constant;

/**
 * Created by newbiechen on 17-4-21.
 */

public class SelectorEvent {

    public BookDistillate distillate;

    public BookType type;

    public BookSort sort;

    public SelectorEvent(BookDistillate distillate,
                         BookType type,
                         BookSort sort) {
        this.distillate = distillate;
        this.type = type;
        this.sort = sort;
    }
}
