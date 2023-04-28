package com.example.angelinvestment.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.angelinvestment.Model.ParentItemAllFavourite
import com.example.angelinvestment.R

class ParentAdapterAllStartsUp(
    private val parentList : List<ParentItemAllFavourite>)
    :RecyclerView.Adapter<ParentAdapterAllStartsUp.ParentViewHolder>()



{
    var onItemClick : ((ParentItemAllFavourite) -> Unit)? = null

        inner class ParentViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
            val TitleTv : TextView = itemView.findViewById(R.id.Title_1)
            val buttomTv : TextView = itemView.findViewById(R.id.button)
            val SeeAll : TextView = itemView.findViewById(R.id.See_All)
            val ChildRecycleView : RecyclerView = itemView.findViewById(R.id.childAdidas)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_all_start_up_list_item,parent,false)
        return ParentViewHolder(view)
    }

    override fun getItemCount(): Int {
       return parentList.size
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
       val parentItem = parentList[position]
        holder.TitleTv.text = parentItem.title
        holder.buttomTv.text = parentItem.open
        holder.SeeAll.text = parentItem.seeAll
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(parentItem)
        }


        holder.ChildRecycleView.setHasFixedSize(true)
        holder.ChildRecycleView.layoutManager = LinearLayoutManager(holder.itemView.context,RecyclerView.HORIZONTAL,false)

        val adapter = ChildAdapterAllFavourite(parentItem.mList)
        holder.ChildRecycleView.adapter = adapter

    }

}