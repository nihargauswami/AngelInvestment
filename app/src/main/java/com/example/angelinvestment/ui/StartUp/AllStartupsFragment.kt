package com.example.angelinvestment.ui.StartUp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.angelinvestment.Adapter.ParentAdapterAllStartsUp
import com.example.angelinvestment.Model.ChildItemAllFavourite
import com.example.angelinvestment.Model.ParentItemAllFavourite
import com.example.angelinvestment.R


@Suppress("UNREACHABLE_CODE")
class AllStartupsFragment : Fragment(){

    private lateinit var recyclerView: RecyclerView
    lateinit var adapter: ParentAdapterAllStartsUp

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =  inflater.inflate(R.layout.fragment_all_startups, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val parentList: ArrayList<ParentItemAllFavourite> = ArrayList()
        recyclerView = view.findViewById(R.id.parentAdidas)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = ParentAdapterAllStartsUp(parentList)
        recyclerView.adapter = adapter



        val ChildItem1 = ArrayList<ChildItemAllFavourite>()
        ChildItem1.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem1.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem1.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem1.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem1.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem1.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem1.add(ChildItemAllFavourite(R.drawable.devidas))
        parentList.add(ParentItemAllFavourite("INVESTMENT", "Yet to Open","See all", ChildItem1))

        val ChildItem2 = ArrayList<ChildItemAllFavourite>()
        ChildItem2.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem2.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem2.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem2.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem2.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem2.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem2.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem2.add(ChildItemAllFavourite(R.drawable.devidas))

        parentList.add(ParentItemAllFavourite("INVESTMENT", "In Progress","See all", ChildItem2))
        val ChildItem3 = ArrayList<ChildItemAllFavourite>()
        ChildItem3.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem3.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem3.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem3.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem3.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem3.add(ChildItemAllFavourite(R.drawable.devidas))
        ChildItem3.add(ChildItemAllFavourite(R.drawable.devidas))


        parentList.add(ParentItemAllFavourite("INVESTMENT", "Closed", "See all",ChildItem3))

//        val navigationTextView : TextView = view.findViewById(R.id.See_All)
//        navigationTextView.setOnClickListener {
//            val destinationFragment : Fragment = SeeAllStartUPFragment()
//            val transaction = requireFragmentManager().beginTransaction()
//
//            transaction.replace(R.id.See_all_fragment, destinationFragment)
//
//            transaction.commit()

//        }

        adapter.onItemClick = {


                val textView: TextView = view.findViewById(R.id.See_All)

        textView.setOnClickListener {
            val intent = Intent(activity , TestActivity::class.java)
            startActivity(intent)
        }

    }
    }




}

