package valdez.wilber.preexamen_247180

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etApellido: EditText
    private lateinit var etFecha: EditText
    private lateinit var etNumero: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnVerLista: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        etNombre = findViewById(R.id.etNombre)
        etApellido = findViewById(R.id.etApellido)
        etFecha = findViewById(R.id.etFecha)
        etNumero = findViewById(R.id.etNumero)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnVerLista = findViewById(R.id.btnVerLista)

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val fecha = etFecha.text.toString()
            val numero = etNumero.text.toString()

            if (nombre.isNotEmpty() && apellido.isNotEmpty() && fecha.isNotEmpty() && numero.isNotEmpty()) {
                val persona = Persona(nombre, apellido, fecha, numero)
                PersonaProvider.listaPersonas.add(persona)

                etNombre.text.clear()
                etApellido.text.clear()
                etFecha.text.clear()
                etNumero.text.clear()
            }
        }

        btnVerLista.setOnClickListener {
            val intent = Intent(this, PersonaListActivity::class.java)
            startActivity(intent)
        }
    }
}

