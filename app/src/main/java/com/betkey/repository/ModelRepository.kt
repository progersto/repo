package com.betkey.repository

import com.betkey.data.PreferencesManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class ModelRepository(
    private val preffsManager: PreferencesManager
) {

    private fun initCategoryList(): ArrayList<String> {
        val listCategory: ArrayList<String> = ArrayList()
        listCategory.add( "Столы")

        return listCategory
    }

    suspend fun initDB() {
        withContext(Dispatchers.IO) {
            val listCategory = initCategoryList()
            preffsManager.fistInit(true)
        }
    }

}


