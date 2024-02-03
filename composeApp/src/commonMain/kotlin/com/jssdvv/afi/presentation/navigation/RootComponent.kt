package com.jssdvv.afi.presentation.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.jssdvv.afi.presentation.navigation.features.directory.DirectoryComponent
import com.jssdvv.afi.presentation.navigation.features.formats.FormatsComponent
import com.jssdvv.afi.presentation.navigation.features.scanner.ScannerComponent
import kotlinx.serialization.Serializable

interface RootComponentRepository {
    val childStack: Value<ChildStack<*, Child>>
    sealed class Child {
        class ScannerChild(val component: ScannerComponent) : Child()
        class FormatsChild(val component: FormatsComponent) : Child()
        class DirectoryChild(val component: DirectoryComponent) : Child()
    }
}

class RootComponent(
    componentContext: ComponentContext
) : RootComponentRepository, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()
    override val childStack: Value<ChildStack<*, RootComponentRepository.Child>> = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Scanner,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: Config,
        componentContext: ComponentContext
    ): RootComponentRepository.Child {
        return when (config) {
            Config.Scanner -> {
                RootComponentRepository
                    .Child.ScannerChild(ScannerComponent(componentContext))
            }
            Config.Formats -> {
                RootComponentRepository
                    .Child.FormatsChild(FormatsComponent(componentContext))
            }
            is Config.Directory -> {
                RootComponentRepository
                    .Child.DirectoryChild(DirectoryComponent(componentContext))
            }
        }
    }

    @Serializable
    sealed class Config {
        @Serializable
        data object Scanner : Config()
        @Serializable
        data object Formats : Config()
        @Serializable
        data object Directory : Config()
    }
}

