package com.example.angelinvestment.ui.StartUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.angelinvestment.Adapter.StartUpFragmentAdapter
import com.example.angelinvestment.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

@Suppress("UNREACHABLE_CODE")
class StartUpFragment : Fragment() {

    private lateinit var demoCollectionAdapter: StartUpFragmentAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_up, container, false)
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            demoCollectionAdapter = StartUpFragmentAdapter(this)
            viewPager = view.findViewById(R.id.ViewPager2)
            viewPager.adapter = demoCollectionAdapter


         tabLayout = view.findViewById(R.id.tablayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()
    }


}


