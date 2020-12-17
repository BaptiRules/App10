package android.example.app4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class Adapter(
    private val List: List<Item>,
    private val listener: OnLongClickListener
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount() = List.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnLongClickListener{
        val textViewDe: TextView = itemView.text_view_de
        val textViewEn: TextView = itemView.text_view_en

        init {
            itemView.setOnLongClickListener(this)
        }

            override fun onLongClick(v: View?): Boolean {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onLongClick(position)
                }
                return true
            }
        }

    interface OnLongClickListener  {
        fun onLongClick(position: Int)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = List[position]
        holder.textViewDe.text = currentItem.Deutsch
        holder.textViewEn.text = currentItem.Englisch
    }

}