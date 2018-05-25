package com.eagle.kindle.ireader.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.eagle.kindle.ireader.R;
import com.eagle.kindle.ireader.model.bean.SectionBean;
import com.eagle.kindle.ireader.model.flag.CommunityType;
import com.eagle.kindle.ireader.model.flag.UserCenterType;
import com.eagle.kindle.ireader.ui.activity.BookDiscussionActivity;
import com.eagle.kindle.ireader.ui.adapter.SectionAdapter;
import com.eagle.kindle.ireader.ui.base.BaseFragment;
import com.eagle.kindle.ireader.ui.base.adapter.BaseListAdapter;
import com.eagle.kindle.ireader.widget.itemdecoration.DividerItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 用户中心
 */

public class UserCenterFragment extends BaseFragment implements BaseListAdapter.OnItemClickListener{
    /***************view******************/
    @BindView(R.id.user_center_rv_content)
    RecyclerView mRvContent;

    private SectionAdapter mAdapter;

    @Override
    protected int getContentId() {
        return R.layout.fragment_user_center;
    }

    /***********************************init method*************************************************/

    @Override
    protected void initWidget(Bundle savedInstanceState) {
        setUpAdapter();
    }

    private void setUpAdapter(){
        ArrayList<SectionBean> sections = new ArrayList<>();

        /*觉得采用枚举会好一些，要不然就是在Constant中创建Map类*/
        for (UserCenterType type : UserCenterType.values()){
            sections.add(new SectionBean(type.getTypeName(),type.getIconId()));
        }

        mAdapter = new SectionAdapter();
        mRvContent.setHasFixedSize(true);
        mRvContent.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvContent.addItemDecoration(new DividerItemDecoration(getContext()));
        mRvContent.setAdapter(mAdapter);
        mAdapter.addItems(sections);
    }

    /****************************click method********************************/

    @Override
    protected void initClick() {
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, int pos) {

        // UserCenterType type = UserCenterType.values()[pos];
        // Intent intent = new Intent(getContext(), BookDiscussionActivity.class);
        // getContext().startActivity(intent);
    }
}
