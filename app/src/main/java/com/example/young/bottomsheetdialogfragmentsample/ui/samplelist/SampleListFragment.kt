package com.example.young.bottomsheetdialogfragmentsample.ui.samplelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.young.bottomsheetdialogfragmentsample.adapter.ListRecyclerViewAdapter
import com.example.young.bottomsheetdialogfragmentsample.databinding.FragmentSampleListBinding
import com.example.young.bottomsheetdialogfragmentsample.ui.main.MainViewModel

class SampleListFragment : Fragment() {

    private lateinit var viewModel: SampleListViewModel
    private lateinit var binding: FragmentSampleListBinding

    companion object {
        fun newInstance() = SampleListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(SampleListViewModel::class.java)
        binding = FragmentSampleListBinding.inflate(inflater, container, false).also {
            it.viewModel = viewModel
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemList = viewModel.itemList
        binding.apply {
            recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = ListRecyclerViewAdapter(itemList)
            }
        }
    }
}
