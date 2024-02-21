package com.jssdvv.afi.data.repositories

import com.jssdvv.afi.domain.repositories.KsoupRepository
import com.mohamedrejeb.ksoup.html.parser.KsoupHtmlHandler
import com.mohamedrejeb.ksoup.html.parser.KsoupHtmlOptions
import com.mohamedrejeb.ksoup.html.parser.KsoupHtmlParser

class KsoupRepositoryImpl : KsoupRepository {
    override fun parseHtml(html: String) {
        val ksoupHtmlHandler = KsoupHtmlHandler
            .Builder()
            .build()
        val ksoupHtmlOptions = KsoupHtmlOptions(
            xmlMode = false,
            decodeEntities = true,
        )
        val ksoupHtmlParser = KsoupHtmlParser(
            handler = ksoupHtmlHandler,
            options = ksoupHtmlOptions
        )

        ksoupHtmlParser.write(html)
        ksoupHtmlParser.end()
    }

    override fun parseXml(xml: String) {
        val ksoupHtmlHandler = KsoupHtmlHandler
            .Builder()
            .build()

        val ksoupHtmlOptions = KsoupHtmlOptions(
            xmlMode = true,
            decodeEntities = true,
        )
        val ksoupHtmlParser = KsoupHtmlParser(
            handler = ksoupHtmlHandler,
            options = ksoupHtmlOptions
        )

        ksoupHtmlParser.write(xml)
        ksoupHtmlParser.end()
    }
}