package com.example.ciceksepeti.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ciceksepeti.R
import com.example.ciceksepeti.listeners.OnMainListeners
import com.example.ciceksepeti.models.DynamicFilter
import com.example.ciceksepeti.models.MainFilter
import com.example.ciceksepeti.models.Product

class CategoryListAdapter (
    private var dataNetModel: ArrayList<DynamicFilter>,
    private val listener: OnMainListeners?
) :
    RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryListAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryListAdapter.ViewHolder, position: Int) {
        val getDataModel = dataNetModel[position]
        holder.txtCategoryName.text = getDataModel.name

        holder.constraintlayoutCategory.setOnClickListener {
            listener!!.clickItemCategory(getDataModel)
        }
    }

    override fun getItemCount(): Int {
        return dataNetModel.size
    }


    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val txtCategoryName: TextView
        val constraintlayoutCategory : ConstraintLayout

        init {
            txtCategoryName = mView.findViewById<View>(R.id.txtCategoryName) as TextView
            constraintlayoutCategory = mView.findViewById(R.id.constraintlayoutCategory)



        }
    }

}