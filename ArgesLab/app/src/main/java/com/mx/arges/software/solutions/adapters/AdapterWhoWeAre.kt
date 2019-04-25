package com.mx.arges.software.solutions.adapters

import android.app.AlertDialog
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.mx.arges.software.solutions.R
import com.mx.arges.software.solutions.beans.Hacemos
import com.squareup.picasso.Picasso
import java.util.ArrayList

class AdapterWhoWeAre(var queHacemosList: ArrayList<Hacemos>) : RecyclerView.Adapter<QueHacemosHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueHacemosHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return QueHacemosHolder(layoutInflater.inflate(R.layout.home_item, parent, false))
    }

    override fun getItemCount(): Int {
        return queHacemosList.size
    }

    override fun onBindViewHolder(holder: QueHacemosHolder, position: Int) {
        holder.bind(queHacemosList.get(position))
    }
}

class QueHacemosHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

    var mImage: ImageView
    var mText: TextView
    var mCard: MaterialCardView
    var mView: View
    lateinit var mHacemos: Hacemos

    init {
        mView = v
        mCard = v.findViewById(R.id.item_home_card)
        mImage = v.findViewById(R.id.item_home_info_img)
        mText = v.findViewById(R.id.item_home_que_hacemos)

        mCard.setOnClickListener(this)
    }

    fun bind(hacemos: Hacemos) {
        mHacemos = hacemos
        mText.text = hacemos.description
        when (hacemos.picture) {
            "0" -> {
                mImage.setImageResource(R.drawable.creativity_white)
            }
            "1" -> {
                mImage.setImageResource(R.drawable.design_white)
            }
            "2" -> {
                mImage.setImageResource(R.drawable.cellphone_white)
            }
            "3" -> {
                mImage.setImageResource(R.drawable.planning_white)
            }
            "4" -> {
                mImage.setImageResource(R.drawable.legal_white)
            }
            "5" -> {
                mImage.setImageResource(R.drawable.support_white)
            }
            "6" -> {
                mImage.setImageResource(R.drawable.appstore_white)
            }
            "7" -> {
                mImage.setImageResource(R.drawable.dashboard_white)
            }
        }
    }

    fun alertInformation(hacemos: Hacemos) {
        val dialogLayoutInflater = LayoutInflater.from(mView.context)
        val dialogLayout = dialogLayoutInflater.inflate(R.layout.alert_custom_info,null)
        val mImageDialog: ImageView
        val mTextDescription: TextView
        val dialog = AlertDialog.Builder(mView.context)

        with(dialog) {
            setTitle(hacemos.fullTitle)
            setView(dialogLayout)
            setPositiveButton("OK") { _, _ ->
            }
        }

        mImageDialog = dialogLayout.findViewById(R.id.alert_image)
        mTextDescription = dialogLayout.findViewById(R.id.alert_text)
        mTextDescription.text = hacemos.fullDescription

        when (hacemos.picture) {
            "0" -> {
                mImageDialog.setImageResource(R.drawable.creativity_info)
            }
            "1" -> {
                mImageDialog.setImageResource(R.drawable.design_info)
            }
            "2" -> {
                mImageDialog.setImageResource(R.drawable.cellphone_info)
            }
            "3" -> {
                mImageDialog.setImageResource(R.drawable.planning_info)
            }
            "4" -> {
                mImageDialog.setImageResource(R.drawable.legal_info)
            }
            "5" -> {
                mImageDialog.setImageResource(R.drawable.support_info)
            }
            "6" -> {
                mImageDialog.setImageResource(R.drawable.appstore_info)
            }
            "7" -> {
                mImageDialog.setImageResource(R.drawable.dashboard_info)
            }

        }
        dialog.show()
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.item_home_card -> {
                //Toast.makeText(p0.context, "Card clicked: \n${mText.text}", Toast.LENGTH_SHORT).show()
                alertInformation(mHacemos)
            }
        }
    }

}
