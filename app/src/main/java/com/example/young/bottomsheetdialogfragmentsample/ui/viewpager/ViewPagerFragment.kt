package com.example.young.bottomsheetdialogfragmentsample.ui.viewpager

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.young.bottomsheetdialogfragmentsample.databinding.FragmentViewpagerBinding
import com.example.young.bottomsheetdialogfragmentsample.ui.samplelist.SampleListFragment
import com.example.young.bottomsheetdialogfragmentsample.ui.viewpagerdialog.ViewPagerDialogNavigationListener

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewpagerBinding

    private var listener: ViewPagerDialogNavigationListener? = null

    companion object {
        fun newInstance() = ViewPagerFragment()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (parentFragment is ViewPagerDialogNavigationListener) {
            listener = parentFragment as? ViewPagerDialogNavigationListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentViewpagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTabLayout()

        binding.editText.setOnClickListener {
            listener?.navigateToSampleList()
        }
    }

    private fun initTabLayout() {
        binding.apply {
            viewPager.offscreenPageLimit = 2
            viewPager.adapter = CustomViewPagerAdapter(childFragmentManager)
            tabLayout.setupWithViewPager(viewPager)
        }
    }

    inner class CustomViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
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
