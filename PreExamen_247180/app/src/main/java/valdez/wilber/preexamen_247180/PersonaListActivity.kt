package valdez.wilber.preexamen_247180

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PersonaListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PersonaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = PersonaAdapter(PersonaProvider.listaPersonas) { persona ->
            val intent = Intent(this, DetailPersonActivity::class.java)
            intent.putExtra("nombre", persona.nombre)
            intent.putExtra("apellido", persona.apellido)
            intent.putExtra("fecha", persona.fechaNacimiento)
            intent.putExtra("numero", persona.numero)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}
