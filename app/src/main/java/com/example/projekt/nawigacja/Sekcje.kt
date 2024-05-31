package com.example.projekt.nawigacja

sealed class Sekcje(val route: String) {
    object Kompletowanie: Sekcje(route = "kompletowanie_sekcja")
    object Wydawanie: Sekcje(route = "wydawanie_sekcja")
    object Ustawienia: Sekcje(route = "ustawienia_sekcja")
}