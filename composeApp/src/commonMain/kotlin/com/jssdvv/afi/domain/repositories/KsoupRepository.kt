package com.jssdvv.afi.domain.repositories

interface KsoupRepository {
    fun parseHtml(html: String)

    fun parseXml(xml: String)
}