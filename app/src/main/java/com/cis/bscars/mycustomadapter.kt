package com.cis.bscars

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.cis.bscars.databinding.ShowtextcustomdeBinding
import com.cis.bscars.model.Mydataclass

class mycustomadapter(private val context: Context,private val listofexaminfo:List<Mydataclass>): BaseAdapter() {
    override fun getCount(): Int {
        return listofexaminfo.size
    }

    override fun getItem(position: Int): Mydataclass {
        return listofexaminfo[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater=LayoutInflater.from(context)
        val binding=ShowtextcustomdeBinding.inflate(inflater,parent,false)
        val idexamview=binding.idexamview
        val dateexamview=binding.dateexamview
        //val view:View=inflater.inflate(R.layout.showtextcustomde,parent,false)
        val mydataclass=getItem(position)
        //val dateexamview=view.findViewById<TextView>(R.id.dateexamview)
        //val idexamview=view.findViewById<TextView>(R.id.idexamview)
        idexamview.text=mydataclass.examid
        dateexamview.text=mydataclass.examdate
        return binding.root

    }

}