package uvg.edu.lab_final.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uvg.edu.lab_final.presentation.detail.CryptoDetailScreen
import uvg.edu.lab_final.presentation.list.CryptoListScreen
import uvg.edu.lab_final.presentation.viewmodel.CryptoViewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    val viewModel: CryptoViewModel = viewModel()

    NavHost(navController = navController, startDestination = "crypto_list") {
        composable("crypto_list") {
            CryptoListScreen(viewModel = viewModel) { cryptoId ->
                navController.navigate("crypto_detail/$cryptoId")
            }
        }
        composable("crypto_detail/{cryptoId}") { backStackEntry ->
            val cryptoId = backStackEntry.arguments?.getString("cryptoId") ?: ""
            CryptoDetailScreen(viewModel = viewModel, cryptoId = cryptoId, onBack = { navController.popBackStack() })
        }
    }
}
