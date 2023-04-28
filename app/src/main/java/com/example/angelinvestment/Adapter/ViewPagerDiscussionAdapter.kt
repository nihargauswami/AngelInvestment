package com.example.angelinvestment.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.angelinvestment.Model.UserModelViewPagerDiscussion
import com.example.angelinvestment.R

class ViewPagerDiscussionAdapter(private val context: Context, private val viewPager2: ViewPager2): RecyclerView.Adapter<ViewPagerDiscussionAdapter.Pager2ViewHolder>() {

    private val userList = ArrayList<UserModelViewPagerDiscussion>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerDiscussionAdapter.Pager2ViewHolder {

        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_discussion_1,parent,false))
    }

    override fun onBindViewHolder(holder: ViewPagerDiscussionAdapter.Pager2ViewHolder, position: Int) {
        val currentItem = userList[position]
        Glide.with(context).load(currentItem.imageView).centerCrop().into(holder.imageview)
        holder.textview.text = currentItem.userName
        holder.tvtime.text = currentItem.userTime
        holder.tvdate.text = currentItem.userDate

        if (position == userList.size-1){
            viewPager2.post(runnable)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class Pager2ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageview : ImageView = itemView.findViewById(R.id.tvImageView)
        val textview : TextView = itemView.findViewById(R.id.tvTextView_name)
        val tvdate : TextView = itemView.findViewById(R.id.tvTextDate)
        val tvtime : TextView = itemView.findViewById(R.id.tvTextTime)

    }
    private val runnable = Runnable {
        userList.addAll(userList)
        notifyDataSetChanged()
    }

}