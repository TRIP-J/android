package com.poten.android.tripj.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poten.android.tripj.databinding.ItemPostSubjectBinding
import com.poten.android.tripj.util.setOnAvoidDuplicateClick

class SubjectAdapter(
    private val items: List<String>,
    private val onClick: (String) -> Unit,
) : RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        return SubjectViewHolder(
            ItemPostSubjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    inner class SubjectViewHolder(private val binding: ItemPostSubjectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.subjectTextView.text = item
            binding.root.setOnAvoidDuplicateClick {
                onClick(item)
            }
        }
    }
}