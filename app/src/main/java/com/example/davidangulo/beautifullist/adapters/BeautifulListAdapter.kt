package com.example.davidangulo.beautifullist.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.davidangulo.beautifullist.R
import com.example.davidangulo.beautifullist.model.CellItem

class BeautifulListAdapter(
    private val cards: ArrayList<CellItem>,
    private val mListener: OnCellItemClickListener? = null
) : RecyclerView.Adapter<BeautifulListAdapter.ViewHolder>() {

    // Define the listener interface
    interface OnCellItemClickListener {
        fun onItemClick(item: CellItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cards[position]
        holder.itemView.setOnClickListener {
            mListener?.onItemClick(card)
        }
        holder.setValues(card,position)
    }

    override fun getItemCount(): Int {
        return cards.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_layout, parent, false))
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private val titleTextView = view.findViewById<TextView>(R.id.textView_title)
        private val descriptionTextView = view.findViewById<TextView>(R.id.textViewDescription)
        private val itemCounterTextView = view.findViewById<TextView>(R.id.textView_counter)
        //private val imageView = view.findViewById<TextView>(R.id.imageView_cellImage)



        fun setValues(cellItem: CellItem, position: Int) {
           titleTextView.text = cellItem.title
           descriptionTextView.text = cellItem.description
           itemCounterTextView.text = if (position < 10) position.toString().padStart(2, '0') else position.toString()

        }

    }
}
