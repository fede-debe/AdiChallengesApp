package com.example.adichallengesapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adichallengesapp.R
import com.example.adichallengesapp.adapter.ProductListAdapter
import com.example.adichallengesapp.databinding.FragmentProductsListBinding
import com.example.adichallengesapp.databinding.ProductItemBinding
import com.example.adichallengesapp.model.Product
import com.example.adichallengesapp.repository.AdiProductsRepository

class ProductsListFragment : Fragment() {

    private lateinit var binding: FragmentProductsListBinding
    private lateinit var productBinding: ProductItemBinding
    private lateinit var viewModel: ProductsListViewModel
    lateinit var  recyclerView: RecyclerView
    private lateinit var adapter: ProductListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_products_list, container, false)

        setupViewModel()
        setupUi()






        viewModel.productList.observe(viewLifecycleOwner) {

           }

        return binding.root
    }

    private fun showProducts(products: List<Product>?) {
        adapter.apply {

        }

    }

    private fun setupUi(){
        binding.rvProductsList.layoutManager = LinearLayoutManager(requireActivity().baseContext)
        adapter = ProductListAdapter(requireActivity().baseContext, arrayListOf())
        binding.rvProductsList.addItemDecoration(DividerItemDecoration(
                binding.rvProductsList.context,
                (binding.rvProductsList.layoutManager as LinearLayoutManager).orientation))
        binding.rvProductsList.adapter = adapter
    }

    private fun setupViewModel(){
        viewModel = ViewModelProvider(this).get(ProductsListViewModel::class.java)
        viewModel.setAdiRepository(AdiProductsRepository)
    }

    private fun setUpObservers(){
        viewModel.productList.observe(this, Observer {
            it.let { list ->
               // TODO
            }
        })
    }

    private fun retrieveProducts(products: List<Product>){
        adapter.apply {
            addProducts(products)
            notifyDataSetChanged()
        }
    }

}