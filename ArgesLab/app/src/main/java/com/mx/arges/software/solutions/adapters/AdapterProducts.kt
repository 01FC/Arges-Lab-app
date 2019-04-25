package com.mx.arges.software.solutions.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mx.arges.software.solutions.R
import com.mx.arges.software.solutions.beans.ExtraProducts

class AdapterProducts(var prods: ArrayList<ExtraProducts>) : RecyclerView.Adapter<ProductsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductsHolder(layoutInflater.inflate(R.layout.product_item, parent, false))
    }

    override fun getItemCount(): Int {
        return prods.size
    }

    override fun onBindViewHolder(holder: ProductsHolder, position: Int) {
        holder.bind(prods.get(position))
    }
}

class ProductsHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
    var mImage: ImageView
    var mText: TextView
    var mView: View
    var mCard: CardView
    lateinit var mProduct: ExtraProducts

    init {
        mView = v
        mImage = mView.findViewById(R.id.item_products_image)
        mText = mView.findViewById(R.id.item_products_text)
        mCard = mView.findViewById(R.id.item_product_card)
        mCard.setOnClickListener(this)
    }

    fun bind(prod: ExtraProducts) {
        mProduct = prod
        mText.text = prod.title
        when (prod.img) {
            "0" -> {
                mImage.setImageResource(R.drawable.legal_prod_white)
            }
            "1" -> {
                mImage.setImageResource(R.drawable.marca_prod_white)
            }
            "2" -> {
                mImage.setImageResource(R.drawable.finance_prod_white)
            }
            "3" -> {
                mImage.setImageResource(R.drawable.perfil_prod_white)
            }
            "4" -> {
                mImage.setImageResource(R.drawable.registro_prod_white)
            }
            "5" -> {
                mImage.setImageResource(R.drawable.terms_prod_white)
            }
            "6" -> {
                mImage.setImageResource(R.drawable.support_white)
            }
            "7" -> {
                mImage.setImageResource(R.drawable.externa_prod_white)
            }
            "8" -> {
                mImage.setImageResource(R.drawable.cod_prod_white)
            }
            "9" -> {
                mImage.setImageResource(R.drawable.paquetes_prod_white)
            }
        }

    }

    fun alertInformation(producto: ExtraProducts) {
        val dialogLayoutInflater = LayoutInflater.from(mView.context)
        val dialogLayout = dialogLayoutInflater.inflate(R.layout.alert_custom_info, null)
        val mImageDialog: ImageView
        val mTextDescription: TextView
        val dialog = AlertDialog.Builder(mView.context)

        with(dialog) {
            setTitle(producto.title)
            setView(dialogLayout)
            setPositiveButton("OK") { _, _ ->
            }
        }

        mImageDialog = dialogLayout.findViewById(R.id.alert_image)
        mImageDialog.visibility = View.GONE
        mTextDescription = dialogLayout.findViewById(R.id.alert_text)
        mTextDescription.text = producto.description

        dialog.show()
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.item_product_card -> {
                alertInformation(mProduct)
            }
        }
    }
}