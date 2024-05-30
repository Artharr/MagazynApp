package com.example.projekt

sealed class Screen(val route: String) {
    object Kompletowanie: Screen(route = "kompletowanie_screen")
    object Wydawanie: Screen(route = "wydawanie_screen")
    object Ustawienia: Screen(route = "ustawienia_screen")
}