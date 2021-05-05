package com.example.adichallengesapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.adichallengesapp.R
import com.example.adichallengesapp.databinding.FragmentProductDetailsBinding
import com.example.adichallengesapp.repository.AdiProductsRepository
import com.example.adichallengesapp.repository.AdiReviewRepository

class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding
    private lateinit var viewModel: ReviewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_details, container, false)

        viewModel = ViewModelProvider(this).get(ReviewsViewModel::class.java)
        viewModel.setAdiReviewRepository(AdiReviewRepository)

        viewModel.reviewsList.observe(viewLifecycleOwner, Observer {
            viewModel.getReviewsList()

        })

        return binding.root
    }

}