package com.example.kaspi.ui.store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kaspi.R
import com.example.kaspi.model.Product
import com.squareup.picasso.Picasso

class ProductAdapter(private val products: List<Product>, private val onAddToCartClick: (Product) -> Unit) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.ivProductImage)
        val productName: TextView = itemView.findViewById(R.id.tvProductName)
        val productPrice: TextView = itemView.findViewById(R.id.tvProductPrice)
        val productRating: TextView = itemView.findViewById(R.id.tvProductRating)
        val addToCartButton: TextView = itemView.findViewById(R.id.btnAddToCart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.productName.text = product.name
        holder.productPrice.text = "₽${product.price}"
        holder.productRating.text = "Рейтинг: ${product.rating}"

        // Загрузка изображения
        Picasso.get().load(product.imageUrl).into(holder.productImage)

        // Обработка кнопки добавления в корзину
        holder.addToCartButton.setOnClickListener {
            onAddToCartClick(product)
        }
    }

    override fun getItemCount(): Int = products.size
}
