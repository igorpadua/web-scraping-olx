package scraping

import groovyx.net.http.HttpBuilder
import org.jsoup.nodes.Document

class Scraping {
    static Document pegaPagina(String url) {
        return HttpBuilder.configure {
            request.uri = url
        }.get() as Document
    }
}
