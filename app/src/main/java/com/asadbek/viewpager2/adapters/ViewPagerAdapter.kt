package com.asadbek.viewpager2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.asadbek.viewpager2.R

class ViewPagerAdapter(private var otk:List<String>,private var theme:List<String>,private var about:List<String>):RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val itemOtkazibYuborishTextView:TextView = itemView.findViewById(R.id.text_otkazbYuborish)
        val itemTheme:TextView = itemView.findViewById(R.id.text_theme)
        val itemAbout:TextView = itemView.findViewById(R.id.text_about)
        val itemBackground:View = itemView.findViewById(R.id.backItem)
        val itemCard:View = itemView.findViewById(R.id.otkazibYuborish)

        init {
            itemAbout.setOnClickListener {
                val position = adapterPosition
                Toast.makeText(itemView.context, "Siz buni bosdingiz: #${position+1}", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pager,parent,false))
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        holder.itemOtkazibYuborishTextView.text = otk[position]
        holder.itemTheme.text = theme[position]
        holder.itemCard.setOnClickListener {
            holder.itemBackground.setBackgroundResource(R.drawable.earphone)
            holder.itemTheme.text = theme.last()
            holder.itemAbout.text = about.last()
        }
        holder.itemAbout.text = about[position]
        when(theme[position]){
            "Xush kelibsiz" -> holder.itemBackground.setBackgroundResource(R.drawable.earphone)
            "Hikoyalar dunyosi" -> holder.itemBackground.setBackgroundResource(R.drawable.earphones_2)
            "Kitob ortidan..." -> holder.itemBackground.setBackgroundResource(R.drawable.earphones_3)
            "Bizga qo`shiling" -> holder.itemBackground.setBackgroundResource(R.drawable.hom1)

        }
    }

    override fun getItemCount(): Int {
        return theme.size

    }

}