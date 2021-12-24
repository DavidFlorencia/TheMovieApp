package com.dflorencia.themovieapp.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dflorencia.themovieapi.movie.Movie
import com.dflorencia.themovierepository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

enum class ApiStatus { LOADING, ERROR, DONE }

@HiltViewModel
class OverviewViewModel @Inject constructor(val appRepository: AppRepository): ViewModel() {

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> get() = _status;

    val movies: LiveData<List<Movie>> get() = appRepository.moviesTopRated

    init {
        refreshDataFromRepository()
    }

    private fun refreshDataFromRepository(query: String = "") {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                appRepository.refreshData()
                _status.value = ApiStatus.DONE
            } catch (networkError: IOException) {
                if (movies.value.isNullOrEmpty()) {
                    _status.value = ApiStatus.ERROR
                }else {
                    _status.value = ApiStatus.DONE
                }
            }
        }
    }
}