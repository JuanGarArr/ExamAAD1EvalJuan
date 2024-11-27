package edu.iesam.examaad1eval.features.ex2.feature.domain

data class Game(val id: String, val title: String, val players: List<Players>)
data class Players(val id: String, val name: String)
