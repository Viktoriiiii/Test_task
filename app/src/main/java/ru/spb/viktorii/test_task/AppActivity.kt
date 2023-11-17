package ru.spb.viktorii.test_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.spb.viktorii.test_task.databinding.ActivityAppBinding
import ru.spb.viktorii.test_task.utils.MAIN

class AppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Test_task)
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAIN = this

        navController = Navigation.findNavController(this, R.id.fragment_container)
        binding.ivBack.setOnClickListener {
            onSupportNavigateUp()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        // Обрабатываем возврат на предыдущий фрагмент при нажатии на кнопку "Назад" в панели инструментов
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun changeItemsInToolbar(title: String, backButtonVisibility: Boolean) {
        binding.ivBack.visibility = if (backButtonVisibility) View.VISIBLE else View.GONE
        binding.tvTitle.text = title
    }
}