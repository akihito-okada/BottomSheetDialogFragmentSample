package com.example.young.bottomsheetdialogfragmentsample.ui.main

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.young.bottomsheetdialogfragmentsample.util.SingleLiveEvent

class MainViewModel : ViewModel() {

    internal val showViewPagerDialog = SingleLiveEvent<Void>()

    fun onClickButton(@Suppress("UNUSED_PARAMETER") view: View) {
        showViewPagerDialog.call()
    }
}
