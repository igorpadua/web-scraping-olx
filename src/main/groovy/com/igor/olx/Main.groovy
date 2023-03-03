package com.igor.olx

import com.igor.olx.scraping.Scraping
import groovy.transform.TypeChecked

@TypeChecked
static void main(String[] args) {
  Scraping.listaAnuncios(Scraping.pegaPagina('https://www.olx.com.br/estado-go/grande-goiania-e-anapolis?q=iPhone%2011'))
}