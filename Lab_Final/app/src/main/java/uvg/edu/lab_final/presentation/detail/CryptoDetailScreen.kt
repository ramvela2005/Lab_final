package uvg.edu.lab_final.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uvg.edu.lab_final.presentation.viewmodel.CryptoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoDetailScreen(viewModel: CryptoViewModel, cryptoId: String, onBack: () -> Unit) {
    val crypto = viewModel.getCryptoById(cryptoId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Crypto Detail") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            if (crypto == null) {
                CircularProgressIndicator()
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Name: ${crypto.name}", style = MaterialTheme.typography.bodyLarge)
                    Text(text = "Symbol: ${crypto.symbol}", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Price: \$${crypto.price}", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}
