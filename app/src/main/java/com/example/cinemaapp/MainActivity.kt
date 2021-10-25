package com.example.cinemaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), MoviesListFragment.MovieClickListener,
    MovieDetailsFragment.MovieBackClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragments_container, MoviesListFragment.newInstance())
                .commit()
        }
    }

    override fun onBackClick() {
        supportFragmentManager.popBackStack()
    }

    override fun goToDetails() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragments_container, MovieDetailsFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }
}