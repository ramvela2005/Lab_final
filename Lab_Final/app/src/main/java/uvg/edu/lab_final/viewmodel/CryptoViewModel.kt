package uvg.edu.lab_final.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import uvg.edu.lab_final.data.model.Crypto
import uvg.edu.lab_final.data.model.FakeCrypto

class CryptoViewModel : ViewModel() {
    val cryptoList = mutableStateOf(FakeCrypto.cryptoList)

    fun getCryptoById(id: String): Crypto? {
        return cryptoList.value.find { it.id == id }
    }
}
