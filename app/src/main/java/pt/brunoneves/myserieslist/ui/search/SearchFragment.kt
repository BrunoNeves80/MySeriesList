package pt.brunoneves.myserieslist.ui.search

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
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
    private lateinit var adapter: SearchSeriesAdapter
    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchViewModel: SearchViewModel
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
        binding = DataBindingUtil.inflate<FragmentSearchBinding>(
            inflater,
            R.layout.fragment_search, container, false
        )

        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        // Get a reference to the ViewModel associated with this fragment.
        searchViewModel = ViewModelProvider(this)
            .get(SearchViewModel::class.java)

        adapter = SearchSeriesAdapter()
        CoroutineScope(Dispatchers.IO).launch {
            var series = searchViewModel.getPopularSeries()
            series = series.sortedBy {
                it.name
            }

            requireActivity().runOnUiThread {
                adapter.data = series
                if (adapter.data.isEmpty()) {
                    binding.recyclerViewSerie.visibility = View.GONE
                    binding.NoResults.visibility = View.VISIBLE
                } else {
                    binding.recyclerViewSerie.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
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

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.queryHint = "Search"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(name: String?): Boolean {
                CoroutineScope(Dispatchers.IO).launch {
                    val series = searchViewModel.getSeriesByName(name)

                    requireActivity().runOnUiThread {
                        adapter.data = series
                        if (adapter.data.isEmpty()) {
                            binding.recyclerViewSerie.visibility = View.GONE
                            binding.NoResults.visibility = View.VISIBLE
                        } else {
                            binding.recyclerViewSerie.visibility = View.VISIBLE
                            binding.progressBar.visibility = View.GONE
                            binding.NoResults.visibility = View.GONE
                        }
                    }
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return super.onCreateOptionsMenu(menu, inflater)
    }
}
