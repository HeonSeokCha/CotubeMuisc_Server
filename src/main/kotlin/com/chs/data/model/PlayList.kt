package com.chs.data.model

data class PlayList(
    val tile: String,
    val imageUrl: String,
    val author: String,
    val description: String,
    val songs: List<Music>
)