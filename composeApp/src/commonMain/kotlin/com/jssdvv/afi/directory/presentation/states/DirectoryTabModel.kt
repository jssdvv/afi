package com.jssdvv.afi.directory.presentation.states

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.jssdvv.afi.directory.data.repositories.HttpRepositoryImpl
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DirectoryTabModel : ScreenModel {

    private val url = "https://uis.edu.co/uis-directorio-funcionarios-es/"
    private val _httpResponse = MutableStateFlow("")
    val httpResponse = _httpResponse.asStateFlow()
    fun getHtmlAsText(){
        screenModelScope.launch {
            _httpResponse.value = HttpRepositoryImpl().httpGetRequest(url).bodyAsText()
        }
    }
}