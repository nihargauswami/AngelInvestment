package com.example.angelinvestment.Model

data class ParentItemAllFavourite(

    val title : String,
    val open : String,
    val seeAll : String,
    val mList: List<ChildItemAllFavourite>
)
