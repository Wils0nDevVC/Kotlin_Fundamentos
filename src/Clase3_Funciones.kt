// ==================================================================
// MÓDULO 1 - CLASE 3: FUNCIONES
// ==================================================================
// Las funciones son "mini-programas" reutilizables.
// En Compose, TODO es una función. ¡Aprende esto bien!
// ==================================================================

fun main() {
    println("--- 1. FUNCIÓN BÁSICA ---")
    saludar("Gemini") // Llamamos a la función

    val suma = sumar(10, 5)
    println("La suma es: $suma")

    println("\n--- 2. FUNCIONES DE UNA LÍNEA (Single Expression) ---")
    // Si la función es simple, podemos quitar las llaves {} y el return.
    // Ver función 'restar' abajo.
    println("La resta de 20 - 5 es: ${restar(20, 5)}")


    println("\n--- 3. ARGUMENTOS NOMBRADOS (Named Arguments) ---")
    // Esto es CLAVE. Podemos decir explícitamente qué parámetro es cuál.
    // Ayuda mucho cuando tienes funciones con muchos datos (como un Formulario).

    registrarGasto(
        descripcion = "Almuerzo",
        monto = 12.50,
        esTarjeta = true
    )
    // Lo genial es que podemos cambiar el orden y no pasa nada:
    registrarGasto(
        descripcion = "Taxi",
        esTarjeta = false,
        monto = 15.0
    )


    println("\n--- 4. VALORES POR DEFECTO (Default Arguments) ---")
    // Podemos hacer que algunos parámetros sean OPCIONALES.
    // Ver función 'crearAlerta' abajo.

    crearAlerta(mensaje = "Batería baja") // Usa el color por defecto (Rojo)
    crearAlerta(mensaje = "Carga completa", color = "Verde") // Sobrescribe el color
}


// ---------------------------------------------------------
// ZONA DE DEFINICIÓN DE FUNCIONES
// ---------------------------------------------------------

// 1. Función normal: Recibe String, no devuelve nada (Unit)
fun saludar(nombre: String) {
    println("Hola, $nombre, bienvenido al curso.")
}

// 2. Función con retorno: Recibe Ints, devuelve un Int
fun sumar(a: Int, b: Int): Int {
    return a + b
}
// 3. Función simplificada (Single Expression)
// Fíjate que no tiene llaves {} ni 'return'. Se usa el '='.
fun restar(a: Int, b: Int) = a - b // Función de una sola línea

// 4. Función con muchos parámetros (para probar argumentos nombrados)
fun registrarGasto(descripcion: String, monto: Double, esTarjeta: Boolean) {
    val metodoPago = if (esTarjeta) "tarjeta" else "efectivo"
    println("Gasto registrado: $descripcion - Monto: $$monto - Método de pago: $metodoPago")
}

// 5. Función con valores por defecto
// Si no le pasas 'color', usará "Rojo" automáticamente.
fun crearAlerta(mensaje: String, color: String = "Rojo") {
    println("[Alerta: $color]: $mensaje")
}