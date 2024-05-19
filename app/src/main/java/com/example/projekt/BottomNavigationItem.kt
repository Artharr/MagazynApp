package com.example.projekt

data class BottomNavigationItem(
    val title: String,
    val icon: Int,
    var hasNews: Boolean,
    var badgeCount: Int? = null)
