package com.jssdvv.afi.core.presentation.navigation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.core.component.getScopeId

@OptIn(ExperimentalResourceApi::class)
@Composable
fun NavigationBar(
    navController: NavController
) {
    NavigationBar(
        modifier = Modifier,
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
    ) {
        val navigationItems = listOf(
            NavigationItems.ScannerItem,
            NavigationItems.FormatsItem,
            NavigationItems.DirectoryItem,
            NavigationItems.MapsItem
        )
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentGraphRoute = backStackEntry?.destination?.parent?.route
        navigationItems.forEach { navigationItem ->
            NavigationBarItem(
                selected = currentGraphRoute == navigationItem.route,
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
                        painter = painterResource(
                            if (currentGraphRoute == navigationItem.route) navigationItem.activeIcon else navigationItem.inactiveIcon
                        )
                    )
                },
                modifier = Modifier,
                label = { Text(stringResource(navigationItem.title)) }
            )
        }
    }
}