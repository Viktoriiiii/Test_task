package ru.spb.viktorii.test_task.catalog_screen.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.spb.viktorii.test_task.R
import ru.spb.viktorii.test_task.catalog_screen.adapter.ProductAdapter
import ru.spb.viktorii.test_task.databinding.FragmentCatalogBinding
import ru.spb.viktorii.test_task.utils.MAIN

class CatalogFragment : Fragment() {

    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!
    private val vmCatalog: CatalogViewModel by viewModel()
    private var catalogAdapter = ProductAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MAIN.changeItemsInToolbar(getString(R.string.catalog), true)
        showInfoAboutProducts()
        binding.srl.setOnRefreshListener {
            vmCatalog.getProducts()
            if (vmCatalog.requestSuccess.value != true) {
                Toast.makeText(MAIN, getString(R.string.network_error), Toast.LENGTH_SHORT).show()
            }
            binding.srl.isRefreshing = false
        }
    }

    private fun showInfoAboutProducts() {
        vmCatalog.products.observe(this) { products ->
            binding.rvProducts.adapter = catalogAdapter
            catalogAdapter.itemsProduct = products
        }
        vmCatalog.getProducts()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}