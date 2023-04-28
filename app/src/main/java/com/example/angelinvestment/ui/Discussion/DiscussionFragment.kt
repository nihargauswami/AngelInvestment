package com.example.angelinvestment.ui.Discussion

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.angelinvestment.Adapter.DiscussionAdapterViewPager
import com.example.angelinvestment.Adapter.MyAdapterDiscussion
import com.example.angelinvestment.Model.UserModelDiscussion
import com.example.angelinvestment.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator



@SuppressLint("StaticFieldLeak")
lateinit var adapter: MyAdapterDiscussion

class DiscussionFragment : Fragment() {
    private lateinit var tabLayout: TabLayout
    private lateinit var demoCollectionAdapter: DiscussionAdapterViewPager
    private lateinit var viewPager: ViewPager2

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_discussion, container, false)


        val ShareButton: ImageView = view.findViewById(R.id.ShareButton)
        ShareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Check Out This Cool Application")
            intent.putExtra(
                Intent.EXTRA_TEXT, "Check Out This Cool Application \n " +
                        "https://play.google.com/store/apps/details?id=com.example.angelinvestment"
            )
            startActivity(Intent.createChooser(intent, "Share Via"))
            return@setOnClickListener
        }

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userList : ArrayList<UserModelDiscussion> = ArrayList()
        val userRecyclerView: RecyclerView = view.findViewById(R.id.Recycle_View_Discussion)
        userRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        userRecyclerView.setHasFixedSize(true)
        userList.add(UserModelDiscussion(R.drawable.photodiscussion,"Nihar","7 hours ago at 10 : 30 AM","Text Message"))
        userList.add(UserModelDiscussion(R.drawable.photodiscussion,"Nihar","7 hours ago at 10 : 30 AM","Text Message"))
        userList.add(UserModelDiscussion(R.drawable.photodiscussion,"Nihar","7 hours ago at 10 : 30 AM","Text Message"))
        userList.add(UserModelDiscussion(R.drawable.photodiscussion,"Nihar","7 hours ago at 10 : 30 AM","Text Message"))
        userList.add(UserModelDiscussion(R.drawable.photodiscussion,"Nihar","7 hours ago at 10 : 30 AM","Text Message"))
        userList.add(UserModelDiscussion(R.drawable.photodiscussion,"Nihar","7 hours ago at 10 : 30 AM","Text Message"))
        userList.add(UserModelDiscussion(R.drawable.photodiscussion,"Nihar","7 hours ago at 10 : 30 AM","Text Message"))
        userList.add(UserModelDiscussion(R.drawable.photodiscussion,"Nihar","7 hours ago at 10 : 30 AM","Text Message"))

        adapter = MyAdapterDiscussion(userList)
        userRecyclerView.adapter = adapter


        demoCollectionAdapter = DiscussionAdapterViewPager(this)
        viewPager = view.findViewById(R.id.viewPager1)
        viewPager.adapter = demoCollectionAdapter

        tabLayout = view.findViewById(R.id.tablayout1)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "*"
        }.attach()


        adapter.onItemClick = {
            val text : TextView = view.findViewById(R.id.tvText_ReadMore_Discussion)
            text.setOnClickListener {
                val intent = Intent(activity,DiscussionDetailsActivity::class.java)
                startActivity(intent)
            }
        }

    }


}
