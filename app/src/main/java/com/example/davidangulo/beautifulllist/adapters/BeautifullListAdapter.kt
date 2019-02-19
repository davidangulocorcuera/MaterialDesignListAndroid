package com.example.davidangulo.beautifulllist.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.davidangulo.beautifulllist.R
import com.example.davidangulo.beautifulllist.model.Card
import java.util.ArrayList

class BeautifullListAdapter(
    private val cards: ArrayList<Card>,
    val mListener: OnCellItemClickListener? = null
) : RecyclerView.Adapter<BeautifullListAdapter.ViewHolder>() {

    // Define the listener interface
    interface OnCellItemClickListener {
        fun onItemClick(item: Card)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            mListener?.onItemClick(cards[position])
        }
        holder.setValues(cards[position])
    }

    override fun getItemCount(): Int {
        return cards.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_layout, parent, false))
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private val nameTextView = view.findViewById<TextView>(R.id.name_text)

        fun setValues(card: Card) {
           nameTextView.text = card.name
        }

    }
}
