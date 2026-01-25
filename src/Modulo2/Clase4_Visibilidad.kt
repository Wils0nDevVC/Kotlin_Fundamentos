package Modulo2

// ==================================================================
// MÓDULO 2 - CLASE 4: VISIBILIDAD (Encapsulamiento)
// ==================================================================
// Objetivo: Proteger nuestros datos para que nadie los rompa por error.
// ==================================================================

fun main() {
    println("--- 1. PROBANDO CUENTA BANCARIA ---")

    val miCuenta = CuentaBancaria("Juan Perez")

    // Intento de hackeo (Si descomentas la línea de abajo, dará error rojo)
    // miCuenta.saldo = 1000000.0 // ❌ ERROR: 'saldo' es private. No puedes tocarlo.

    // Forma correcta de interactuar: Usando las funciones públicas
    miCuenta.depositar(100.0)
    miCuenta.depositar(-50.0) // El sistema rechaza esto gracias a la validación interna

    miCuenta.retirar(30.0)

    // Podemos LEER el saldo porque creamos una función para ello,
    // pero no podemos escribirlo directamente.
    println("Saldo final consultado: ${miCuenta.obtenerSaldoActual()}")


    println("\n--- 2. PROBANDO CAJA FUERTE (SETTER PRIVADO) ---")
    val caja = CajaFuerte()

    // caja.codigoSecreto = "1234" // ❌ ERROR: El setter es privado.
    println("Código actual: ${caja.codigoSecreto}") // ✅ LEER sí está permitido.

    caja.cambiarCodigo("0000", "9999") // Hay que saber el anterior para cambiarlo
}

// ==================================================================
// ZONA DE CLASES
// ==================================================================

class CuentaBancaria(val titular: String) {

    // 1. PROPIEDAD PRIVADA
    // Nadie fuera de esta clase puede ver ni modificar esta variable.
    private var saldo: Double = 0.0

    // 2. FUNCIONES PÚBLICAS (La interfaz para el mundo exterior)

    fun depositar(monto: Double) {
        if (monto > 0) {
            saldo += monto
            println("✅ Depósito exitoso. Nuevo saldo: $saldo")
        } else {
            println("❌ Error: No puedes depositar montos negativos.")
        }
    }

    fun retirar(monto: Double) {
        if (monto <= saldo) {
            saldo -= monto
            println("✅ Retiro exitoso. Queda: $saldo")
        } else {
            println("❌ Error: Fondos insuficientes.")
        }
    }

    // Función solo para leer (Getter manual)
    fun obtenerSaldoActual(): Double {
        return saldo
    }

    // Función privada (Auxiliar): Solo la usa la propia clase internamente
    private fun registrarEnLog() {
        println("Log interno: Movimiento registrado.")
    }
}

class CajaFuerte {
    // TRUCO PRO:
    // 'var' pública para leer, pero 'set' privado para escribir.
    // Esto significa: "Todo el mundo puede ver el código, pero nadie puede cambiarlo directamente".
    var codigoSecreto: String = "0000"
        private set

    fun cambiarCodigo(anterior: String, nuevo: String) {
        if (anterior == codigoSecreto) {
            codigoSecreto = nuevo
            println("✅ Código cambiado correctamente.")
        } else {
            println("❌ Código anterior incorrecto. Acceso denegado.")
        }
    }
}