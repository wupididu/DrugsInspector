package com.androiddevs.drugsinspectr

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.drugsinspectr.Client.ClientRepository

@Suppress("UNCHECKED_CAST")
class DrugsViewModelFactory(
    private val repository: DrugRepository,
    private val clientRepository: ClientRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DrugViewModel(repository, clientRepository) as T
    }

}