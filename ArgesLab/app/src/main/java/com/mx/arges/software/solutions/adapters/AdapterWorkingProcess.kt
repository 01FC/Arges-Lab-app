package com.mx.arges.software.solutions.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.mx.arges.software.solutions.R
import com.mx.arges.software.solutions.beans.WorkProcess

class AdapterWorkingProcess(var processList: ArrayList<WorkProcess>) : RecyclerView.Adapter<WorkProcessHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkProcessHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WorkProcessHolder(layoutInflater.inflate(R.layout.work_process_item, parent, false))
    }

    override fun getItemCount(): Int {
        return processList.size
    }

    override fun onBindViewHolder(holder: WorkProcessHolder, position: Int) {
        holder.bind(processList[position])
    }
}

class WorkProcessHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
    val mView: View = v
    val mImage: ImageView
    val mTitle: TextView
    val mDescr: TextView
    val mCardView: MaterialCardView

    init {
        mImage = mView.findViewById(R.id.item_work_process_icon)
        mTitle = mView.findViewById(R.id.item_work_process_title)
        mDescr = mView.findViewById(R.id.item_work_process_description)
        mCardView = mView.findViewById(R.id.item_work_process_card)
        mCardView.setOnClickListener(this)
    }

    fun bind(step: WorkProcess?) {
        //if (step?.isHeader!!) {
            mTitle.text = step?.title
            mDescr.text = step?.description
            when (step?.icon) {
                "0" -> {
                    mImage.setImageResource(R.drawable.contact_work)
                }
                "1" -> {
                    mImage.setImageResource(R.drawable.validat_work)
                }
                "2" -> {
                    mImage.setImageResource(R.drawable.desic_work)
                }
                "3" -> {
                    mImage.setImageResource(R.drawable.implem_work)
                }
                "4" -> {
                    mImage.setImageResource(R.drawable.retro_work)
                }
                "5" -> {
                    mImage.setImageResource(R.drawable.revi_work)
                }
                "6" -> {
                    mImage.setImageResource(R.drawable.publi_work)
                }
                else -> {
                    //do nothing
                    mCardView.visibility = View.GONE
                }
            }
        /*} else {

        }*/
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.item_work_process_card -> {
                //do something
            }
        }
    }

}