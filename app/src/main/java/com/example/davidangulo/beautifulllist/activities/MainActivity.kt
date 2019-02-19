package com.example.davidangulo.beautifulllist.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.davidangulo.beautifulllist.R
import com.example.davidangulo.beautifulllist.fragments.BeautifullListFragment
import com.example.davidangulo.beautifulllist.model.Card

class MainActivity : AppCompatActivity(), BeautifullListFragment.OnFragmentInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment()
    }
    private fun showFragment() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_beautifull_list, BeautifullListFragment.newInstance(1, "list"))
            addToBackStack(null)
        }.commit()
    }
    override fun onFragmentInteraction(card: Card, usedClass: Int) {

    }
}
