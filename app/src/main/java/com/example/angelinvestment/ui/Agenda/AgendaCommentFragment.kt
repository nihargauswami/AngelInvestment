package com.example.angelinvestment.ui.Agenda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.angelinvestment.R


class AgendaCommentFragment : Fragment() {
private lateinit var text : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_agenda_comment, container, false)

        text = view.findViewById(R.id.Text_Comment)
        val data = arguments
        text.text = data!!.get("string").toString()
        return view
    }


    }