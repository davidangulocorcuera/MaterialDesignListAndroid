package com.example.davidangulo.beautifullist.model

import android.os.Parcelable

interface CellItem: Parcelable {
    var title: String
    var description: String
    var image: Int
}