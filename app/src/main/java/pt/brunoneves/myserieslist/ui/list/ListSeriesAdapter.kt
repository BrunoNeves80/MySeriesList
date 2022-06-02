package pt.brunoneves.myserieslist.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pt.brunoneves.myserieslist.R
import pt.brunoneves.myserieslist.data.model.Series

class ListSeriesAdapter: RecyclerView.Adapter<ListSeriesAdapter.ListSerieViewHolder>() {
    var data = listOf<Series>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSerieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_serie, parent, false)

        return ListSerieViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListSerieViewHolder, position: Int) {
        val item = data[position]
        holder.serieList.text = item.name
    }

    override fun getItemCount(): Int = data.size

    class ListSerieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val serieList: TextView = itemView.findViewById(R.id.serie_title)
    }
}