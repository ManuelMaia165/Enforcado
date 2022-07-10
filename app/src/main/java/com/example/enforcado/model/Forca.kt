package com.example.enforcado.model

class Forca(palavra: String, dica: String) {
    private var acertos: Int = 0
    private var erros: Int = 0
    private var letra: Char
    private var letrasUsadas: MutableList<Char>
    private var dica: String
    private var palavra: MutableList<Char>
    private var palavraEscondida: MutableList<Char>
    private var penalidades: MutableList<String>

    init {
        this.letra = " ".single()
        this.dica = dica.uppercase()
        this.palavra = palavra.trim().uppercase().toMutableList()
        this.palavraEscondida = mutableListOf()
        this.letrasUsadas = mutableListOf()
        this.penalidades = mutableListOf(
            "perna direita",
            "perna esquerda",
            "mão direita",
            "mão esquerda",
            "tronco",
            "cabeça"
        )
    }


    fun testarLetra(letra: String) {
        if (letra.length > 1) {
            throw Throwable("--Você digitou mais que uma letra, tente mais uma vez--")
        }
        if (this.letrasUsadas.contains(letra.single())) {
            throw Throwable("--Você já digitou essa letra--")
        }
        this.letrasUsadas.add(letra.single())
        this.letra = letra.single()
    }

    fun letrasUsadas(): String {
        return this.letrasUsadas.joinToString(", ")
    }

    fun descobrirPalavra(letra: String) {
        // Verificar se é uma unica letra
        testarLetra(letra)

        if (this.palavra.contains(this.letra)) {
            acertou()
        } else {
            errou()
        }
        palavraEscondida()
    }

    private fun acertou() {
        for (i in 0 until this.palavra.size) {
            if (this.palavra[i] == this.letra) {
                this.palavraEscondida[i] = this.letra
                this.acertos++
            }
        }
    }

    private fun errou() {
        this.erros++
    }

    fun palavraEscondida(): String {
        if (this.palavraEscondida.size == 0) {
            for (indice in 0 until this.palavra.size) {
                this.palavraEscondida.add('_')
            }
        }
        return this.palavraEscondida.joinToString(" ")
    }

    fun quantLetras(): Int {
        return this.palavra.size
    }

    fun quantLetrasDist(): Int {
        return this.palavra.distinct().size
    }

    fun acertos(): Int {
        return this.acertos
    }

    fun erros(): Int {
        return this.erros
    }

    fun palavra(): String {
        return this.palavra.joinToString("")
    }

    fun dica(): String {
        return this.dica
    }

    fun penalidade(): List<String> {
        return this.penalidades.toList().subList(0, this.erros)
    }

    fun resultado(): Boolean {
        return this.acertos == this.palavra.size
    }

    fun terminou(): Boolean {
        return this.erros == 6 || this.acertos == this.palavra.size
    }
}
