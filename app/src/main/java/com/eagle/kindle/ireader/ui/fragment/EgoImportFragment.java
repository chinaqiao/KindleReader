package com.eagle.kindle.ireader.ui.fragment;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.eagle.kindle.ireader.R;
import com.eagle.kindle.ireader.model.bean.SectionBean;
import com.eagle.kindle.ireader.model.flag.EgoImportType;
import com.eagle.kindle.ireader.model.flag.FindType;
import com.eagle.kindle.ireader.ui.activity.BillboardActivity;
import com.eagle.kindle.ireader.ui.activity.BookListActivity;
import com.eagle.kindle.ireader.ui.activity.BookSortActivity;
import com.eagle.kindle.ireader.ui.activity.FileSystemActivity;
import com.eagle.kindle.ireader.ui.adapter.SectionAdapter;
import com.eagle.kindle.ireader.ui.base.BaseFragment;
import com.eagle.kindle.ireader.utils.PermissionsChecker;
import com.eagle.kindle.ireader.widget.itemdecoration.DividerItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * FTP
 * OTG
 * 本地文件搜索
 * @author Ego
 */
public class EgoImportFragment extends BaseFragment {
    /******************view************************/
    @BindView(R.id.find_rv_content)
    RecyclerView mRvContent;
    /*******************Object***********************/
    SectionAdapter mAdapter;

    private static final int PERMISSIONS_REQUEST_STORAGE = 1;
    static final String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private PermissionsChecker mPermissionsChecker;

    @Override
    protected int getContentId() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initWidget(Bundle savedInstanceState) {
        setUpAdapter();
    }

    private void setUpAdapter(){
        ArrayList<SectionBean> sections = new ArrayList<>();
        for (EgoImportType type : EgoImportType.values()){
            sections.add(new SectionBean(type.getTypeName(),type.getIconId()));
        }

        mAdapter = new SectionAdapter();
        mRvContent.setHasFixedSize(true);
        mRvContent.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvContent.addItemDecoration(new DividerItemDecoration(getContext()));
        mRvContent.setAdapter(mAdapter);
        mAdapter.addItems(sections);
    }


    @Override
    protected void initClick() {
        mAdapter.setOnItemClickListener(
                (view,pos) -> {
                    EgoImportType type = EgoImportType.values()[pos];
                    Intent intent;
                    //跳转
                    switch (type){
                        case LOCAL:
                            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
                                if (mPermissionsChecker == null){
                                    mPermissionsChecker = new PermissionsChecker(getContext());
                                }
                                //获取读取和写入SD卡的权限
                                if (mPermissionsChecker.lacksPermissions(PERMISSIONS)){
                                    //请求权限
                                    ActivityCompat.requestPermissions(getActivity(), PERMISSIONS,PERMISSIONS_REQUEST_STORAGE);
                                    return;
                                }
                            }
                            intent = new Intent(getContext(),FileSystemActivity.class);
                            startActivity(intent);
                            break;
                        case FTP:
                            intent = new Intent(getContext(), FileSystemActivity.class);
                            startActivity(intent);
                            break;
                        case OTG:
                            intent = new Intent(getContext(), FileSystemActivity.class);
                            startActivity(intent);
                            break;
                    }
                }
        );

    }
}
