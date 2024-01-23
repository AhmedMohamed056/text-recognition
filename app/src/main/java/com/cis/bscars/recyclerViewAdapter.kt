package com.cis.bscars

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cis.bscars.databinding.ShowtextcustomdeBinding
import com.cis.bscars.model.Mydataclass
import java.util.zip.Inflater

class recyclerViewAdapter(private val context: Context):RecyclerView.Adapter<recyclerViewAdapter.showtextcustomdeVH>() {
    //inner class that represent showtextcustomde.xml file
    // initialize global variable for setData() because his parameter is local inside it
    private var list= mutableListOf<Mydataclass>()
    //inner class showtextcustomdeVH(itemView:View):RecyclerView.ViewHolder(itemView){
    inner class showtextcustomdeVH(itemView:ShowtextcustomdeBinding):RecyclerView.ViewHolder(itemView.root){
        //var idexamview:TextView?=null
        //var dateexamview:TextView?=null
        //init {
        val idexamview=itemView.idexamview
        val dateexamview=itemView.dateexamview
            //idexamview=itemView.findViewById<TextView>(R.id.idexamview)
            //dateexamview=itemView.findViewById<TextView>(R.id.dateexamview)
       // }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): showtextcustomdeVH {
       //val view= LayoutInflater.from(context).inflate(R.layout.showtextcustomde,parent,false)
        //return showtextcustomdeVH(view)
        //using binding
        val binding=ShowtextcustomdeBinding.inflate(LayoutInflater.from(context),parent,false)
        return showtextcustomdeVH(binding)
    }
    //Bind data on has place in designe like set text in textview
    override fun onBindViewHolder(holder: showtextcustomdeVH, position: Int) {
        val item=list[position]
        holder.idexamview.text=item.examid
        holder.dateexamview.text=item.examdate
        holder.itemView.setOnClickListener {
            Toast.makeText(context, item.examid,Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(listofexaminfo: MutableList<Mydataclass>) {
        list.addAll(listofexaminfo)
        notifyDataSetChanged()//important for referesh adapter when recieve new data
    }
}