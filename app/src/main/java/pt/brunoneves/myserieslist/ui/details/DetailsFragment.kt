package pt.brunoneves.myserieslist.ui.details


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pt.brunoneves.myserieslist.R
import pt.brunoneves.myserieslist.databinding.FragmentDetailsBinding
import pt.brunoneves.myserieslist.repository.ListSerieRepository
import pt.brunoneves.myserieslist.ui.search.SearchSeriesAdapter
import pt.brunoneves.myserieslist.ui.search.SearchViewModel

class DetailsFragment : Fragment() {
    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentDetailsBinding>(
            inflater,
            R.layout.fragment_details, container, false
        )

        // Get a reference to the ViewModel associated with this fragment.
        detailsViewModel = ViewModelProvider(this)
            .get(DetailsViewModel::class.java)

        setHasOptionsMenu(true)

        binding.lifecycleOwner = this

        CoroutineScope(Dispatchers.IO).launch {
            var id = arguments?.getInt("id", 0)
            var series = detailsViewModel.getSeriesDetails(id!!)
            var options = RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)

            requireActivity().runOnUiThread {
                binding.tvSerieTitle.text = series.name
                binding.tvDescription.text = series.overview
                binding.tvReleaseDate.text = series.first_air_date
                binding.tvVoteAverage.text = series.vote_average
                binding.tvNumberEpisodes.text = series.number_of_episodes
                binding.tvNumberSeasons.text = series.number_of_seasons
                Glide.with(detail_serie_poster)
                    .load("https://image.tmdb.org/t/p/w300" + series.poster_path)
                    .apply(options)
                    .into(detail_serie_poster)
                binding.detailSeriePoster.visibility = View.VISIBLE
                binding.tvSerieTitle.visibility = View.VISIBLE
                binding.tvDescription.visibility = View.VISIBLE
                binding.tvReleaseDate.visibility = View.VISIBLE
                binding.tvVoteAverage.visibility = View.VISIBLE
                binding.tvNumberEpisodes.visibility = View.VISIBLE
                binding.tvNumberSeasons.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE
                binding.NoResults.visibility = View.GONE

            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}
