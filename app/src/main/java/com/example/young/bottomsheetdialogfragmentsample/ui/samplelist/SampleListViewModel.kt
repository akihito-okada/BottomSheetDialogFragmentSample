package com.example.young.bottomsheetdialogfragmentsample.ui.samplelist

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.ViewModel
import com.example.young.bottomsheetdialogfragmentsample.data.ListItem

class SampleListViewModel : ViewModel() {

    var itemList : ObservableList<ListItem> = ObservableArrayList()

    init {
        itemList.apply {
            add(ListItem("1", "hoge"))
            add(ListItem("2", "piyo"))
            add(ListItem("3", "fuga"))
        }
    }
}
