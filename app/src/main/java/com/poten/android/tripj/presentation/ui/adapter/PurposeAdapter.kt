package com.poten.android.tripj.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poten.android.tripj.databinding.ItemTravelPurposeBinding
import com.poten.android.tripj.util.setOnAvoidDuplicateClick

class PurposeAdapter(
    private val items: List<String>,
    private val onClick: (String) -> Unit,
) : RecyclerView.Adapter<PurposeAdapter.PurposeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurposeViewHolder {
        return PurposeViewHolder(
            ItemTravelPurposeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PurposeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    inner class PurposeViewHolder(private val binding: ItemTravelPurposeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.itemTextView.text = item
            binding.root.setOnAvoidDuplicateClick {
                onClick(item)
            }
        }
    }
}