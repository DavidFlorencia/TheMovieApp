package com.dflorencia.themovieapp.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dflorencia.themovieapi.movie.Movie

class MovieViewModel: ViewModel(){
    private val _movie = MutableLiveData<Movie>();
    val movie: LiveData<Movie> get() = _movie

    fun setMovie(movie: Movie){
        _movie.value = movie
    }
}