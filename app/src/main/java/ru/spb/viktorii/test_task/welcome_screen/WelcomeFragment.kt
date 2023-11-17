package ru.spb.viktorii.test_task.welcome_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.spb.viktorii.test_task.R
import ru.spb.viktorii.test_task.databinding.FragmentWelcomeBinding
import ru.spb.viktorii.test_task.utils.MAIN

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mbToCatalog.setOnClickListener {
            MAIN.navController.navigate(R.id.action_welcomeFragment_to_catalogFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        MAIN.changeItemsInToolbar(getString(R.string.app_name), false)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}