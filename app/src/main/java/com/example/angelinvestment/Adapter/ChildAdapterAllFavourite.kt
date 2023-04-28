package com.example.angelinvestment.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.angelinvestment.Model.ChildItemAllFavourite
import com.example.angelinvestment.R

class ChildAdapterAllFavourite(private val ChildList : List<ChildItemAllFavourite>):RecyclerView.Adapter<ChildAdapterAllFavourite.ChildViewHolder> (){

inner class ChildViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

    val logoIv :ImageView = itemView.findViewById(R.id.tvAdidas)

}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChildAdapterAllFavourite.ChildViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.child_all_start_up_list_item,parent,false)
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildAdapterAllFavourite.ChildViewHolder, position: Int) {
        holder.logoIv.setImageResource(ChildList[position].logo)
    }

    override fun getItemCount(): Int {
        return ChildList.size
    }


}