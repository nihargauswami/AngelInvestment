package com.example.angelinvestment.ui.Agenda

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.angelinvestment.Adapter.MyAdapterAgenda
import com.example.angelinvestment.Model.UserModelAgenda
import com.example.angelinvestment.R

private lateinit var userRecyclerView: RecyclerView
lateinit var adapter: MyAdapterAgenda


class AgendaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_agenda, container, false)

//        button.setOnClickListener {
//            val i = Intent(activity, AgendaDetailsActivity::class.java)
//            startActivity(i)
//        }




        return view

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userList : ArrayList<UserModelAgenda> = ArrayList()
        userRecyclerView = view.findViewById(R.id.Recycle_View_1)
        userRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        userRecyclerView.setHasFixedSize(true)
        adapter = MyAdapterAgenda(userList)
        userRecyclerView.adapter = adapter


        userList.add(UserModelAgenda(R.drawable.photo,"MERCIDES","01 Feb 2023","12 : 30 Pm to 01 : 30PM","Nihar Gauswami","Register"))
        userList.add(UserModelAgenda(R.drawable.photo,"MERCIDES","01 Feb 2023","12 : 30 Pm to 01 : 30PM","Nihar Gauswami","Register"))
        userList.add(UserModelAgenda(R.drawable.photo,"MERCIDES","01 Feb 2023","12 : 30 Pm to 01 : 30PM","Nihar Gauswami","Register"))
        userList.add(UserModelAgenda(R.drawable.photo,"MERCIDES","01 Feb 2023","12 : 30 Pm to 01 : 30PM","Nihar Gauswami","Register"))
        userList.add(UserModelAgenda(R.drawable.photo,"MERCIDES","01 Feb 2023","12 : 30 Pm to 01 : 30PM","Nihar Gauswami","Register"))
        userList.add(UserModelAgenda(R.drawable.photo,"MERCIDES","01 Feb 2023","12 : 30 Pm to 01 : 30PM","Nihar Gauswami","Register"))
        userList.add(UserModelAgenda(R.drawable.photo,"MERCIDES","01 Feb 2023","12 : 30 Pm to 01 : 30PM","Nihar Gauswami","Register"))
        userList.add(UserModelAgenda(R.drawable.photo,"MERCIDES","01 Feb 2023","12 : 30 Pm to 01 : 30PM","Nihar Gauswami","Register"))
        userList.add(UserModelAgenda(R.drawable.photo,"MERCIDES","01 Feb 2023","12 : 30 Pm to 01 : 30PM","Nihar Gauswami","Register"))
        userList.add(UserModelAgenda(R.drawable.photo,"MERCIDES","01 Feb 2023","12 : 30 Pm to 01 : 30PM","Nihar Gauswami","Register"))

        adapter.onItemClick = {
           val button : TextView = view.findViewById(R.id.Register_Agenda)
            button.setOnClickListener {
                val intent = Intent(activity , AgendaDetailsActivity::class.java)
                startActivity(intent)
            }
        }
    }
}