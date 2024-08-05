package com.example.interntasks_4a.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.interntasks_4a.Adapter.CharacterAdapter
import com.example.interntasks_4a.Model.CharacterModel
import com.example.interntasks_4a.ViewModel.CharacterViewModel
import com.example.interntasks_4a.databinding.FragmentCharacterListBinding

class CharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CharacterViewModel by viewModels()
    private lateinit var adapter: CharacterAdapter
    val characterList = ArrayList<CharacterModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CharacterAdapter(characterList)
        binding.recylerView.adapter = adapter

        viewModel.getData()
        observerData()
    }

    fun observerData(){
        viewModel.characters.observe(viewLifecycleOwner, Observer { character ->
            character?.let {
                characterList.clear()
                characterList.addAll(it)
                adapter.notifyDataSetChanged()

                adapter.onClick = { characterModel ->
                    val action = CharacterListFragmentDirections.actionCharacterListFragmentToCharacterDetailFragment(character = characterModel)
                    findNavController().navigate(action)
                }
            }
        })
        viewModel.error.observe(viewLifecycleOwner, Observer { errorMessage ->
            errorMessage?.let {
                Log.e("CharacterFragment", "Error: $it")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}