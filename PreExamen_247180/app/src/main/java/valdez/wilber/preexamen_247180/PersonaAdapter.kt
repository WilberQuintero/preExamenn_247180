package valdez.wilber.preexamen_247180

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonaAdapter(
    private val personas: List<Persona>,
    private val onItemClick: (Persona) -> Unit
) : RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder>() {

    inner class PersonaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvNumero: TextView = itemView.findViewById(R.id.tvNumero)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_persona, parent, false)
        return PersonaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        val persona = personas[position]
        holder.tvNombre.text = "${persona.nombre} ${persona.apellido}"
        holder.tvNumero.text = persona.numero

        holder.itemView.setOnClickListener {
            onItemClick(persona)
        }
    }

    override fun getItemCount(): Int = personas.size
}
