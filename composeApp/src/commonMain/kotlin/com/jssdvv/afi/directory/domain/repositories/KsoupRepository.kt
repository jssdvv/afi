package com.jssdvv.afi.directory.domain.repositories

interface KsoupRepository {
    fun parseHtml(html: String)

    fun parseXml(xml: String)
}