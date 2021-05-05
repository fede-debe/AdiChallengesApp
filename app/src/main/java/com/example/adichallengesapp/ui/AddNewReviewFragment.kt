package com.example.adichallengesapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.adichallengesapp.R
import com.example.adichallengesapp.databinding.FragmentAddNewReviewBinding
import java.util.*


class AddNewReviewFragment : Fragment() {

    private lateinit var binding: FragmentAddNewReviewBinding
    private lateinit var viewModel: ReviewsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_new_review, container, false)


        return binding.root
    }
}