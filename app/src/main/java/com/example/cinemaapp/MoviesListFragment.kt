package com.example.cinemaapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView


class MoviesListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }
    private var clickListener: MovieClickListener? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MovieClickListener)
            clickListener = context
    }

    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<CardView>(R.id.movie_card).apply {
            setOnClickListener{
                clickListener?.goToDetails()
            }
        }
    }

    companion object {
        fun newInstance() = MoviesListFragment()
    }

    interface MovieClickListener{
        fun goToDetails()
    }
}