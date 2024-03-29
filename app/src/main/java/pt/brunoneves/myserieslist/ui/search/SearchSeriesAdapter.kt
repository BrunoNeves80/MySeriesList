package pt.brunoneves.myserieslist.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import pt.brunoneves.myserieslist.R
import pt.brunoneves.myserieslist.data.model.Series
import pt.brunoneves.myserieslist.network.SeriesResponse
import pt.brunoneves.myserieslist.ui.details.DetailsViewModel

class SearchSeriesAdapter: RecyclerView.Adapter<SearchSeriesAdapter.SearchSerieViewHolder>() {
    var series = listOf<Series>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchSerieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_serie, parent, false)

        return SearchSerieViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchSerieViewHolder, position: Int) {
        val item = series[position]

        var options = RequestOptions()
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher_round)
            .error(R.mipmap.ic_launcher_round)

        holder.title.text = item.name
        Glide.with(holder.image)
            .load("https://image.tmdb.org/t/p/w300" + item.poster_path )
            .apply(options)
            .into(holder.image)

        holder.image.setOnClickListener { view: View ->
            val bundle = bundleOf("id" to item.id )
            view.findNavController().navigate(R.id.action_searchFragment_to_detailsFragment, bundle)
        }
    }

    override fun getItemCount(): Int = series.size

    class SearchSerieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.serie_title)
        val image: ImageView = itemView.findViewById(R.id.serie_poster)
    }
}
