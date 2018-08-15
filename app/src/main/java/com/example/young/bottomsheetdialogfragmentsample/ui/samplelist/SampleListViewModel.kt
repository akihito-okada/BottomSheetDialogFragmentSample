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
            add(ListItem("4", "fuga"))
            add(ListItem("5", "fuga"))
            add(ListItem("6", "fuga"))
            add(ListItem("7", "fuga"))
            add(ListItem("8", "fuga"))
            add(ListItem("9", "fuga"))
            add(ListItem("10", "fuga"))
            add(ListItem("11", "fuga"))
            add(ListItem("12", "fuga"))
            add(ListItem("13", "fuga"))
            add(ListItem("14", "fuga"))
            add(ListItem("15", "fuga"))
            add(ListItem("16", "fuga"))
            add(ListItem("17", "fuga"))
            add(ListItem("18", "fuga"))
            add(ListItem("19", "fuga"))
            add(ListItem("20", "fuga"))
            add(ListItem("21", "fuga"))
            add(ListItem("22", "fuga"))
            add(ListItem("23", "fuga"))
            add(ListItem("24", "fuga"))
        }
    }
}
