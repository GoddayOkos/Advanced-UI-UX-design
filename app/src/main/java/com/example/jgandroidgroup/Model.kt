package com.example.week4first

data class Time (val days : String, val hours : String, val minutes : String)
data class Tweet (val tweet: String)


object Supplier{
    val times = listOf(
        Time("02","14","20"),
        Time("03","19","34"),
        Time("00","14","50"),
        Time("02","20","30"),
        Time("02","16","20"),
        Time("04","14","26"),
    )

    val tweets = listOf(
        Tweet("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor"),
        Tweet("Lorem ipsum dolor sit amet, consectetur adipig elit, sed do eiusmod tempor"),
        Tweet("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor kjksdhe jhkjahhs jukkuweiubd bdiedkiuewke edgkwejhdiuwedk ukhuiudheiud"),
        Tweet("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor")
    )
}
