package br.edu.fatecpg.resenha2app
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.util.Locale

@Composable
fun CalculadoraDescontoScreen() {
    var precoTexto by remember {
        mutableStateOf("")
    }
    var resultado by remember {
        mutableStateOf("Informe um preço e toque em calcular.")
    }
    var valorDesconto by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Calculadora de Desconto",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = precoTexto,
            onValueChange = { novoTexto ->
                precoTexto = novoTexto
            },
            label = { Text("Preço do produto") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value  = valorDesconto,
            onValueChange = { novoValor ->
                 valorDesconto = novoValor
            },
            label = { Text("Valor desconto produto")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val preco = precoTexto
                    .trim()
                    .replace(",", ".")
                    .toDoubleOrNull()
                val desconto = valorDesconto.trim()
                    .replace(",", ".")
                    .toDoubleOrNull()
                if (preco == null || preco < 0 || desconto == null) {
                    resultado = "Digite um preço válido."
                } else {
                    val precoFinal =
                        calcularPrecoComDesconto(preco, desconto)
                    resultado = String.format(
                        Locale("pt", "BR"),
                        "Preço final: R$ %.2f",
                        precoFinal
                    )
                }
            }
        ) {
            Text("CALCULAR")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = resultado,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}