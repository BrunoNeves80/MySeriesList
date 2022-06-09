package pt.brunoneves.myserieslist.ui.search

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.brunoneves.myserieslist.R
import pt.brunoneves.myserieslist.databinding.FragmentSearchBinding

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {
    private val viewModel: SearchViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(this, SearchViewModel.Factory(activity.application))
            .get(SearchViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSearchBinding>(
            inflater,
            R.layout.fragment_search, container, false
        )

        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        // Get a reference to the ViewModel associated with this fragment.
        val searchViewModel = ViewModelProvider(this,)
            .get(SearchViewModel::class.java)

        val adapter = SearchSeriesAdapter()
        CoroutineScope(Dispatchers.IO).launch {
            val series = searchViewModel.getPopularSeries()

            requireActivity().runOnUiThread {
                adapter.data = series
                if (adapter.data.isEmpty()) {
                    binding.recyclerViewSerie.visibility = View.GONE
                    binding.NoResults.visibility = View.VISIBLE
                } else {
                    binding.recyclerViewSerie.visibility = View.VISIBLE
                    binding.NoResults.visibility = View.GONE
                }
            }
        }

        binding.recyclerViewSerie.adapter = adapter

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
