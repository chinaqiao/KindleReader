package com.eagle.kindle.ireader.model.flag;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import com.eagle.kindle.ireader.App;
import com.eagle.kindle.ireader.R;

/**
 * 发现页面的主菜单.
 */
public enum EgoImportType {
    LOCAL(R.string.ego_fragment_center_local,R.drawable.ic_section_top),
    FTP(R.string.ego_fragment_center_ftp,R.drawable.ic_section_topic),
    OTG(R.string.ego_fragment_center_otg,R.drawable.ic_section_sort),
    ;
    private String typeName;
    private int iconId;

    private EgoImportType(@StringRes int typeNameId, @DrawableRes int iconId){
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
