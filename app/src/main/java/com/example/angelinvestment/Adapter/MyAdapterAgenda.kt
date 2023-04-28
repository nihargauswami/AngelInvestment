package com.example.angelinvestment.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.angelinvestment.Model.ParentItemAllFavourite
import com.example.angelinvestment.Model.UserModelAgenda
import com.example.angelinvestment.R

class MyAdapterAgenda(
    private val userList : List<UserModelAgenda>)
    : RecyclerView.Adapter<MyAdapterAgenda.MyViewHolder>()  {
//    private val userList = ArrayList<UserModelAgenda>()


    var onItemClick : ((UserModelAgenda) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_agenda,
            parent,false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.imageview.setImageResource(currentItem.imageview)
        holder.textview.text = currentItem.textview
        holder.tvdate.text = currentItem.tvdate
        holder.tvtime.text = currentItem.tvtime
        holder.tvfounder.text = currentItem.tvfounder
        holder.tvregister.text = currentItem.register
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentItem)
        }
    }

    override fun getItemCount(): Int {
       return userList.size
    }

//    @SuppressLint("NotifyDataSetChanged")
//    fun updateUserList(userList : List<UserModelAgenda>){
//        this.userList.clear()
//        this.userList.addAll(userList)
//        notifyDataSetChanged()
//    }

    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val imageview : ImageView = itemView.findViewById(R.id.tvImageView)
        val textview : TextView = itemView.findViewById(R.id.tvTextView)
        val tvdate : TextView = itemView.findViewById(R.id.tvTextDate)
        val tvtime : TextView = itemView.findViewById(R.id.tvTextTime)
        val tvfounder: TextView = itemView.findViewById(R.id.tvTextFounder)
        val tvregister : TextView = itemView.findViewById(R.id.Register_Agenda)



    }

}
