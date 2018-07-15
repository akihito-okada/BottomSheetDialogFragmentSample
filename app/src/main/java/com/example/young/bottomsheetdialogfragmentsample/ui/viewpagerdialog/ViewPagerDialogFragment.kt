package com.example.young.bottomsheetdialogfragmentsample.ui.viewpagerdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProviders
import com.example.young.bottomsheetdialogfragmentsample.R
import com.example.young.bottomsheetdialogfragmentsample.databinding.FragmentViewpagerDialogBinding
import com.example.young.bottomsheetdialogfragmentsample.ui.samplelist.SampleListFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ViewPagerDialogFragment : BottomSheetDialogFragment() {

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
            it.viewModel= viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTabLayout()
    }

    private fun initTabLayout() {
        binding.apply {
            viewPager.offscreenPageLimit = 2
            viewPager.adapter = CustomViewPagerAdapter(childFragmentManager)
            tabLayout.setupWithViewPager(viewPager)
        }
    }

    inner class CustomViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
        override fun getItem(position: Int): Fragment {
            return Tabs.forOrder(position).fragment
        }

        override fun getCount(): Int {
            return Tabs.values().size - 1
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return Tabs.forOrder(position).name
        }
    }

    enum class Tabs {
        Main {
            override val fragment: Fragment
                get() = SampleListFragment.newInstance()
        },
        Sub {
            override val fragment: Fragment
                get() = SampleListFragment.newInstance()
        },
        Unknown {
            override val fragment: Fragment
                get() = SampleListFragment.newInstance()
        };

        abstract val fragment: Fragment

        companion object {
            fun forOrder(ordinal: Int): Tabs {
                for (tabs in Tabs.values()) {
                    if (tabs.ordinal == ordinal) {
                        return tabs
                    }
                }
                return Unknown
            }
        }
    }
}
