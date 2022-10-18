package com.example.chapter5chalange.logic

class LogicGame(private val resultCallback: ResultCallback) : IdentifiedPlay {
    override fun identified(playerSatu: String, playerDua: String) {
        when {
            playerSatu == playerDua -> {
                resultCallback.result("Draw")
            }
            playerSatu == "batu" && playerDua == "gunting" ||
                    playerSatu == "gunting" && playerDua == "kertas" ||
                    playerSatu == "kertas" && playerDua == "batu" -> {
                resultCallback.result("Player 1 Menang")
            }
            else -> {
                resultCallback.result("Player 2 Menang")

            }

        }
    }


}