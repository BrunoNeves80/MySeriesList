package pt.brunoneves.myserieslist.ui.details

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import pt.brunoneves.myserieslist.R

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }
}
