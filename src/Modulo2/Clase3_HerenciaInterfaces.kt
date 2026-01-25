package Modulo2

// ==================================================================
// MÓDULO 2 - CLASE 3: HERENCIA E INTERFACES
// ==================================================================
// Objetivo: Aprender a reutilizar código y definir reglas estrictas.
// ==================================================================

fun main() {
    println("--- 1. HERENCIA (El Padre y los Hijos) ---")

    // Podemos tratar a todos como 'MetodoPago', aunque sean diferentes.
    val pago1 = PagoEfectivo(moneda = "Soles")
    val pago2 = PagoTarjeta(numero = "4557-xxxx", tipo = "Visa")

    pago1.procesarPago(50.0)
    pago2.procesarPago(120.0)


    println("\n--- 2. INTERFACES (El Contrato) ---")

    // Creamos un Gasto que, además de ser dato, es 'Exportable'.
    val gastoLuz = GastoServicio("Recibo de Luz", 100.0)

    // Como GastoServicio implementa la interfaz, podemos llamar a su función.
    gastoLuz.generarPDF()

    println("\n--- 3. POLIMORFISMO (La magia de POO) ---")
    // Podemos crear una lista de cosas 'Exportables' y recorrerlas sin saber qué son exactamente.
    val listaDocumentos: List<Exportable> = listOf(gastoLuz, ReporteMensual())

    for (doc in listaDocumentos) {
        doc.generarPDF() // Funciona para todos, aunque sean clases distintas.
    }
}

// ==================================================================
// ZONA DE HERENCIA (Padres e Hijos)
// ==================================================================

// CLASE PADRE (Necesita 'open' para poder ser heredada)
// Define lo que todos los pagos tienen en común.
open class MetodoPago(val nombre: String) {
    // 'open' aquí significa que los hijos pueden cambiar (sobreescribir) esta función.
    open fun procesarPago(monto: Double) {
        println("Procesando pago genérico de S/ $monto con $nombre")
    }
}

// CLASE HIJA 1: Hereda de MetodoPago
class PagoEfectivo(val moneda: String) : MetodoPago("Efectivo") {
    // Sobreescribimos la función del padre para hacer algo específico
    override fun procesarPago(monto: Double) {
        println("Recibiendo billetes ($moneda) por valor de S/ $monto. ¡Gracias!")
    }
}

// CLASE HIJA 2: Hereda de MetodoPago
class PagoTarjeta(val numero: String, val tipo: String) : MetodoPago("Tarjeta") {
    override fun procesarPago(monto: Double) {
        println("Conectando con banco... Cobrando S/ $monto a la $tipo terminada en ${numero.takeLast(4)}")
    }
}

// ==================================================================
// ZONA DE INTERFACES (Contratos)
// ==================================================================

// INTERFAZ: Define QUÉ se debe hacer, pero no CÓMO.
// Cualquier clase que use esta interfaz ESTÁ OBLIGADA a tener la función generarPDF.
interface Exportable {
    fun generarPDF()
}

// Una clase que cumple el contrato
class GastoServicio(val nombre: String, val monto: Double) : Exportable {
    override fun generarPDF() {
        println("📄 Generando PDF del recibo: $nombre (Monto: $monto)")
    }
}

// Otra clase totalmente distinta que también cumple el contrato
class ReporteMensual : Exportable {
    override fun generarPDF() {
        println("📊 Generando Gráfico de torta del mes...")
    }
}