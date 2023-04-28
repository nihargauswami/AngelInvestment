package com.example.angelinvestment.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.angelinvestment.Model.InvestmentModel
import com.example.angelinvestment.R

class InvestmentAdapter(private var title : List<String>,private var image : List<Int>,val listener:MyClickListener):
    RecyclerView.Adapter<InvestmentAdapter.MyViewHolder>() {
//    private var investmentList = ArrayList<InvestmentModel>()


    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageIv : ImageView = itemView.findViewById(R.id.imageView6)
        val textTv : TextView = itemView.findViewById(R.id.textView8)
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_investment ,parent ,false)
    return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
      return title.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val parentList = investmentList[position]
        holder.imageIv.setImageResource(image[position])
        holder.textTv.text = title[position]
    }
    interface MyClickListener{
        fun onClick(position: Int)
    }


}