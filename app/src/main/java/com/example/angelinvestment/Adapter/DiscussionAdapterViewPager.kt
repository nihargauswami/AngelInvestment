package com.example.angelinvestment.Adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.angelinvestment.ui.Discussion.PostOfTheDayFragment

class DiscussionAdapterViewPager (fragment: Fragment) : FragmentStateAdapter(fragment)  {


    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        val fragment = PostOfTheDayFragment()
        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putInt(ARG_OBJECT, position)
        }
        return fragment
    }
}
private const val ARG_OBJECT = "All Startups"