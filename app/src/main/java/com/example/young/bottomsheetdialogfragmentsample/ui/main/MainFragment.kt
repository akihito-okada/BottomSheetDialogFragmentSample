package com.example.young.bottomsheetdialogfragmentsample.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.young.bottomsheetdialogfragmentsample.databinding.FragmentMainBinding
import com.example.young.bottomsheetdialogfragmentsample.ui.viewpagerdialog.ViewPagerDialogFragment

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding = FragmentMainBinding.inflate(inflater, container, false).also {
            it.viewModel = viewModel
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.also { viewModel ->
            viewModel.showViewPagerDialog.observe(this, Observer {
                val viewPagerDialogFragment = ViewPagerDialogFragment.newInstance()
                viewPagerDialogFragment.show(fragmentManager, ViewPagerDialogFragment::class.java.simpleName)
            })
        }
    }
}
