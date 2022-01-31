package com.example.ciceksepeti.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ciceksepeti.R
import com.example.ciceksepeti.listeners.OnMainListeners
import com.example.ciceksepeti.models.Product
import com.example.ciceksepeti.models.Result

class FlowersListAdapter(
    private var dataNetModel: ArrayList<Product>,
    private val listener: OnMainListeners?
) :
    RecyclerView.Adapter<FlowersListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FlowersListAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_choose_flowers, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlowersListAdapter.ViewHolder, position: Int) {
        val getDataModel = dataNetModel[position]

        holder.txtFlowersName.text = getDataModel.name


         holder.txtFlowersPrice.text = getDataModel.price!!.current.toString() + "TL"

         val uri: String = getDataModel.image.toString()
         Glide.with(holder.itemView.context).load(uri).into(holder.imageViewFlowers)

         var oldAmount = getDataModel.price!!.old
         if (oldAmount != null && oldAmount > 0 ) {
             holder.txtDiscountAmount.text = getDataModel.price!!.old.toString() + "TL"
         }else{
             holder.txtDiscountAmount.visibility = View.GONE
         }

         holder.cardViewDetail.setOnClickListener {
             listener!!.clickItemDetail(getDataModel)
         }
    }

    override fun getItemCount(): Int {
      return dataNetModel.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val txtFlowersName: TextView
        val imageViewFlowers: ImageView
        val txtFlowersPrice : TextView
        val txtDiscountAmount: TextView
        val cardViewDetail : ConstraintLayout

        init {
            txtFlowersName = mView.findViewById<View>(R.id.nameFlowers) as TextView
            imageViewFlowers =mView.findViewById(R.id.imageViewFlowers)
            txtFlowersPrice = mView.findViewById(R.id.priceFlowers)
            txtDiscountAmount = mView.findViewById(R.id.txtDiscountAmount)
            cardViewDetail = mView.findViewById(R.id.cardViewDetail)
        }
    }

}