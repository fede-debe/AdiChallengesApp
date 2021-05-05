package com.example.adichallengesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adichallengesapp.R
import com.example.adichallengesapp.model.Review

open class ProductReviewsAdapter(private val context: Context, private var reviewsList: List<Review>): RecyclerView.Adapter<ProductReviewsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.review_object, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model = reviewsList[position]

        holder.review.text = model.text



    }

    override fun getItemCount(): Int {
        return reviewsList.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        val review: TextView = view.findViewById(R.id.tv_review)


    }


}