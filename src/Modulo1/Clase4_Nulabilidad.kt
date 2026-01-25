package Modulo1// ==================================================================
// MÓDULO 1 - CLASE 4: NULABILIDAD (Null Safety)
// ==================================================================
// Kotlin está diseñado para que NUNCA tengas un error de "NullPointerException"
// por accidente. Aquí aprenderás a manejar la ausencia de datos.
// ==================================================================

fun main() {
    println("--- 1. TIPOS NULLABLE VS NON-NULLABLE ---")

    // Por defecto, las variables en Kotlin NO aceptan null.
    var nombreObligatorio: String = "Kotlin"
    // nombreObligatorio = null // ❌ ESTO DA ERROR, ni siquiera compila.
    println("Nombre obligatorio: $nombreObligatorio")

    // Si queremos permitir nulos, debemos agregar el signo '?'
    var nombreOpcional: String? = "Android"
    println("Nombre opcional antes: $nombreOpcional")

    nombreOpcional = null // ✅ AHORA SÍ ES VÁLIDO
    println("Nombre opcional ahora: $nombreOpcional")


    println("\n--- 2. SAFE CALL (?.) ---")
    // ¿Qué pasa si quiero saber la longitud de un texto que puede ser nulo?

    var texto: String? = null

    // println(texto.length) // ❌ ERROR: Kotlin te dice "¡Oye, esto puede ser null!"

    // SOLUCIÓN: Usamos ?. (Llamada segura)
    // Significa: "Si texto NO es null, dame el length. Si ES null, dame null".
    println("Longitud segura: ${texto?.length}")


    println("\n--- 3. ELVIS OPERATOR (?:) ---")
    // El operador Elvis se parece al peinado de Elvis Presley (?:)
    // Sirve para dar un valor por defecto si algo es null.

    var emailUsuario: String? = null

    // Lógica antigua (Java style)
    val emailFinal1 = if (emailUsuario != null) emailUsuario else "no-reply@app.com"

    // Lógica Kotlin (Elvis style)
    // "Usa el email, y si es nulo, USA ESTE OTRO"
    val emailFinal2 = emailUsuario ?: "no-reply@app.com"

    println("Email a usar: $emailFinal2")


    println("\n--- 4. EJEMPLO REAL: BASE DE DATOS ---")
    // Imaginemos que buscamos un usuario en la BD
    val usuarioEncontrado = buscarUsuario(id = 99) // Devuelve null si no existe

    // Combinamos ?. y ?: para una lógica super limpia:
    // "Intenta obtener el nombre. Si el usuario es null O el nombre es null, imprime 'Desconocido'"
    val nombreMostrar = usuarioEncontrado?.nombre ?: "Desconocido"

    println("Modulo1.Usuario: $nombreMostrar")
}

// Clase simple para el ejemplo (ya veremos clases en detalle en el Módulo 2)
data class Usuario(val nombre: String)

// Función simulada que devuelve un usuario o null
fun buscarUsuario(id: Int): Usuario? {
    if (id == 1) return Usuario("Admin")
    return null // Simulamos que no encontró al usuario 99
}