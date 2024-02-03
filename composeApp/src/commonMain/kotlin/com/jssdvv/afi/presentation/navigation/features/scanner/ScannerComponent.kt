package com.jssdvv.afi.presentation.navigation.features.scanner

import com.arkivanov.decompose.ComponentContext

interface ScannerInterface

class ScannerComponent(
    componentContext: ComponentContext
) : ScannerInterface, ComponentContext by componentContext { }