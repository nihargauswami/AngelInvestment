package com.example.angelinvestment.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.angelinvestment.Model.BottomSheetModel
import com.example.angelinvestment.R

class BottomSheetAdapter(var bottomsheetList :ArrayList<BottomSheetModel>):RecyclerView.Adapter<BottomSheetAdapter.MyViewHolder>() {


    fun filterList(filterlist: ArrayList<BottomSheetModel>) {
        // below line is to add our filtered
        // list in our course array list.
        bottomsheetList = filterlist
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvName : TextView = itemView.findViewById(R.id.tv_Name_Bottom_Sheet)
        val tvImage : ImageView = itemView.findViewById(R.id.circleImageView4)
        val tvShare : TextView = itemView.findViewById(R.id.Num_Share)
        val tvShareAmount : TextView = itemView.findViewById(R.id.Share_Prize)
        val tvTotalAmount : TextView = itemView.findViewById(R.id.Total_Amount)
        val tvType :TextView = itemView.findViewById(R.id.Type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.bottom_sheet_recycler_view,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return bottomsheetList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = bottomsheetList[position].tvName
        holder.tvShare.text = bottomsheetList[position].Shares
        holder.tvShareAmount.text = bottomsheetList[position].SharePrice
        holder.tvTotalAmount.text = bottomsheetList[position].TotalAmount
        holder.tvType.text = bottomsheetList[position].Type
        holder.tvImage.setImageResource(bottomsheetList[position].ivImage)
    }


}