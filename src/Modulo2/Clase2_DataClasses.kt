package Modulo2

// ==================================================================
// MÓDULO 2 - CLASE 2: DATA CLASSES
// ==================================================================
// Las 'data class' son el corazón de las apps modernas.
// Nos regalan funcionalidad gratis para manejar información.
// ==================================================================

fun main() {
    println("--- 1. CLASE NORMAL VS DATA CLASS ---")

    val usuarioNormal = UsuarioNormal("Juan", 30)
    val usuarioData = UsuarioData("Juan", 30)

    // Fíjate en la diferencia al imprimir:
    println("Normal: $usuarioNormal") // Imprime basura (dirección de memoria: UsuarioNormal@54bedef2)
    println("Data:   $usuarioData")   // Imprime bonito: UsuarioData(nombre=Juan, edad=30)


    println("\n--- 2. COMPARACIÓN (EQUALS) ---")

    val usuarioData2 = UsuarioData("Juan", 30)

    // En una clase normal, esto daría FALSE porque son dos objetos distintos en memoria.
    // En una Data Class, da TRUE porque Kotlin compara el CONTENIDO.
    if (usuarioData == usuarioData2) {
        println("¡Son iguales! Tienen los mismos datos.")
    } else {
        println("Son diferentes.")
    }


    println("\n--- 3. EL MÉTODO COPY (Vital para Compose) ---")

    // Imaginemos que tenemos un Gasto en tu App.
    // Como usamos 'val', no podemos cambiar el monto directamente.
    val gastoOriginal = Gasto(
        descripcion = "Cena",
        monto = 50.0,
        esTarjeta = true
    )
    println("Gasto original: $gastoOriginal")

    // ERROR: gastoOriginal.monto = 60.0 (No se puede, es val)

    // SOLUCIÓN: Usamos .copy()
    // "Crea un clon exacto, PERO cambia el monto a 60.0"
    val gastoCorregido = gastoOriginal.copy(monto = 60.0)

    println("Gasto corregido: $gastoCorregido")
    // Fíjate que 'esTarjeta' y 'descripcion' se mantuvieron igual sin tener que escribirlos.


    println("\n--- 4. DESESTRUCTURACIÓN (Bonus) ---")
    // Podemos extraer los datos de una data class en variables sueltas
    val (queCompre, cuantoCosto) = gastoOriginal
    println("Compraste $queCompre y te costó $cuantoCosto")
}

// ---------------------------------------------------------
// DEFINICIÓN DE CLASES
// ---------------------------------------------------------

// Clase normal (aburrida, sin superpoderes)
class UsuarioNormal(val nombre: String, val edad: Int)

// DATA CLASS (La que usarás el 99% de las veces para modelos)
// Solo agregando la palabra 'data', ganas toString(), equals(), copy(), etc.
data class UsuarioData(val nombre: String, val edad: Int)

// Tu futuro modelo de datos para la App
data class Gasto(
    val descripcion: String,
    val monto: Double,
    val esTarjeta: Boolean
)