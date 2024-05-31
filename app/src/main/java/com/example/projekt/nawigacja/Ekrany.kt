package com.example.projekt.nawigacja

sealed class Ekrany(val route: String) {
    object Logowanie: Ekrany(route = "logowanie_ekran")
    object EkranGlowny: Ekrany(route = "ekranglowny_ekran")
    object Zamowienie: Ekrany(route = "zamowienie_ekran")
}