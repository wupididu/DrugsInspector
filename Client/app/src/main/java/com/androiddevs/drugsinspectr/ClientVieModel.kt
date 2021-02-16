package com.androiddevs.drugsinspectr

import androidx.lifecycle.ViewModel
import com.androiddevs.drugsinspectr.Client.ClientRepository
import com.androiddevs.drugsinspectr.db.entities.DrugItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClientVieModell(
    private val repository: ClientRepository
) : ViewModel() {
    fun insert(item: DrugItem) = repository.insert(item)


    fun delete(item: DrugItem) = repository.delete(item)


    fun getAllDrugList() = repository.getAllDrugsList()

    fun deleteById(id: Int) = repository.deleteById(id)

}