package com.androiddevs.drugsinspectr

import androidx.lifecycle.ViewModel
import com.androiddevs.drugsinspectr.Client.ClientRepository
import com.androiddevs.drugsinspectr.db.entities.DrugItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DrugViewModel(
    private val repository: DrugRepository,
) : ViewModel() {
    fun insert(item: DrugItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.insert(item)

    }

    fun delete(item: DrugItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllDrugList() = repository.getAllDrugList()

    fun deleteById(id: Int) = CoroutineScope(Dispatchers.Main).launch {
        repository.deleteById(id)
    }
}