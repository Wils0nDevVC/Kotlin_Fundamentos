package Modulo2

// ==================================================================
// MÓDULO 2 - CLASE 1: CLASES Y OBJETOS
// ==================================================================
// La Programación Orientada a Objetos (POO) sirve para modelar la vida real.
// En lugar de variables sueltas, agrupamos datos y comportamientos.
// ==================================================================

fun main() {
    println("--- 1. CREANDO OBJETOS (INSTANCIAS) ---")

    // Usamos la clase 'Coche' (el plano) para crear un objeto real.
    // Fíjate que en Kotlin NO se usa la palabra 'new' (como en Java).
    val miAuto = Coche(marca = "Toyota", modelo = "Corolla", color = "Rojo")
    val tuAuto = Coche(marca = "Ford", modelo = "Fiesta", color = "Azul")

    println("Mi auto es un ${miAuto.marca} ${miAuto.modelo}")
    println("Tu auto es un ${tuAuto.marca} ${tuAuto.modelo}")


    println("\n--- 2. USANDO MÉTODOS (COMPORTAMIENTO) ---")
    // Los objetos no son solo datos, también HACEN cosas.
    miAuto.encender()
    miAuto.acelerar()
    miAuto.acelerar()

    tuAuto.encender() // Cada objeto tiene su propia vida independiente.


    println("\n--- 3. PROPIEDADES MUTABLES ---")
    // Podemos cambiar el color de mi auto porque lo definimos como 'var'
    println("Color antes: ${miAuto.color}")
    miAuto.color = "Negro Mate"
    println("Color después de pintar: ${miAuto.color}")

    // miAuto.marca = "Honda" // ❌ ERROR: La marca es 'val', no se puede cambiar.
}

// ==================================================================
// ZONA DE DEFINICIÓN DE CLASES (El Plano)
// ==================================================================

// Así se define una clase en Kotlin.
// El paréntesis después del nombre es el "Constructor Primario".
class Coche(
    val marca: String,   // Propiedad inmutable (No cambia)
    val modelo: String,  // Propiedad inmutable
    var color: String    // Propiedad mutable (Se puede pintar)
) {
    // Propiedades internas (Estado del coche)
    var velocidadActual: Int = 0
    var estaEncendido: Boolean = false

    // Bloque INIT: Se ejecuta automáticamente apenas se crea el objeto
    init {
        println("🏗️ Fabricando un nuevo $marca $modelo...")
    }

    // Métodos (Acciones que puede hacer el coche)
    fun encender() {
        estaEncendido = true
        println("🚘 $marca: Motor encendido. ¡Rum rum!")
    }

    fun acelerar() {
        if (estaEncendido) {
            velocidadActual += 10
            println("⏩ $marca: Acelerando... Velocidad: $velocidadActual km/h")
        } else {
            println("⚠️ $marca: No puedes acelerar, el motor está apagado.")
        }
    }
}