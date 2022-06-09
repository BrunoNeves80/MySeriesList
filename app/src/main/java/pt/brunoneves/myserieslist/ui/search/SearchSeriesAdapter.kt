package pt.brunoneves.myserieslist.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import pt.brunoneves.myserieslist.R
import pt.brunoneves.myserieslist.data.model.Series

class SearchSeriesAdapter: RecyclerView.Adapter<SearchSeriesAdapter.SearchSerieViewHolder>() {
    var data = listOf<Series>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var options = RequestOptions()
        .centerCrop()
        .placeholder(R.mipmap.ic_launcher_round)
        .error(R.mipmap.ic_launcher_round)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchSerieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_serie, parent, false)

        return SearchSerieViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchSerieViewHolder, position: Int) {
        val item = data[position]
        holder.serieList.text = item.name
        Glide.with(holder.image)
            .load("https://image.tmdb.org/t/p/w300" + item.poster_path )
            .apply(options)
            .into(holder.image)
    }

    override fun getItemCount(): Int = data.size

    class SearchSerieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val serieList: TextView = itemView.findViewById(R.id.serie_title)
        val image: ImageView = itemView.findViewById(R.id.serie_poster)
    }
}
