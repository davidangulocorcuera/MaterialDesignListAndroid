package com.example.davidangulo.beautifullist.dialogs_fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidangulo.beautifullist.R
import com.example.davidangulo.beautifullist.model.CellItem

class CellInfoDialogFragment : DialogFragment() {
     var card: CellItem? = null

    companion object {
        fun newInstance(item: CellItem) = CellInfoDialogFragment().apply {
            arguments = Bundle().apply {
                putParcelable("card", card)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            card = it.getParcelable("card")
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.dialog_fragment_cell_info, container, false)
        return v
    }

}