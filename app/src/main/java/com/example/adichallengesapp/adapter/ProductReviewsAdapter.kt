package com.example.adichallengesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adichallengesapp.R
import com.example.adichallengesapp.databinding.ReviewObjectBinding
import com.example.adichallengesapp.model.Review

open class ProductReviewsAdapter(private var reviewsList: ArrayList<Review>): RecyclerView.Adapter<ProductReviewsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.review_object, parent, false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(reviewsList[position])
    }

    override fun getItemCount(): Int = reviewsList.size

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        private lateinit var binding: ReviewObjectBinding

        fun bind(review: Review){
            binding.apply {
                tvReview.text = review.text
            }
        }
    }

    fun addReviews(reviews: List<Review>){
        this.reviewsList.apply {
            clear()
            addAll(reviews)
        }
    }
}