package br.edu.fatecpg.resenha2app

fun calcularPrecoComDesconto(
    preco:Double,
    percentual:Double
):Double {
    val desconto = preco*percentual /100;
    return preco-desconto;
}