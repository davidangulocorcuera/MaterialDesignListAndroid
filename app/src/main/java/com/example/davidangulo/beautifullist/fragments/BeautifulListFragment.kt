package com.example.davidangulo.beautifullist.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidangulo.beautifullist.R
import com.example.davidangulo.beautifullist.adapters.BeautifulListAdapter
import com.example.davidangulo.beautifullist.model.Article
import com.example.davidangulo.beautifullist.model.CellItem


class BeautifulListFragment : Fragment() {
    private var listener: OnFragmentInteractionListener? = null
    private var data = 0
    private var cards: ArrayList<CellItem> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_beautifull_list, container, false)
        view.apply {
            findViewById<RecyclerView>(R.id.recyclerView_beautifull_list).apply {
                layoutManager = LinearLayoutManager(this.context)
                cards.addAll(
                    arrayOf(
                        Article("Lorem ipsum", "Lorem ipsum dolor sit amet, consectetur     ",1),
                        Article("Lorem ipsum", "Lorem ipsum dolor sit amet, consectetur     ",1)

                )
                )
                adapter = BeautifulListAdapter(cards, mListItemListener)

            }
        }
        return view
    }

    private val mListItemListener = object : BeautifulListAdapter.OnCellItemClickListener {
        override fun onItemClick(item: CellItem) {
            listener?.onFragmentInteraction(item, data)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(cellItem: CellItem, usedClass: Int)
    }

    companion object {
        fun newInstance(page: Int, title: String): BeautifulListFragment {
            val beautifulListFragment = BeautifulListFragment()
            val args = Bundle()
            args.putInt("someInt", page)
            args.putString("someTitle", title)
            beautifulListFragment.arguments = args
            return beautifulListFragment
        }
    }
}


