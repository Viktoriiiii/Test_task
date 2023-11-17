package ru.spb.viktorii.test_task.catalog_screen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.spb.viktorii.test_task.R
import ru.spb.viktorii.test_task.catalog_screen.model.Product
import ru.spb.viktorii.test_task.utils.BASE_URL_FOR_IMAGE
import ru.spb.viktorii.test_task.utils.MAIN

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    var itemsProduct = listOf<Product>()
        set(value) {
            val callback = CommonCallbackImpl(
                oldItems = field,
                newItems = value,
                { oldItem: Product, newItem: Product -> oldItem.gcode == newItem.gcode })
            field = value
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
        }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productContainer: CardView = itemView.findViewById(R.id.products_container)
        var productArticle: TextView = itemView.findViewById(R.id.tv_product_article)
        val productName: TextView = itemView.findViewById(R.id.tv_product_name)
        val productPrice: TextView = itemView.findViewById(R.id.tv_product_price)
        val productPhoto: ImageView = itemView.findViewById(R.id.iv_product_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_product,
            parent, false
        )
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = itemsProduct[position]
        holder.productArticle.text = buildString {
            append(MAIN.getString(R.string.article))
            append(" ")
            append(item.gcode)
        }
        holder.productName.text = item.name
        holder.productPrice.text = buildString {
            append(item.price)
            append(" ₽ / ")
            append(item.units)
        }

        if (item.img_preview != "") {
            Glide.with(MAIN)
                .load("$BASE_URL_FOR_IMAGE${item.img_preview}")
                .into(holder.productPhoto)
        } else {
            holder.productPhoto.setImageResource(R.drawable.logo)
        }
    }

    override fun getItemCount() = itemsProduct.size
}