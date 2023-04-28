package com.example.angelinvestment.ui.Discussion

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.angelinvestment.R

class CommentDiscussionFragment : Fragment() {
lateinit var text : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_comment_discussion, container, false)
            text = view.findViewById(R.id.Comment_Discussion)
        val data   = arguments
        text.text = data!!.getString("String").toString()

    return view
    }

    }
