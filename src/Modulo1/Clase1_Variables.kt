package Modulo1

// ==================================================================
// MÓDULO 1 - CLASE 1: VARIABLES Y TIPOS
// ==================================================================
// Para ejecutar esto: Busca el pequeño triángulo verde (▶)
// que aparecerá al lado de "fun Modulo1.Modulo1.Modulo1.Modulo1.main()" y dale clic.
// ==================================================================
fun main() {
    // 1. ¿CÓMO SÉ MI VERSIÓN DE KOTLIN?
    // --------------------------------------------------------------
    println("Hola, estás corriendo Kotlin versión: ${KotlinVersion.CURRENT}")
    println("--- INICIO DE LA CLASE ---")

    // 2. LA REGLA DE ORO: VAL vs VAR
    // --------------------------------------------------------------

    // VAL (Value): Es Inmutable. Una vez nace, muere con ese valor.(son como las constantes)
    // Úsala para el 90% de tus datos (Cédula, Fecha Nacimiento, URL de API).
    val nombreApp = "GastosApp"
    // nombreApp = "OtraCosa" // ❌ ERROR: No puedes cambiar una val.

    // VAR (Variable): Es Mutable. Puede cambiar.
    // Úsala para contadores, saldo actual, ubicación GPS en movimiento.
    var saldoBilletera = 50.0
    println("Saldo inicial: $saldoBilletera")

    saldoBilletera = 20.5 // ✅ CORRECTO: Una var sí puede cambiar.
    println("Saldo después de gastar: $saldoBilletera")


    // 3. TIPOS DE DATOS (Los ingredientes)
    // --------------------------------------------------------------
    // Kotlin es inteligente (Inferencia de tipos), pero es bueno conocerlos.

    val texto: String = "Soy un texto"
    val entero: Int = 100               // Números sin decimales
    val decimal: Double = 99.99         // Números con decimales (El estándar para dinero)
    val esVerdad: Boolean = true        // true o false

    // 4. STRING TEMPLATES (La forma moderna de escribir)
    // --------------------------------------------------------------
    // Olvídate de: "Hola " + nombre + " tu saldo es " + saldo
    // Usa el signo $ para inyectar variables:

    println("Bienvenido a $nombreApp. Tu saldo actual es: S/ $saldoBilletera")

    // También puedes hacer operaciones dentro de las llaves ${ }
    println("Si gastas 5 soles, te quedarán: S/ ${saldoBilletera - 5}")
}