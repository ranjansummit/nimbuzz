package com.nimbuzz.photoapp.data.repository

import com.nimbuzz.photoapp.data.datasource.remote.ApiService
import javax.inject.Inject

class NimBuzzRepository @Inject constructor(
    private val apiService: ApiService
) : NimBuzzInterface {

}