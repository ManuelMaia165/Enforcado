package com.example.enforcado.repository

class BancodePalavras {
    private var listaPalavras = HashMap<String, String>()
    private var palavra = String()

    init {
        listaPalavras.putAll(
            mapOf(
                "Bicicleta" to "Moto sem Motor",
                "Skate" to "Placa sobre Rodas",
                "Pug" to "Dog achatado",
                "Gato" to "Gosta de Peixe",
                "Banana" to "Fruta Amarela",
                "Computador" to "Alma do Gamer",
            )
        )
    }

    fun adicionar(palavra: String, dica: String) {
        this.listaPalavras[palavra] = dica
    }

    fun remover(palavra: String) {
        this.listaPalavras.remove(palavra)
    }

    fun sortear() {
        this.palavra = this.listaPalavras.keys.random()
    }

    fun palavra(): String {
        return this.palavra
    }

    fun dica(): String {
        return this.listaPalavras.getValue(this.palavra)
    }
}