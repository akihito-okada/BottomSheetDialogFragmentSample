package com.example.young.bottomsheetdialogfragmentsample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableList
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.young.bottomsheetdialogfragmentsample.R
import com.example.young.bottomsheetdialogfragmentsample.data.ListItem
import com.example.young.bottomsheetdialogfragmentsample.databinding.AdapterListItemBinding


class ListRecyclerViewAdapter(private var itemList :ObservableList<ListItem>)
    : RecyclerView.Adapter<ListRecyclerViewAdapter.BindingViewHolder>() {

    init {
        itemList.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableList<ListItem>>() {
            override fun onChanged(items: ObservableList<ListItem>) {
                notifyDataSetChanged()
            }

            override fun onItemRangeChanged(items: ObservableList<ListItem>, i: Int, i1: Int) {
                notifyItemRangeChanged(i, i1)
            }

            override fun onItemRangeInserted(items: ObservableList<ListItem>, i: Int, i1: Int) {
                notifyItemRangeInserted(i, i1)
            }

            override fun onItemRangeMoved(items: ObservableList<ListItem>, i: Int, i1: Int, i2: Int) {
                notifyItemMoved(i, i1)
            }

            override fun onItemRangeRemoved(items: ObservableList<ListItem>, i: Int, i1: Int) {
                notifyItemRangeRemoved(i, i1)
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: AdapterListItemBinding = DataBindingUtil.inflate(inflater, R.layout.adapter_list_item, parent, false)
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val binding = holder.binding as AdapterListItemBinding
        binding.listItem = itemList.get(position)
    }

    override fun getItemCount(): Int = itemList.size

    class BindingViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}
