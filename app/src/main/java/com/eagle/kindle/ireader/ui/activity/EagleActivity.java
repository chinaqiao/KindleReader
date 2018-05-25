package com.eagle.kindle.ireader.ui.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.eagle.kindle.ireader.R;
import com.eagle.kindle.ireader.ui.base.BaseTabActivity;
import com.eagle.kindle.ireader.ui.dialog.SexChooseDialog;
import com.eagle.kindle.ireader.ui.fragment.BookShelfFragment;
import com.eagle.kindle.ireader.ui.fragment.CommunityFragment;
import com.eagle.kindle.ireader.ui.fragment.FindFragment;
import com.eagle.kindle.ireader.utils.Constant;
import com.eagle.kindle.ireader.utils.PermissionsChecker;
import com.eagle.kindle.ireader.utils.SharedPreUtils;
import com.eagle.kindle.ireader.utils.ToastUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EagleActivity extends BaseTabActivity{
    /*************Constant**********/
    private static final int WAIT_INTERVAL = 2000;
    private static final int PERMISSIONS_REQUEST_STORAGE = 1;

    static final String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    /***************Object*********************/
    private final ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private PermissionsChecker mPermissionsChecker;
    /*****************Params*********************/
    private boolean isPrepareFinish = false;

    @Override
    protected int getContentId() {
        return R.layout.activity_base_tab;
    }

    @Override
    protected List<Fragment> createTabFragments() {
        initFragment();
        return mFragmentList;
    }
    @Override
    protected void setUpToolbar(Toolbar toolbar) {
        super.setUpToolbar(toolbar);
        // toolbar.setLogo(R.mipmap.logo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("Kindle阅读器");
    }

    private void initFragment(){
        Fragment bookShelfFragment = new BookShelfFragment();
        Fragment communityFragment = new CommunityFragment();
        Fragment discoveryFragment = new FindFragment();
        mFragmentList.add(bookShelfFragment);
        mFragmentList.add(communityFragment);
        mFragmentList.add(discoveryFragment);
    }

    @Override
    protected List<String> createTabTitles() {
        String [] titles = getResources().getStringArray(R.array.ego_fragment_title);
        return Arrays.asList(titles);
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        // 性别选择框
        // showSexChooseDialog();
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        if (menu != null && menu instanceof MenuBuilder){
            try {
                Method method = menu.getClass().
                        getDeclaredMethod("setOptionalIconsVisible",Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(menu,true);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return super.onPreparePanel(featureId, view, menu);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSIONS_REQUEST_STORAGE: {
                // 如果取消权限，则返回的值为0
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //跳转到 FileSystemActivity
                    Intent intent = new Intent(this, FileSystemActivity.class);
                    startActivity(intent);

                } else {
                    ToastUtils.show("用户拒绝开启读写权限");
                }
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        if(!isPrepareFinish){
            mVp.postDelayed(
                    () -> isPrepareFinish = false,WAIT_INTERVAL
            );
            isPrepareFinish = true;
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
        }
        else {
            super.onBackPressed();
        }
    }
}
