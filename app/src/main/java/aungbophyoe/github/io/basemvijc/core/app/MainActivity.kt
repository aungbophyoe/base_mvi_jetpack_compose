package aungbophyoe.github.io.basemvijc.core.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import aungbophyoe.github.io.basemvijc.core.navigation.LocalNavigationManager
import aungbophyoe.github.io.basemvijc.core.navigation.NavigationProvider
import aungbophyoe.github.io.basemvijc.core.navigation.graphs.AppNavGraph
import aungbophyoe.github.io.basemvijc.core.resource.theme.BaseMVIJCTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            CompositionLocalProvider(
                LocalNavigationManager provides NavigationProvider(navController)
            ) {
                BaseMVIJCTheme {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        AppNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}