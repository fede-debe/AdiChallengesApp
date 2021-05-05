package com.example.adichallengesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adichallengesapp.R
import com.example.adichallengesapp.databinding.ProductItemBinding
import com.example.adichallengesapp.model.Product

open class ProductListAdapter(private var productsList: ArrayList<Product>): RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
            MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(productsList[position])
    }

    override fun getItemCount(): Int = productsList.size

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private lateinit var binding: ProductItemBinding

        fun bind(product: Product){
            binding.apply {
                tvProductName.text = product.name
                tvProductDescription.text = product.description
                tvProductPrice.text = product.price.toString()
                Glide.with(binding.ivProductImageItem.context)
                        .load(product.imgUrl)
                        .into(binding.ivProductImageItem)
            }
        }
    }

    fun addProducts(products: List<Product>){
        this.productsList.apply {
            clear()
            addAll(products)
        }
    }
}