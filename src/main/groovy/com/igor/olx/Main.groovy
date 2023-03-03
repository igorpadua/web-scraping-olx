package com.igor.olx

import com.igor.olx.calculos.Media
import com.igor.olx.scraping.Scraping
import groovy.transform.TypeChecked

@TypeChecked
static void main(String[] args) {
  // Pega anuncios
  List<Map> anuncios = []
  for (int i = 1; i <= 3; i++) {
    anuncios.addAll(Scraping.listaAnuncios(Scraping.pegaPagina("https://www.olx.com.br/estado-go/grande-goiania-e-anapolis?o=${i}&q=iPhone%2011")))
  }
  // Calcular media
  Float media = Media.calculaMedia(anuncios)
  // Remove anuncios acima da media
  anuncios.removeAll { anuncio -> anuncio.get('preco') > media }

}