package com.maro.githubuser.ui.page.search

import com.maro.githubuser.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
class SearchPresenter @Inject constructor(
    val view: SearchContract.View,
    val api: ApiService
) : SearchContract.Presenter {


    private val subscriptions = CompositeDisposable()

    override fun getListData(key: String) {
        val subscribe = api.getUsers(key,1).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.showLoading() }
            .doAfterTerminate { view.hideLoading() }
            .subscribe({
                view.showListData(it.user)
            }, {
                view.showErrorMessage(it.localizedMessage)
            })
        subscriptions.add(subscribe)
    }

    override fun loadMore(key: String, pageNumber: Int) {
        val subscribe = api.getUsers(key,pageNumber).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.showLoading() }
            .doAfterTerminate { view.hideLoading() }
            .subscribe({
                view.showLoadMoreData(it.user)
            }, {
                view.showErrorMessage(it.localizedMessage)
            })
        subscriptions.add(subscribe)
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }


}