package br.edu.ifpb.jogodaforcapart2.repositorio

class BancoPalavras {
    private var bancoPalavras = hashMapOf<String, String>()
    private var palavraChave  = ""

    fun add(palavra: String, dica: String) {
        bancoPalavras.put(palavra, dica)
    }

    fun sortearPalavra() {
        this.palavraChave = bancoPalavras.keys.random()!!
    }

    fun getPalavra(): String {
        return this.palavraChave
    }

    fun getDica(): String {
        return bancoPalavras.getValue(this.palavraChave)
    }
}