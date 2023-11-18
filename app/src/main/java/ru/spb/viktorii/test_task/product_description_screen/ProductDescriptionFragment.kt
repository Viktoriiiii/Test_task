package ru.spb.viktorii.test_task.product_description_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.BundleCompat.getParcelable
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import ru.spb.viktorii.test_task.R
import ru.spb.viktorii.test_task.databinding.FragmentProductDescriptionBinding
import ru.spb.viktorii.test_task.model.Product
import ru.spb.viktorii.test_task.utils.BASE_URL_FOR_IMAGE
import ru.spb.viktorii.test_task.utils.MAIN

class ProductDescriptionFragment : Fragment() {

    private var _binding: FragmentProductDescriptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MAIN.changeItemsInToolbar(getString(R.string.description), true)
        setDataAboutProduct()
    }

    private fun setDataAboutProduct() {
        val receivedProduct = arguments?.let {
            getParcelable(it, "selectedProduct", Product::class.java)
        }
        if (receivedProduct != null) {
            binding.tvProductArticle.text = buildString {
                append(MAIN.getString(R.string.article))
                append(" ")
                append(receivedProduct.gcode)
            }
            binding.tvProductName.text = receivedProduct.name
            binding.tvProductPrice.text = buildString {
                append(receivedProduct.price)
                append(" ₽ / ")
                append(receivedProduct.units)
            }
            if (receivedProduct.img_preview != "") {
                Glide.with(MAIN)
                    .load("$BASE_URL_FOR_IMAGE${receivedProduct.img_preview}")
                    .into(binding.ivProductPhoto)
            } else {
                binding.ivProductPhoto.setImageResource(R.drawable.logo)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}