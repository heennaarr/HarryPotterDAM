package com.example.harrypotterdam.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.harrypotterdam.app.Extensions.loadUrl
import com.example.harrypotterdam.databinding.FragmentHarrypotterdetailBinding
import com.example.harrypotterdam.domain.Characters

class HarryPotterCharactersDetailFragment: Fragment() {
    private lateinit var harryPotterFactory: HarryPotterFactory
    private lateinit var viewModel: HarryPotterCharactersDetailViewModel

    private var _binding : FragmentHarrypotterdetailBinding?=null
    private val binding get() = _binding!!

    private val characterArgs:  HarryPotterCharactersDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHarrypotterdetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        harryPotterFactory = HarryPotterFactory(requireContext())
        viewModel = harryPotterFactory.getCharacterDetailViewModel()

        setupObserver()
        characterArgs.characterId
        viewModel.viewCreated(characterArgs.characterId)

    }
    private fun setupObserver() {
        val characterObserver = Observer<HarryPotterCharactersDetailViewModel.UiState> { uiState ->
            uiState.character?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto el error
            }
            if (uiState.isLoading) {
                //muestro el cargando...
                Log.d("@dev", "Cargando...")
            } else {
                //oculto el cargando...
                Log.d("@dev", " Cargado ...")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, characterObserver)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun bindData(character: Characters){
        binding.nameCharacter.text = character.name
        binding.houseCharacter.text = character.house
        val imageView = binding.imageCharacter
        imageView.loadUrl(character.image)




    }



}