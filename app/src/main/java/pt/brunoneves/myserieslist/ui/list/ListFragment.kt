package pt.brunoneves.myserieslist.ui.list

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pt.brunoneves.myserieslist.R
import pt.brunoneves.myserieslist.databinding.FragmentListBinding

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {
    private val viewModel: ListViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(this, ListViewModel.Factory(activity.application))
            .get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentListBinding>(
            inflater, R.layout.fragment_list, container, false
        )

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        // Get a reference to the ViewModel associated with this fragment.
        val ListViewModel =
            ViewModelProvider(
                this,
            ).get(ListViewModel::class.java)

        val adapter = ListSeriesAdapter()

        //create observer
        ListViewModel.series.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
                if (adapter.data.isEmpty()) {
                    binding.recyclerViewSerie.visibility = View.GONE
                    binding.emptyList.visibility = View.VISIBLE
                } else {
                    binding.recyclerViewSerie.visibility = View.VISIBLE
                    binding.emptyList.visibility = View.GONE
                }
            }
        })

        binding.recyclerViewSerie.adapter = adapter

        // To use the View Model with data binding, you have to explicitly
        // give the binding object a reference to it.
        binding.viewModel = ListViewModel

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
