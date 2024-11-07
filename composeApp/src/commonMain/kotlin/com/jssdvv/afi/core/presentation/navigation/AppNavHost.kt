package com.jssdvv.afi.core.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jssdvv.afi.core.presentation.navigation.graph.authNavGraph
import com.jssdvv.afi.core.presentation.navigation.graph.formatNavGraph
import com.jssdvv.afi.core.presentation.navigation.graph.searchNavGraph
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun AppNavHost(
    appNavHostController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = appNavHostController,
        startDestination = AppNavRoutes.AppWithScaffoldNavHost,
        modifier = modifier
    ) {
        authNavGraph()
        composable<AppNavRoutes.AppWithScaffoldNavHost> {
            AppWithScaffoldNavHost(
                appNavHostController,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppWithScaffoldNavHost(
    appNavHostController: NavHostController,
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    modifier: Modifier = Modifier,
) {
    val navGraphItems = listOf(
        AppNavItems.NavGraphItems.SEARCH,
        AppNavItems.NavGraphItems.FORMAT
    )
    val scope = rememberCoroutineScope()
    var selectedNavGraphItem by rememberSaveable { mutableStateOf(navGraphItems.first()) }
    var selectedNavGraphItemIndex by rememberSaveable { mutableStateOf(0) }
    var selectedDestinationItem by rememberSaveable { mutableStateOf(0) }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.requiredWidth(250.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        navGraphItems.forEachIndexed { index, navGraphItem ->
                            FloatingActionButton(
                                onClick = {
                                    selectedNavGraphItemIndex = index
                                    selectedNavGraphItem = navGraphItem
                                    selectedDestinationItem = 0
                                },
                                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                            ) {
                                Icon(
                                    painter = painterResource(
                                        if (index == selectedNavGraphItemIndex)
                                            navGraphItem.selectedIcon else navGraphItem.unselectedIcon
                                    ),
                                    contentDescription = stringResource(navGraphItem.iconDescription)
                                )
                            }
                        }
                    }
                    Column {
                        selectedNavGraphItem.destinationsItems.forEachIndexed { index, destinationItem ->
                            NavigationDrawerItem(
                                selected = selectedDestinationItem == index,
                                icon = {
                                    Icon(
                                        painter = painterResource(
                                            if (selectedDestinationItem == index)
                                                destinationItem.selectedIcon else destinationItem.unselectedIcon

                                        ),
                                        contentDescription = stringResource(destinationItem.iconDescription)
                                    )
                                },
                                label = { Text(stringResource(destinationItem.title)) },
                                onClick = {
                                    selectedDestinationItem = index
                                    scope.launch { drawerState.close() }
                                }
                            )
                        }
                    }
                }
            }
        },
        modifier = modifier,
        drawerState = drawerState,
        gesturesEnabled = true,
        scrimColor = DrawerDefaults.scrimColor
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(Icons.Default.Menu, null)
                        }
                    },
                    title = { Text("Fixed Assets & Inventories") },
                )
            },
            modifier = Modifier,
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = AppNavRoutes.AppWithScaffoldNavHost.FormatNavGraph,
                modifier = modifier.padding(paddingValues)
            ) {
                searchNavGraph()
                formatNavGraph()
            }
        }
    }
}