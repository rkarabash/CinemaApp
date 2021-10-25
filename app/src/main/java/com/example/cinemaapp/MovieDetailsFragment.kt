package com.example.cinemaapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class MovieDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    private var clickListener: MovieBackClickListener? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MovieBackClickListener)
            clickListener = context
    }

    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<LinearLayout>(R.id.btn_back).apply {
            setOnClickListener {
                clickListener?.onBackClick()
            }
        }
    }

    companion object {
        fun newInstance() = MovieDetailsFragment()
    }

    interface MovieBackClickListener {
        fun onBackClick()
    }
}