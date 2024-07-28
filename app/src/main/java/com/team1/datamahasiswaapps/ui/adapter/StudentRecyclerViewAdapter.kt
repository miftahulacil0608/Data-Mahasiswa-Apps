package com.team1.datamahasiswaapps.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.team1.datamahasiswaapps.databinding.CardviewBinding
import com.team1.datamahasiswaapps.domain.model.Students

class StudentRecyclerViewAdapter(val itemClicked: (Students) -> Unit) :
    ListAdapter<Students, StudentRecyclerViewAdapter.ViewHolder>(DIFF_CALLBACK) {

    inner class ViewHolder(val binding: CardviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Students) {
            binding.usernameItemCardview.text = data.username
            binding.nimItemCardview.text = data.nim.toString()

            binding.root.setOnClickListener {
                itemClicked(data)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = CardviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listStudents = getItem(position)
        holder.bind(listStudents)
    }


    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Students> =
            object : DiffUtil.ItemCallback<Students>() {
                override fun areItemsTheSame(oldItem: Students, newItem: Students): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: Students, newItem: Students): Boolean {
                    return oldItem == newItem
                }

            }
    }


}