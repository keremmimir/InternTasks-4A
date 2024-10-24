package com.example.interntasks_4a.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.interntasks_4a.databinding.FragmentCharacterDetailBinding

class CharacterDetailFragment : Fragment() {

    private  var _binding: FragmentCharacterDetailBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<CharacterDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            Glide.with(view.context)
                .load(args.character.image)
                .override(500,500)
                .into(imageDetail)

            fullNameText.text = args.character.fullName
            nickname.text = args.character.nickname
            hogwartsHouse.text = args.character.hogwartsHouse
            interpretedBy.text = args.character.interpretedBy

            val childrenArgs = args.character.children
            if (childrenArgs != null) {
                val concatenatedChildren = childrenArgs.joinToString("\n")
                children.text = concatenatedChildren
            }

            birthdate.text = args.character.birthdate
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}