package com.cis.bscars

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import com.cis.bscars.databinding.FragmentBlank2Binding
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter


class BlankFragment2 : Fragment() {
    private lateinit var binding: FragmentBlank2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBlank2Binding.inflate(inflater,container,false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.getdatetextview.text= LocalDate.now().toString()
        val formater=DateTimeFormatter.ofPattern("HH:mm")
        binding.gettimetextview.text=LocalTime.now().format(formater).toString()
        listviewshow()
    }

    private fun listviewshow() {
        val mydata= arrayOf<String>("Ahmed Mohamed","Nor Mostafa","Aya Rayyan","Ahmed Mohamed","Nor Mostafa","Aya Rayyan","Ahmed Mohamed","Nor Mostafa","Aya Rayyan","Ahmed Mohamed","Nor Mostafa","Aya Rayyan","Ahmed Mohamed","Nor Mostafa","Aya Rayyan")
        val myadapter= ArrayAdapter<String>(requireContext(),R.layout.showtextde,mydata)
        binding.mylist.adapter=myadapter
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment2().apply {
                arguments = Bundle().apply {

                }
            }
    }
}