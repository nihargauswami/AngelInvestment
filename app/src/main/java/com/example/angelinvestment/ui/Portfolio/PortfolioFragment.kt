package com.example.angelinvestment.ui.Portfolio

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.angelinvestment.Adapter.BottomSheetAdapter
import com.example.angelinvestment.Model.BottomSheetModel
import com.example.angelinvestment.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.MPPointF
import com.google.android.material.bottomsheet.BottomSheetDialog


class PortfolioFragment : Fragment() {

    private lateinit var chart : PieChart
    private lateinit var adapter: BottomSheetAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var  btnBottomSheetView: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       val view : View =  inflater.inflate(R.layout.fragment_portfolio, container, false)

        chart = view.findViewById(R.id.PieChart)
        configChartView()

        btnBottomSheetView = view.findViewById(R.id.bottom_Sheet_View)
        btnBottomSheetView.setOnClickListener{
         val dialog = BottomSheetDialog(requireContext())
         val bottomSheet = layoutInflater.inflate(R.layout.bottom_sheet_recycler_view,null)
         dialog.setCancelable(true)
         dialog.setContentView(bottomSheet)
         dialog.show()
//         setdataBottomsheet()
//            recyclerView = view.findViewById(R.id.recycler_view_bottom_sheet)
//            recyclerView.setHasFixedSize(true)
//            recyclerView.layoutManager = LinearLayoutManager(requireContext())
//            adapter = BottomSheetAdapter()
//            recyclerView.adapter = adapter
//            val bottomsheetList =ArrayList<BottomSheetModel>()
//
//            bottomsheetList.add(BottomSheetModel("Nihar",R.drawable.ellipse_38,"5","20,410","20,410","Direct"))



}


        val button1: Button = view.findViewById(R.id.Check_and_Text)
        button1.setOnClickListener{
            val i = Intent(activity,TextandOtherDetailsActivity::class.java)
            startActivity(i)
        }
        val button2: Button = view.findViewById(R.id.Pending_Docs)
        button2.setOnClickListener{
            val j = Intent(activity,PendingDocsActivity::class.java)
            startActivity(j)
        }
        return view
    }
//
//    private fun setdataBottomsheet() {
//        }

    private fun configChartView() {
        val list  : ArrayList<PieEntry> = ArrayList()
        list.add(PieEntry(45f,"IT/ITES"))
        list.add(PieEntry(35f,"Agri Tech"))
        list.add(PieEntry(25f,"Agri Tech"))
        list.add(PieEntry(10f,"Agri Tech"))
        list.add(PieEntry(15f,"Agri Tech"))
        val pieDataSet = PieDataSet(list,"list")
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS,255)

        pieDataSet.valueTextSize = 15f

        pieDataSet.valueTextColor = Color.BLACK

        val pieData = PieData(pieDataSet)

        chart.data = pieData

        chart.description.text = "Investment"
        chart.description.textAlign = Paint.Align.CENTER
        chart.centerText = "list"
        chart.animateY(2000)
        }
    }

