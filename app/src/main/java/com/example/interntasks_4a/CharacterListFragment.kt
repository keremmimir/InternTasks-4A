package com.example.interntasks_4a

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.interntasks_4a.databinding.FragmentCharacterListBinding

class CharacterListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterListBinding.inflate(layoutInflater)
        return binding.root
    }
}