package com.jssdvv.afi.presentation.navigation.features.directory

import com.arkivanov.decompose.ComponentContext

interface DirectoryInterface

class DirectoryComponent(
    componentContext: ComponentContext
) : DirectoryInterface, ComponentContext by componentContext {

}