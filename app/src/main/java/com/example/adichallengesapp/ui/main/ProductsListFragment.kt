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
import com.example.adichallengesapp.adapter.ProductListAdapter
import com.example.adichallengesapp.databinding.FragmentProductsListBinding
import com.example.adichallengesapp.model.Product
import com.example.adichallengesapp.retrofit.ApiProductsHelper
import com.example.adichallengesapp.retrofit.RetrofitBuilderProducts
import com.example.adichallengesapp.ui.base.ProductsListViewModelFactory
import com.example.adichallengesapp.utils.Status.*

class ProductsListFragment : Fragment() {

    private lateinit var binding: FragmentProductsListBinding
    private lateinit var viewModel: ProductsListViewModel
    private lateinit var adapter: ProductListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_products_list, container, false)

        setupViewModel()
        setupUi()
        setUpObservers()

        return binding.root
    }


    private fun setupViewModel(){
        viewModel = ViewModelProviders.of(this, ProductsListViewModelFactory(ApiProductsHelper(RetrofitBuilderProducts.apiProducts))
        ).get(ProductsListViewModel::class.java)
    }


    private fun setupUi(){
        binding.rvProductsList.layoutManager = LinearLayoutManager(activity)
        adapter = ProductListAdapter(arrayListOf())
        binding.rvProductsList.addItemDecoration(DividerItemDecoration(
                binding.rvProductsList.context,
                (binding.rvProductsList.layoutManager as LinearLayoutManager).orientation))
        binding.rvProductsList.adapter = adapter
    }


    private fun setUpObservers(){
        viewModel.getProducts().observe(viewLifecycleOwner){
            it?.let { resource ->
                when(resource.status){
                    SUCCESS -> {
                        binding.rvProductsList.visibility = View.VISIBLE
                        resource.data?.let { products -> retrieveProducts(products) }
                    }
                    ERROR -> {
                        binding.rvProductsList.visibility = View.VISIBLE
                        Toast.makeText(parentFragment?.context, it.message, Toast.LENGTH_LONG).show()
                    }
                    LOADING -> {
                        binding.rvProductsList.visibility = View.GONE

                    }
                }
            }
        }
    }

    private fun retrieveProducts(products: List<Product>){
        adapter.apply {
            addProducts(products)
            notifyDataSetChanged()
        }
    }

}