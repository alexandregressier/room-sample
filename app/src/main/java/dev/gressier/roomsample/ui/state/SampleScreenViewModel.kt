package dev.gressier.roomsample.ui.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.gressier.roomsample.data.local.daos.MyEntityDao
import dev.gressier.roomsample.data.local.entities.MyEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class SampleScreenViewModel(private val myEntityDao: MyEntityDao) : ViewModel() {
    val entities: Flow<List<MyEntity>> = myEntityDao.getAllEntities()

    fun insertEntity() = viewModelScope.launch {
        val newEntity = MyEntity()
        myEntityDao.insert(newEntity)
    }
}