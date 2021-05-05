package com.example.adichallengesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.adichallengesapp.R
import com.example.adichallengesapp.databinding.FragmentProductsListBinding
import com.example.adichallengesapp.databinding.ProductItemBinding
import com.example.adichallengesapp.model.Product

open class ProductListAdapter(private val context: Context, private var productsList: ArrayList<Product>): RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
            MyViewHolder(LayoutInflater.from(context).inflate(R.layout.product_item, parent, false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(productsList[position])
//        Glide
//                .with(context)
//                .load(model.image)
//                .apply(RequestOptions().centerCrop())
//                .into(holder.image)
//
//        holder.productName.text = model.name
//        holder.productDescription.text = model.description
//        holder.productPrice.text = model.price.toString()
//        holder.itemView.setOnClickListener {
//            if (onClickListener != null) {
//                onClickListener!!.onClick(position, model)
//            }
//        }

    }

    override fun getItemCount(): Int = productsList.size


    interface OnClickListener{
        fun onClick(position: Int, model: Product)
    }

    // we already have an interface but we need also a method as onClickListener
    fun setOnClickListener(onClickListener: OnClickListener){
        // the onClickListener of this class should be the onClickListener that is passed to this method
        this.onClickListener = onClickListener
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private lateinit var binding: ProductItemBinding

        fun bind(product: Product){
            binding.apply {
                tvProductName.text = product.name
                tvProductDescription.text = product.description
                tvProductPrice.text = product.price.toString()
                Glide.with(binding.ivProductImageItem.context)
                        .load(product.image)
                        .into(binding.ivProductImageItem)

            }

        }


//            var image: ImageView = view.findViewById(R.id.iv_product_image_item)
//            var productName: TextView = view.findViewById(R.id.tv_product_name)
//            var productDescription: TextView = view.findViewById(R.id.tv_product_description)
//            var productPrice: TextView = view.findViewById(R.id.tv_product_price)
//            var recyclerView: RecyclerView = view.findViewById(R.id.rv_products_list)

    }

    fun addProducts(products: List<Product>){
        this.productsList.apply {
            clear()
            addAll(products)
        }
    }



}