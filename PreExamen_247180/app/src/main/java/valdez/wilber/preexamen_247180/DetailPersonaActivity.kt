package valdez.wilber.preexamen_247180

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailPersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_person)

        val nombre = intent.getStringExtra("nombre")
        val apellido = intent.getStringExtra("apellido")
        val fecha = intent.getStringExtra("fecha")
        val numero = intent.getStringExtra("numero")

        val tvDetalle = findViewById<TextView>(R.id.tvDetalle)
        tvDetalle.text = "Nombre: $nombre $apellido\nFecha Nacimiento: $fecha\nNúmero: $numero"
    }
}
