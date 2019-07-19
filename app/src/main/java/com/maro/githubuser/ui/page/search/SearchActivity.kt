package com.maro.githubuser.ui.page.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maro.githubuser.R
import com.maro.githubuser.data.local.UserItem
import com.maro.githubuser.ui.base.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject



class SearchActivity : BaseActivity(), SearchContract.View{

    @Inject
    lateinit var presenter: SearchContract.Presenter

    val usersAdapter: UsersAdapter by lazy{ UsersAdapter() }

    var itShouldLoadMore = true
    var page:Int = 1;
    var query:String=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_search)

        initViews()

    }

    fun initViews() {
        setAdapter()
        input_search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun afterTextChanged(editable: Editable) {
                if (editable.length > 1) {
                    page = 1
                    query = editable.toString()
                    presenter.getListData(query)
                }
            }
        })
    }

    fun setAdapter() {
        with(rvProduct) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = usersAdapter

            addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if(dy > 0){
                        if (!rvProduct.canScrollVertically(RecyclerView.FOCUS_DOWN)){
                            if (itShouldLoadMore) {
                                itShouldLoadMore = false
                                page += 1
                                presenter.loadMore(query,page)
                            }
                        }
                    }
                }
            })
        }
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    @SuppressLint("ShowToast")
    override fun showListData(response: MutableList<UserItem>) {
        if (response.size > 0)
            usersAdapter.setItemsToList(response)
        else{
            usersAdapter.clearItems()
            Toast.makeText(this, "Maaf username $query tidak ditemukan", Toast.LENGTH_LONG).show()
        }
    }

    override fun showLoadMoreData(response: MutableList<UserItem>) {
        usersAdapter.addItemsToList(response)
        itShouldLoadMore = true
    }

    @SuppressLint("ShowToast")
    override fun showErrorMessage(localizedMessage: String?) {
        Toast.makeText(this, localizedMessage, Toast.LENGTH_LONG).show()
        itShouldLoadMore = true
    }

    override fun onDestroy() {
        presenter.unsubscribe()
        super.onDestroy()
    }


}
