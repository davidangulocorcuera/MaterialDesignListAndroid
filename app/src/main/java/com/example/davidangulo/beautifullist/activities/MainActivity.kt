package com.example.davidangulo.beautifullist.activities


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.davidangulo.beautifullist.R
import com.example.davidangulo.beautifullist.dialogs_fragments.CellInfoDialogFragment
import com.example.davidangulo.beautifullist.fragments.BeautifulListFragment
import com.example.davidangulo.beautifullist.model.CellItem


class MainActivity : AppCompatActivity(), BeautifulListFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(cellItem: CellItem, usedClass: Int) {
        val bundle = Bundle()
        bundle.putParcelable("card", cellItem)
        CellInfoDialogFragment.newInstance(cellItem).apply {
            showNow(supportFragmentManager, "tag")
            arguments = bundle
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment()



    }
    private fun showFragment() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_beautifull_list, BeautifulListFragment.newInstance(1, "list"))
            addToBackStack(null)
        }.commit()
    }






}
