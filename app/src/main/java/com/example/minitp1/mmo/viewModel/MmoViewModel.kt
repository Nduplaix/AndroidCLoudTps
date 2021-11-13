package com.example.minitp1.mmo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.minitp1.mmo.model.MmoRoom
import com.example.minitp1.mmo.model.MmoUi
import com.example.minitp1.mmo.repository.MmoQuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MmoViewModel : ViewModel() {


    private val mMmoQuoteRepository: MmoQuoteRepository by lazy { MmoQuoteRepository() }
    var mMmoQuoteLiveData: LiveData<List<MmoUi>> =
        mMmoQuoteRepository.selectAllMmoQuote().map {
            it.toUi()
        }


    fun fetchNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            mMmoQuoteRepository.fetchData()
        }
    }




    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            mMmoQuoteRepository.deleteAllMmoQuote()
        }
    }
}


private fun List<MmoRoom>.toUi(): List<MmoUi> {
    return asSequence().map {
        MmoUi(
            short_description = it.short_description,
            thumbnail = it.thumbnail
        )
    }.toList()
}
