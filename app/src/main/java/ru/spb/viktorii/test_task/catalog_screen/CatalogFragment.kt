package ru.spb.viktorii.test_task.catalog_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.spb.viktorii.test_task.R
import ru.spb.viktorii.test_task.databinding.FragmentCatalogBinding
import ru.spb.viktorii.test_task.utils.MAIN

class CatalogFragment : Fragment() {

    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!

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
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}