package valdez.wilber.preexamen_247180

import java.io.Serializable

data class Persona(
    val nombre: String,
    val apellido: String,
    val fechaNacimiento: String,
    val numero: String
) : Serializable