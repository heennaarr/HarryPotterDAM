package com.example.harrypotterdam.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.harrypotterdam.R
import com.example.harrypotterdam.app.Extensions.loadUrl
import com.example.harrypotterdam.databinding.FragmentHarrypotterBinding
import com.example.harrypotterdam.domain.Characters


class HarryPotterFragment : Fragment() {
    private lateinit var charactersFactory: HarryPotterFactory
    private lateinit var viewModel: HarryPotterViewModel

    private var _binding : FragmentHarrypotterBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
    private fun setupObserver() {
        val characterObserver = Observer<HarryPotterViewModel.UiState> { uiState ->
            uiState.characters?.let {
                bindData(it)
            }
            uiState.errorMessage?.let {
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
        viewModel.uiState.observe(this, characterObserver)
    }
    private fun bindData(characters: List<Characters>) {
        binding.nameCharacter1.text = characters[0].name
        binding.houseCharacter1.text = characters[0].house
        val imageView1 = binding.imageCharacter1
        imageView1.loadUrl(characters[0].image)
        binding.nameCharacter2.text = characters[1].name
        binding.houseCharacter2.text = characters[1].house
        val imageView2 = binding.imageCharacter2
        imageView2.loadUrl(characters[1].image)
        binding.nameCharacter3.text = characters[2].name
        binding.houseCharacter3.text = characters[2].house
        val imageView3 = binding.imageCharacter3
        imageView3.loadUrl(characters[2].image)
        binding.nameCharacter4.text = characters[3].name
        binding.houseCharacter4.text = characters[3].house
        val imageView4 = binding.imageCharacter4
        imageView4.loadUrl(characters[3].image)


    }


    private fun navigateToCharacterDetail(characterId: String) {
        startActivity(HarryPotterCharactersDetailActivity.getIntent(requireContext(), characterId))
    }
}