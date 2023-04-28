package com.example.angelinvestment.ui.Portfolio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.angelinvestment.Adapter.PendingDocsAdapter
import com.example.angelinvestment.MainActivity
import com.example.angelinvestment.Model.PendingDocs
import com.example.angelinvestment.R

class PendingDocsActivity : AppCompatActivity(), PendingDocsAdapter.MyClickListener{
    private lateinit var recyclerView : RecyclerView
    private var pendingList = ArrayList<PendingDocs>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pending_docs)


        val button : ImageView = findViewById(R.id.back_to_main_Activity)
        button.setOnClickListener {
//                        onClick()
            val i = Intent(this , MainActivity::class.java)
            startActivity(i)
            }



        val adapter = PendingDocsAdapter(pendingList,this@PendingDocsActivity)
        recyclerView = findViewById(R.id.recycler_View_PendingDocs)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        pendingList.add(PendingDocs("nihar","Hard Copy","50,000"))
        pendingList.add(PendingDocs("nihar","Hard Copy","50,000"))
        pendingList.add(PendingDocs("nihar","Hard Copy","50,000"))
        pendingList.add(PendingDocs("nihar","Hard Copy","50,000"))
        pendingList.add(PendingDocs("nihar","Hard Copy","50,000"))
        pendingList.add(PendingDocs("nihar","Hard Copy","50,000"))
        pendingList.add(PendingDocs("nihar","Hard Copy","50,000"))
        pendingList.add(PendingDocs("nihar","Hard Copy","50,000"))
        pendingList.add(PendingDocs("nihar","Hard Copy","50,000"))
        pendingList.add(PendingDocs("nihar","Hard Copy","50,000"))
    }

    override fun onClick(position: Int) {
        when (position) {
            0 -> startActivity(Intent(this, PendingDocsDtailsActivity::class.java))
            1 -> startActivity(Intent(this, PendingDocsDtailsActivity::class.java))
            2 -> startActivity(Intent(this, PendingDocsDtailsActivity::class.java))
            3 -> startActivity(Intent(this, PendingDocsDtailsActivity::class.java))
            4 -> startActivity(Intent(this, PendingDocsDtailsActivity::class.java))
            5 -> startActivity(Intent(this, PendingDocsDtailsActivity::class.java))
            6 -> startActivity(Intent(this, PendingDocsDtailsActivity::class.java))
            7 -> startActivity(Intent(this, PendingDocsDtailsActivity::class.java))
            8 -> startActivity(Intent(this, PendingDocsDtailsActivity::class.java))
            9 -> startActivity(Intent(this, PendingDocsDtailsActivity::class.java))

        }
    }
//private fun onClick(){
//
//    val fragment = PortfolioFragment()
//    val fragmemtTransaction:  FragmentTransaction = supportFragmentManager.beginTransaction()
//    fragmemtTransaction.addToBackStack(null)
//    fragmemtTransaction.replace(R.id.container,fragment).commit()
//
//
//}
}