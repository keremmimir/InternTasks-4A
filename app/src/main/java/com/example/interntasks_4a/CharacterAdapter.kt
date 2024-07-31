package com.example.interntasks_4a

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.interntasks_4a.databinding.CharacterRowBinding

class CharacterAdapter (val characterList : ArrayList<CharacterModel>) : RecyclerView.Adapter<CharacterAdapter.Holder>(){

    var onClick:((CharacterModel)-> Unit)? = null

    inner class Holder (val binding: CharacterRowBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(characterModel: CharacterModel) {
            with(binding) {
                characterName.text = characterModel.fullName
            }

            itemView.setOnClickListener {
                onClick?.invoke(characterModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.Holder {
        val binding = CharacterRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: CharacterAdapter.Holder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

}