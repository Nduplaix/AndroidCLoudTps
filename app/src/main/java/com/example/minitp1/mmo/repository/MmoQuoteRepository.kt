package com.example.minitp1.mmo.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.minitp1.architecture.CustomApplication
import com.example.minitp1.architecture.RetrofitBuilder
import com.example.minitp1.mmo.model.MmoRetrofit
import com.example.minitp1.mmo.model.MmoRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import kotlin.random.Random

class MmoQuoteRepository {
    private val mMmoDao = CustomApplication.instance.mApplicationDatabase.mmoDao()

    fun selectAllMmoQuote(): LiveData<List<MmoRoom>> {
        return mMmoDao.selectAll()
    }


    private suspend fun insertMmoQuote(mmoQuote: MmoRoom) =
        withContext(Dispatchers.IO) {
            mMmoDao.insert(mmoQuote)
        }


    suspend fun deleteAllMmoQuote() = withContext(Dispatchers.IO) {
        mMmoDao.deleteAll()
    }


    suspend fun fetchData() {
        try {
            insertMmoQuote(RetrofitBuilder.getMmoQuote().getRandomQuote("${Random.nextInt(1,511)}").toRoom())
        } catch (e: Exception) {
            Log.d("API-ERROR", e.message.toString())
        }
    }

}

private fun MmoRetrofit.toRoom(): MmoRoom {
    return MmoRoom(
        short_description = short_description,
        thumbnail = thumbnail
    )
}
