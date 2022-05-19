package pt.brunoneves.myserieslist.ui.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import pt.brunoneves.myserieslist.R
import pt.brunoneves.myserieslist.data.model.Serie
import pt.brunoneves.myserieslist.data.remote.SeriesDatabase
import pt.brunoneves.myserieslist.data.remote.getDatabase
import pt.brunoneves.myserieslist.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


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
            inflater, R.layout.fragment_list, container,false)

        binding.viewModel = viewModel

        binding.navButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_searchFragment)
        }

        binding.detailsButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_detailsFragment)
        }

        TODO("the listeners bellow are just for test and they will be\n" +
                "removed in the future")
        /* binding.insertDb.setOnClickListener { view : View ->
             viewModel.addToList()
         }

         binding.searchDb.setOnClickListener { view : View ->
             viewModel.checkSerie()
         }

         binding.removeDb.setOnClickListener { view : View ->
             viewModel.removeFromList()
         }

         binding.logDb.setOnClickListener { view : View ->
             viewModel.getListSerie()
         }*/

        // Inflate the layout for this fragment
        return binding.root
    }

}


