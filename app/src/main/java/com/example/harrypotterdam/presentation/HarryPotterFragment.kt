package com.example.harrypotterdam.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harrypotterdam.app.ErrorApp
import com.example.harrypotterdam.databinding.FragmentHarrypotterBinding
import com.example.harrypotterdam.domain.Characters
import org.koin.androidx.viewmodel.ext.android.viewModel


class HarryPotterFragment : Fragment() {
    val viewModel: HarryPotterViewModel by viewModel()

    private var _binding : FragmentHarrypotterBinding?=null
    private val binding get() = _binding!!
    private val adapter = HarryPotterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHarrypotterBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadCharacters()
        setupObserver()
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
        viewModel.uiState.observe(viewLifecycleOwner, characterObserver)
    }
    private fun bindData(characters: List<Characters>) {
        adapter.submitList(characters)

    }
    private fun setupView(){
        binding.apply {
            list.layoutManager = LinearLayoutManager(
                this@HarryPotterFragment.requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter.setEvent { heroId ->
                navigateToCharacterDetail(heroId)
            }
            list.adapter = adapter

        }
    }

    private fun navigateToCharacterDetail(characterId: String) {
        findNavController().navigate(
            HarryPotterFragmentDirections.actionHarryPotterFragmentToHarryPotterDetailFragment(characterId)
        )
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun showError(error: ErrorApp){
        when(error){
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
            ErrorApp.TestErrorApp -> TODO()
        }
    }
}