package com.example.davidangulo.beautifulllist.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidangulo.beautifulllist.R
import com.example.davidangulo.beautifulllist.adapters.BeautifullListAdapter
import com.example.davidangulo.beautifulllist.model.Card
import android.widget.GridLayout.HORIZONTAL
import android.support.v7.widget.DividerItemDecoration




class BeautifullListFragment : Fragment() {
    private var listener: OnFragmentInteractionListener? = null
    private var data = 0
    private var cards: ArrayList<Card> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beautifull_list, container, false).apply {
            findViewById<RecyclerView>(R.id.recyclerView_beautifull_list).apply {
                layoutManager = LinearLayoutManager(this.context)
                cards.addAll(
                    arrayOf(
                        Card("Example Title","This is a example of cell",1),
                        Card("Example Title","This is a example of cell",1)
                    )
                )
                this.addItemDecoration(
                    DividerItemDecoration(
                        this.context,
                        DividerItemDecoration.VERTICAL
                    )
                )

                adapter = BeautifullListAdapter(cards, mListItemListener)

            }
        }
    }

    private val mListItemListener = object : BeautifullListAdapter.OnCellItemClickListener {
        override fun onItemClick(item: Card) {
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
        fun onFragmentInteraction(card: Card, usedClass: Int)
    }

    companion object {
        fun newInstance(page: Int, title: String): BeautifullListFragment {
            val beautifullListFragment = BeautifullListFragment()
            val args = Bundle()
            args.putInt("someInt", page)
            args.putString("someTitle", title)
            beautifullListFragment.arguments = args
            return beautifullListFragment
        }
    }
}


