package com.example.enforcado.facade

import com.example.enforcado.model.Forca
import com.example.enforcado.repository.BancodePalavras

class Facade {
    private var banco: BancodePalavras = BancodePalavras()
    private var forca: Forca

    init {
        this.banco.sortear()
        this.forca = Forca(this.banco.palavra(), this.banco.dica())
    }

    fun terminou(): Boolean {
        return this.forca.terminou()
    }

    fun jogar(letra: String) {
        try {
            this.forca.descobrirPalavra(letra.uppercase())

        } catch (e: Throwable) {
            println(e.message)
        }

    }

    fun errosImagem(): Int {
        return this.forca.erros()
    }

    fun resultado(): Boolean {
        return this.forca.resultado()
    }

    fun dica(): String {
        return this.forca.dica()
    }

    fun quantLetras(): String {
        return this.forca.quantLetras().toString()
    }

    fun quantLetrasDist(): String {
        return this.forca.quantLetrasDist().toString()
    }

    fun letrasUsadas(): String {
        return this.forca.letrasUsadas()
    }

    fun acertos(): String {
        return this.forca.acertos().toString()
    }

    fun erros(): String {
        return this.forca.erros().toString()
    }

    fun palavraEscondida(): String {
        return this.forca.palavraEscondida()
    }

}
