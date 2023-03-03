package com.igor.olx.DAO

class CSV {
    static void criaCsv(List<Map> lista) {
        def csv = new File('anuncios.csv')
        csv.withWriter { writer ->
            writer << "Titulo,Preco,Regiao,Url\n"
            lista.each { anuncio ->
                writer << "${anuncio.get('titulo')},${anuncio.get('preco')},${anuncio.get('regiao')},${anuncio.get('url')}\n"
            }
        }
    }
}
