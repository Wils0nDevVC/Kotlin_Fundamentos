package Modulo1// ==================================================================
// MÓDULO 1 - CLASE 2: CONTROL DE FLUJO
// ==================================================================
// Aquí aprenderemos a tomar decisiones y repetir tareas.
// ==================================================================

fun main() {
    println("--- 1. IF - ELSE (Como Expresion)")

    val saldo = 10.0
    val precioProducto = 25.0

    // En Java/C++, el if es solo una instrucción.
    // En Kotlin, el if puede DEVOLVER un valor (como una variable).

    val mensajeCompra = if (saldo >= precioProducto) {
        // Hacemos lógica
        "Compra exitosa! Te quedan: ${saldo - precioProducto}"
    }else{
        // Hacemos lógica
        "Fondos insuficientes. Te faltan: ${precioProducto - saldo}"
    }

    println(mensajeCompra)

    println("\n--- 2. WHEN (Es el 'Switch' con esteroides) ---")

    // El 'when' es más limpio que usar muchos 'if-else'.
    val tipoGasto = "Comida"

    when (tipoGasto) {
        "Comida" -> println("Categoría: Alimentación (Esencial)")
        "Cine", "Juegos" -> println("Categoría: Entretenimiento (Ocio)")
        "Luz", "Agua" -> println("Categoría: Servicios Básicos")
        else -> println("Categoría no reconocida")
    }

    // También puede devolver valor, igual que el if
    val descuento = when (tipoGasto) {
        "Comida" -> 0.10 // 10% descuento
        else -> 0.0
    }
    println("Descuento aplicado: ${descuento * 100}%")


    println("\n--- 3. BUCLES FOR Y RANGOS ---")

    // Rango simple (incluye el último número)
    println("Contando del 1 al 5:")
    for (i in 1..5) {
        print("$i ") // Imprime: 1 2 3 4 5
    }
    println()

    // Rango 'until' (NO incluye el último número)
    println("Contando con until (útil para arrays):")
    for (i in 0 until 5) {
        print("$i ") // Imprime: 0 1 2 3 4
    }
    println()

    // Pasos (Saltando números)
    println("De 2 en 2:")
    for (i in 0..10 step 2) {
        print("$i ") // Imprime: 0 2 4 6 8 10
    }
    println()

    // Cuenta regresiva
    println("Despegue en:")
    for (i in 5 downTo 1) {
        print("$i... ")
    }
    println("🚀")
}