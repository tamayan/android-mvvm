package com.example.androidmvvm.presentation.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmvvm.databinding.ListItemUserBinding
import com.example.androidmvvm.domain.User
import com.example.androidmvvm.presentation.user.UserListAdaptor.BindViewHolder

class UserListAdaptor : RecyclerView.Adapter<BindViewHolder>() {

    private val list = ArrayList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItemUserBinding = ListItemUserBinding.inflate(layoutInflater, parent, false)
        return BindViewHolder(listItemUserBinding)
    }

    override fun onBindViewHolder(viewHolder: BindViewHolder, position: Int) {
        viewHolder.listItemUserBinding.user = list[position]
    }

    override fun getItemCount(): Int = list.size

    fun update(list: List<User>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class BindViewHolder(val listItemUserBinding: ListItemUserBinding) :
            RecyclerView.ViewHolder(listItemUserBinding.root)
}