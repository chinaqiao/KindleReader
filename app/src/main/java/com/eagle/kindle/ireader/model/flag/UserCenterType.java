package com.eagle.kindle.ireader.model.flag;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import com.eagle.kindle.ireader.App;
import com.eagle.kindle.ireader.R;

/**
 * 用户中心菜单
 */
public enum UserCenterType {
    LOGIN(R.string.ego_fragment_center_login,R.drawable.ic_section_user),
    EMAIL(R.string.ego_fragment_center_email,R.drawable.ic_section_discuss),
    LOGOUT(R.string.ego_fragment_center_logout,R.drawable.ic_section_topic),
    ABOUT(R.string.ego_fragment_center_about,R.drawable.ic_section_top),
    ;
    private String typeName;
    private int iconId;

    private UserCenterType(@StringRes int typeNameId, @DrawableRes int iconId){
        this.typeName = App.getContext().getResources().getString(typeNameId);
        this.iconId = iconId;
    }

    public String getTypeName(){
        return typeName;
    }

    public int getIconId(){
        return iconId;
    }
}
