package com.example.angelinvestment.Adapter

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.angelinvestment.Model.UserModelDiscussion
import com.example.angelinvestment.R

class MyAdapterDiscussion(private val userList : ArrayList<UserModelDiscussion>
) : RecyclerView.Adapter<MyAdapterDiscussion.MyViewHolder>() {

//    private val userList = ArrayList<UserModelDiscussion>()

    var onItemClick : ((UserModelDiscussion) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_discussion,
            parent, false
        )
        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
//        Glide.with(context).load(currentItem.imageView).centerCrop().into(holder.imageView)
        holder.imageView.setImageResource(currentItem.imageView)
        holder.userName.text = currentItem.userName
        holder.userTime.text = currentItem.userTime
        holder.userMessage.text = currentItem.userMessage

        holder.imageView.setOnClickListener {
            onItemClick?.invoke(currentItem)
        }

    }

    override fun getItemCount(): Int {
        return userList.size
    }

//    fun updateUserList(userList: List<UserModelDiscussion>) {
//        this.userList.clear()
//        this.userList.addAll(userList)
//        notifyDataSetChanged()
//    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.findViewById(R.id.Image_View_Discussion)
        val userName: TextView = itemView.findViewById(R.id.tvName_User)
        val userTime: TextView = itemView.findViewById(R.id.tvTime_Discussion)
        val userMessage: TextView = itemView.findViewById(R.id.tvText_Context_Discussion)

    }

}