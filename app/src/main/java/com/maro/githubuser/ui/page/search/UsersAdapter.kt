package com.maro.githubuser.ui.page.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maro.githubuser.R
import com.maro.githubuser.data.local.UserItem
import com.maro.githubuser.utils.loadImage
import com.maro.githubuser.utils.loadRoundedBitmap
import kotlinx.android.synthetic.main.user_item.view.*

/**
 * Created by Wanhar on 19/07/19.
 * Email : Wanhardaengmaro@gmail.com
 */
class UsersAdapter : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    private var usersList: MutableList<UserItem>  = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false),
            parent.context
        )
    }

    override fun getItemCount() = usersList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(usersList[position])
    }

    class ViewHolder(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView) {
        fun bindViews(userItem: UserItem) {
            itemView.userName.text = userItem.login
            loadRoundedBitmap(context, userItem.avatarUrl, itemView.userProfileImage)
        }
    }

    fun setItemsToList(usersList: MutableList<UserItem>) {
        this.usersList = usersList
        notifyDataSetChanged()
    }

    fun addItemsToList(usersList: MutableList<UserItem>) {
        this.usersList.addAll(usersList)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.usersList.clear()
        notifyDataSetChanged()
    }

}
