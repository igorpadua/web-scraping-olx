package com.igor.olx.calculos

class Media {
    static Float calculaMedia(List<Map> lista) {
        Float soma = 0.0f
        lista.each { anuncio ->
            soma += anuncio.get('preco')
        }
        return soma / lista.size()
    }
}
