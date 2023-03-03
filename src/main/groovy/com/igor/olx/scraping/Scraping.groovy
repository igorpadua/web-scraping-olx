package com.igor.olx.scraping

import groovy.transform.TypeChecked
import groovyx.net.http.HttpBuilder
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

@TypeChecked
class Scraping {
    static Document pegaPagina(String url) {
        return HttpBuilder.configure {
            request.uri = url
        }.get() as Document
    }

    static List<Map> listaAnuncios(Document pagina) {
        // Pega Anuncios
        Element anuncios = pagina.getElementById('ad-list')
        List<Element> anunciosList = anuncios.getElementsByTag('a')

        List<Map> dados = []

        // Pega dados
        anunciosList.each { anuncio ->
            // Pega colunas
            String titulo = anuncio.attr('title')
            // Tira virgula do titulo
            titulo = titulo.replace(',', '')
            String url = anuncio.attr('href')
            String preco = anuncio.getElementsByAttributeValueContaining('aria-label', 'Preço do item').text()
            String regiao = anuncio.getElementsByAttributeValueContaining('aria-label', 'Localização').text()
            // tira virgula da regiao
            regiao = regiao.replace(',', '')

            // Preco em float
            Float precoFloat
            try {
                precoFloat = preco.replace('R$', '').replace('.', '').replace(',', '.').trim().toFloat()
            } catch (Exception ignored) {
                precoFloat = 0.0f
            }

            // Adiciona dados
            if (precoFloat != 0.0f && titulo != null) {
                dados.add([
                        titulo: titulo,
                        preco: precoFloat,
                        regiao: regiao,
                        url: url
                ])
            }
        }
        return dados
    }
}
