package com.eagle.kindle.ireader.presenter;

import com.eagle.kindle.ireader.model.bean.CommentBean;
import com.eagle.kindle.ireader.model.bean.HelpsDetailBean;
import com.eagle.kindle.ireader.model.remote.RemoteRepository;
import com.eagle.kindle.ireader.presenter.contract.HelpsDetailContract;
import com.eagle.kindle.ireader.ui.base.RxPresenter;
import com.eagle.kindle.ireader.utils.LogUtils;
import com.eagle.kindle.ireader.utils.RxUtils;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by newbiechen on 17-4-30.
 */

public class HelpsDetailPresenter extends RxPresenter<HelpsDetailContract.View>
        implements HelpsDetailContract.Presenter{

    @Override
    public void refreshHelpsDetail(String detailId, int start, int limit) {
        Single<HelpsDetailBean> detailSingle = RemoteRepository
                .getInstance().getHelpsDetail(detailId);

        Single<List<CommentBean>> bestCommentsSingle = RemoteRepository
                .getInstance().getBestComments(detailId);

        Single<List<CommentBean>> commentsSingle = RemoteRepository
                .getInstance().getDetailBookComments(detailId, start, limit);

        Disposable detailDispo = RxUtils.toCommentDetail(detailSingle, bestCommentsSingle, commentsSingle)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (bean) -> {
                            mView.finishRefresh(bean.getDetail(),
                                    bean.getBestComments(), bean.getComments());
                            mView.complete();
                        },
                        (e) -> {
                            mView.showError();
                            LogUtils.e(e);
                        }
                );
        addDisposable(detailDispo);
    }

    @Override
    public void loadComment(String detailId, int start, int limit) {
        Disposable loadDispo = RemoteRepository.getInstance()
                .getDetailBookComments(detailId, start, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (bean) -> {
                            mView.finishLoad(bean);
                        },
                        (e) -> {
                            mView.showLoadError();
                            LogUtils.e(e);
                        }
                );
        addDisposable(loadDispo);
    }
}
