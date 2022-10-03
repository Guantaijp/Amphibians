package com.example.amphibians.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.amphibians.databinding.ListViewItemBinding
import com.example.amphibians.network.Amphibian


class AmphibianListAdapter(val clickListener: AmphibianListener) :
    ListAdapter<Amphibian, AmphibianListAdapter.AmphibianViewHolder>(DiffCallback) {

    class AmphibianViewHolder (var binding:ListViewItemBinding):
    RecyclerView.ViewHolder(binding.root){

        fun bind(clickListener: AmphibianListener, amphibian: Amphibian){
            binding.amphibian = amphibian
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmphibianViewHolder {
    val  layoutInflater = LayoutInflater.from(parent.context)
        return AmphibianViewHolder(
            ListViewItemBinding.inflate(layoutInflater,parent,false)
        )
    }

    override fun onBindViewHolder(holder: AmphibianViewHolder, position: Int) {
      val amphibian = getItem(position)
        holder.bind(clickListener,amphibian)
    }


}

object DiffCallback : DiffUtil.ItemCallback<Amphibian>() {
    override fun areItemsTheSame(oldItem: Amphibian, newItem: Amphibian): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Amphibian, newItem: Amphibian): Boolean {
       return oldItem.type == newItem.type &&
               oldItem.description == newItem.description
    }

}

class AmphibianListener(val clickListener:(amphibian: Amphibian) -> Unit) {
    fun onClick(amphibian: Amphibian) = clickListener(amphibian)

}
