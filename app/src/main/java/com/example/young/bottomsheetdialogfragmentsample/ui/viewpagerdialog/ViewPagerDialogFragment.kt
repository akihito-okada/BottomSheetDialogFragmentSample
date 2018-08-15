package com.example.young.bottomsheetdialogfragmentsample.ui.viewpagerdialog

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.ViewModelProviders
import com.example.young.bottomsheetdialogfragmentsample.R
import com.example.young.bottomsheetdialogfragmentsample.databinding.FragmentViewpagerDialogBinding
import com.example.young.bottomsheetdialogfragmentsample.ui.samplelist.SampleListFragment
import com.example.young.bottomsheetdialogfragmentsample.ui.viewpager.ViewPagerFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ViewPagerDialogFragment : BottomSheetDialogFragment(), ViewPagerDialogNavigationListener {

    private lateinit var binding: FragmentViewpagerDialogBinding
    private lateinit var viewModel: ViewPagerDialogViewModel

    companion object {
        fun newInstance() = ViewPagerDialogFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(BottomSheetDialogFragment.STYLE_NO_TITLE, R.style.BottomSheetDialog)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(ViewPagerDialogViewModel::class.java)
        binding = FragmentViewpagerDialogBinding.inflate(inflater, container, false).also {
            it.viewModel = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog.setOnShowListener {
            //this disables outside touch
            //dialog.window.findViewById<View>(R.id.touch_outside).setOnClickListener(null)
            //this prevents dragging behavior
            val param = (dialog.window.findViewById<View>(R.id.design_bottom_sheet).layoutParams as CoordinatorLayout.LayoutParams)
            param.behavior = null
            param.gravity = Gravity.BOTTOM
            param.height = CoordinatorLayout.LayoutParams.WRAP_CONTENT

        }

        childFragmentManager.beginTransaction().replace(R.id.container, ViewPagerFragment.newInstance()).commit()
    }

    override fun navigateToSampleList() {
        childFragmentManager.beginTransaction().replace(R.id.container, SampleListFragment.newInstance()).commit()
    }
}
