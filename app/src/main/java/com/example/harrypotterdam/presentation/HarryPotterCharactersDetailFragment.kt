package com.example.harrypotterdam.presentation

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
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
        binding.imageCharacter.loadUrl(character.image)
        val houseText = "Casa: ${character.house}"
        binding.houseCharacter.text = createSpannableString(houseText, "Casa: ")

        // Aplicar el formato en negrita a "Patronus:"
        val patronusText = "Patronus: ${character.patronus}"
        binding.patronusCharacter.text = createSpannableString(patronusText, "Patronus: ")

        // Aplicar el formato en negrita a "Año de nacimiento:"
        val birthYearText = "Año de nacimiento: ${character.birthYear}"
        binding.birthYearCharacter.text = createSpannableString(birthYearText, "Año de nacimiento: ")

        // Asignar la descripción
        binding.description.text = "Descripción: ${character.occupation ?: "Información no disponible"}"




    }
    private fun createSpannableString(fullText: String, boldPart: String): SpannableString {
        val spannableString = SpannableString(fullText)

        // Encontrar la posición del texto a poner en negrita
        val start = fullText.indexOf(boldPart)
        val end = start + boldPart.length

        // Aplicar el estilo negrita al texto especificado
        spannableString.setSpan(
            StyleSpan(Typeface.BOLD),
            start,
            end,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        return spannableString
    }


}