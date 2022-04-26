package com.example.myserieslist.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myserieslist.R
import com.example.myserieslist.databinding.FragmentSearchBinding

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSearchBinding>(
            inflater,
            R.layout.fragment_search, container, false)

        binding.detailsButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_searchFragment_to_detailsFragment)
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}
