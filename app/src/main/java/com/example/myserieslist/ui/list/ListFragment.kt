package com.example.myserieslist.ui.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.myserieslist.R
import com.example.myserieslist.databinding.FragmentListBinding


/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private val viewModel: ListViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        Log.i("qqq", "Inspect")
        ViewModelProvider(this, ListViewModel.Factory(activity.application))
            .get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("qqq", "create view")
        val binding = DataBindingUtil.inflate<FragmentListBinding>(
            inflater, R.layout.fragment_list, container,false)

        binding.viewModel = viewModel

        binding.navButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_searchFragment)
        }

        binding.detailsButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_detailsFragment)
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}


