package com.jssdvv.afi.core.presentation.navigation

import com.jssdvv.afi.composeapp.generated.resources.Res
import com.jssdvv.afi.composeapp.generated.resources.consultation_filled
import com.jssdvv.afi.composeapp.generated.resources.consultation_outlined
import com.jssdvv.afi.composeapp.generated.resources.directory_filled
import com.jssdvv.afi.composeapp.generated.resources.directory_outlined
import com.jssdvv.afi.composeapp.generated.resources.formats_filled
import com.jssdvv.afi.composeapp.generated.resources.formats_outlined
import com.jssdvv.afi.composeapp.generated.resources.reporting_filled
import com.jssdvv.afi.composeapp.generated.resources.reporting_outlined
import com.jssdvv.afi.composeapp.generated.resources.request_filled
import com.jssdvv.afi.composeapp.generated.resources.request_outlined
import com.jssdvv.afi.composeapp.generated.resources.scanner_filled
import com.jssdvv.afi.composeapp.generated.resources.scanner_outlined
import com.jssdvv.afi.composeapp.generated.resources.scanner_tab_title
import com.jssdvv.afi.composeapp.generated.resources.search_filled
import com.jssdvv.afi.composeapp.generated.resources.search_outlined
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import kotlin.reflect.KClass

sealed class AppNavRoutes {

    @Serializable
    data object AuthNavGraph {

        @Serializable
        data object SplashDestination

        @Serializable
        data object LoginDestination

        @Serializable
        data object RecoveryDestination
    }

    @Serializable
    data object AppWithScaffoldNavHost {

        @Serializable
        data object SearchNavGraph {

            @Serializable
            data object ScannerDestination {

                @Serializable
                data class DetailSubDestination(val id: Long)

                @Serializable
                data object HistorySubDestination
            }

            @Serializable
            data object DirectoryDestination
        }

        @Serializable
        data object FormatNavGraph {

            @Serializable
            data object RequestDestination

            @Serializable
            data object ReportingDestination

            @Serializable
            data object ConsultationDestination
        }
    }
}

sealed class AppNavItems{

    enum class NavGraphItems (
        val selectedIcon: DrawableResource,
        val unselectedIcon: DrawableResource,
        val iconDescription: StringResource,
        val title: StringResource,
        val route: Any,
        val destinationsItems: List<DestinationItem>
    ) {
        SEARCH(
            selectedIcon = Res.drawable.search_outlined,
            unselectedIcon = Res.drawable.search_filled,
            iconDescription = Res.string.scanner_tab_title,
            title = Res.string.scanner_tab_title,
            route = AppNavRoutes.AppWithScaffoldNavHost.SearchNavGraph,//::class
            destinationsItems = listOf(
                DestinationItem(
                    selectedIcon = Res.drawable.scanner_filled,
                    unselectedIcon = Res.drawable.scanner_outlined,
                    iconDescription = Res.string.scanner_tab_title,
                    title = Res.string.scanner_tab_title,
                    route = AppNavRoutes.AppWithScaffoldNavHost.SearchNavGraph.ScannerDestination
                ),
                DestinationItem(
                    selectedIcon = Res.drawable.directory_filled,
                    unselectedIcon = Res.drawable.directory_outlined,
                    iconDescription = Res.string.scanner_tab_title,
                    title = Res.string.scanner_tab_title,
                    route = AppNavRoutes.AppWithScaffoldNavHost.SearchNavGraph.DirectoryDestination
                )
            )
        ),
        FORMAT(
            selectedIcon = Res.drawable.formats_filled,
            unselectedIcon = Res.drawable.formats_outlined,
            iconDescription = Res.string.scanner_tab_title,
            title = Res.string.scanner_tab_title,
            route = AppNavRoutes.AppWithScaffoldNavHost.FormatNavGraph,
            destinationsItems = listOf(
                DestinationItem(
                    selectedIcon = Res.drawable.request_filled,
                    unselectedIcon = Res.drawable.request_outlined,
                    iconDescription = Res.string.scanner_tab_title,
                    title = Res.string.scanner_tab_title,
                    route = AppNavRoutes.AppWithScaffoldNavHost.FormatNavGraph.RequestDestination
                ),
                DestinationItem(
                    selectedIcon = Res.drawable.reporting_filled,
                    unselectedIcon = Res.drawable.reporting_outlined,
                    iconDescription = Res.string.scanner_tab_title,
                    title = Res.string.scanner_tab_title,
                    route = AppNavRoutes.AppWithScaffoldNavHost.FormatNavGraph.ReportingDestination
                ),
                DestinationItem(
                    selectedIcon = Res.drawable.consultation_filled,
                    unselectedIcon = Res.drawable.consultation_outlined,
                    iconDescription = Res.string.scanner_tab_title,
                    title = Res.string.scanner_tab_title,
                    route = AppNavRoutes.AppWithScaffoldNavHost.FormatNavGraph.ConsultationDestination
                )
            )
        )
    }

    data class DestinationItem(
        val selectedIcon: DrawableResource,
        val unselectedIcon: DrawableResource,
        val iconDescription: StringResource,
        val title: StringResource,
        val route: Any,
    )
}
