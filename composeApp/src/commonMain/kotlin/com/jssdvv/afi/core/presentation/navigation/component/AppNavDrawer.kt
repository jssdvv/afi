package com.jssdvv.afi.core.presentation.navigation.component

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.jssdvv.afi.core.presentation.navigation.AppNavItems
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun AppNavDrawer(
    navController: NavController,
) {

    NavigationRail(
        modifier = Modifier,
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
    ) {
        val navigationRailItems = listOf(
            AppNavItems.NavGraphItems.SEARCH,
            AppNavItems.NavGraphItems.FORMAT
        )
        navigationRailItems.forEach { navigationItem ->
            NavigationRailItem(
                selected = true,// TODO: Fix,
                onClick = {
                    navController.navigate(navigationItem.route) {
                        navController.graph.findStartDestination().route?.let {
                            popUpTo(it) {
                                inclusive = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        contentDescription = stringResource(navigationItem.title),
                        painter = painterResource(navigationItem.selectedIcon)
                    )
                },
                modifier = Modifier,
                label = { Text(stringResource(navigationItem.title)) }
            )
        }
    }
}
