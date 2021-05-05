package com.example.adichallengesapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adichallengesapp.R
import com.example.adichallengesapp.adapter.ProductReviewsAdapter
import com.example.adichallengesapp.databinding.FragmentProductDetailsBinding
import com.example.adichallengesapp.model.Review
import com.example.adichallengesapp.retrofit.*
import com.example.adichallengesapp.ui.base.ReviewsViewModelFactory
import com.example.adichallengesapp.utils.Status

class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding
    private lateinit var viewModel: ReviewsViewModel
    private lateinit var adapter: ProductReviewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_details, container, false)

        setupViewModel()
        setupUi()
        setUpObservers()

        return binding.root
    }

    private fun setupViewModel(){
        viewModel = ViewModelProviders.of(this, ReviewsViewModelFactory(
            ApiReviewsHelper(
                RetrofitBuilderReviews.apiReviews))
        ).get(ReviewsViewModel::class.java)
    }

    private fun setupUi(){
        binding.rvReviewsProductDetails.layoutManager = LinearLayoutManager(activity)
        adapter = ProductReviewsAdapter(arrayListOf())
        binding.rvReviewsProductDetails.addItemDecoration(
            DividerItemDecoration(
            binding.rvReviewsProductDetails.context,
            (binding.rvReviewsProductDetails.layoutManager as LinearLayoutManager).orientation)
        )
        binding.rvReviewsProductDetails.adapter = adapter
    }


    private fun setUpObservers(){
        viewModel.getReviews().observe(viewLifecycleOwner){
            it?.let { resource ->
                when(resource.status){
                    Status.SUCCESS -> {
                        binding.rvReviewsProductDetails.visibility = View.VISIBLE
                        resource.data?.let { reviews -> retrieveReviews(reviews) }
                    }
                    Status.ERROR -> {
                        binding.rvReviewsProductDetails.visibility = View.VISIBLE
                        Toast.makeText(parentFragment?.context, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.rvReviewsProductDetails.visibility = View.GONE

                    }
                }
            }
        }
    }

    private fun retrieveReviews(reviews: List<Review>){
        adapter.apply {
            addReviews(reviews)
            notifyDataSetChanged()
        }
    }

}