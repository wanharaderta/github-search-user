package com.maro.githubuser.ui.page.search

import com.maro.githubuser.data.local.UserItem
import com.maro.githubuser.ui.base.BaseContract

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
interface SearchContract {
    interface View : BaseContract.View{
        fun showListData(response: MutableList<UserItem>)
        fun showLoadMoreData(response: MutableList<UserItem>)
        fun showErrorMessage(localizedMessage: String?)
    }
    interface Presenter : BaseContract.Presenter<SearchContract>{
        fun getListData(key: String)
        fun loadMore(key: String,pageNumber: Int)
    }
}