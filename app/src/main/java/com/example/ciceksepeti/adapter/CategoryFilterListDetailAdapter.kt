package com.example.ciceksepeti.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.ciceksepeti.MainActivity
import com.example.ciceksepeti.R
import com.example.ciceksepeti.listeners.OnMainListeners
import com.example.ciceksepeti.models.Value
import com.example.ciceksepeti.utils.SharedPrefsHelper
import com.example.ciceksepeti.viewmodel.MainViewModel

class CategoryFilterListDetailAdapter(
    private var dataNetModel: ArrayList<Value>?,
    private val listener: OnMainListeners?,
    private  val detailId : Int
) :
    RecyclerView.Adapter<CategoryFilterListDetailAdapter.ViewHolder>() {
    private var isChecked = false
    var mainViewModel: MainViewModel? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryFilterListDetailAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category_list_detail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryFilterListDetailAdapter.ViewHolder, position: Int) {
        val getDataModel = dataNetModel?.get(position)
        holder.txtCategoryDetailName.text = getDataModel!!.name


        isChecked = false
        holder.checkBoxButton.setOnClickListener {
            if (isChecked) {
                holder.checkBoxButton.setBackgroundResource(R.drawable.ic_tick_gray)
                isChecked = false
            }else{
                var detailValue = getDataModel.detailValueId.toString()
                getDataModel.selected = true
                holder.checkBoxButton.setBackgroundResource(R.drawable.ic_tick_blue)
                isChecked = true

            }
        }

        holder.constraintlayoutCategoryDetailName.setOnClickListener {
            listener!!.detailFilter()
        }
    }

    override fun getItemCount(): Int {
        return dataNetModel!!.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val txtCategoryDetailName: TextView
        val checkBoxButton: ImageButton
        val constraintlayoutCategoryDetailName : ConstraintLayout

        init {
            txtCategoryDetailName = mView.findViewById<View>(R.id.txtCategoryDetailName) as TextView
            constraintlayoutCategoryDetailName = mView.findViewById(R.id.constraintlayoutCategoryDetailName)
            checkBoxButton = mView.findViewById(R.id.checkBoxButtonContract)
        }
    }

}
