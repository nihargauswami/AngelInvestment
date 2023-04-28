package com.example.angelinvestment.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.angelinvestment.Model.PendingDocs
import com.example.angelinvestment.R
import com.example.angelinvestment.ui.Portfolio.PendingDocsActivity

class PendingDocsAdapter(private val pendingList: List<PendingDocs>,
                         val listener: MyClickListener
):
    RecyclerView.Adapter<PendingDocsAdapter.MyViewHolder>() {

inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {


    val Name: TextView = itemView.findViewById(R.id.TvName_Pending)
    val HardCopy: TextView = itemView.findViewById(R.id.Hard_Copy)
    val amount: TextView = itemView.findViewById(R.id.Amount)

    init {
        itemView.setOnClickListener {
            val position = adapterPosition
            listener.onClick(position)
        }
    }
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_pending_docs,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return pendingList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.Name.text = pendingList[position].name
        holder.HardCopy.text = pendingList[position].GPAO
        holder.amount.text = pendingList[position].Amount
    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
}