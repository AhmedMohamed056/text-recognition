package com.cis.bscars

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.cis.bscars.databinding.FragmentCustomAdapterBinding
import com.cis.bscars.model.Mydataclass
import java.time.LocalDate

class FragmentCustomAdapter : Fragment() {
    private lateinit var binding: FragmentCustomAdapterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCustomAdapterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setuplistview()

    }

    private fun setuplistview() {
        val adapter=mycustomadapter(requireContext(),setupdatasource())
        binding.customlistview.adapter=adapter
        binding.customlistview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(context,"exam is clicked",Toast.LENGTH_LONG).show()
        }
    }

    private fun setupdatasource():List<Mydataclass> {
        val exam_id= arrayOf<String>("01558625455gxchb","2025343512fcbsh","654548731bhdbj","1454215485jnjjf","01558625455gxchb","2025343512fcbsh","654548731bhdbj","1454215485jnjjf","01558625455gxchb","2025343512fcbsh","654548731bhdbj","1454215485jnjjf")
        val exam_date= arrayOf<String>("01558625455gxchb","2025343512fcbsh","654548731bhdbj","1454215485jnjjf","01558625455gxchb","2025343512fcbsh","654548731bhdbj","1454215485jnjjf","01558625455gxchb","2025343512fcbsh","654548731bhdbj","1454215485jnjjf")
        val listofexaminfo= mutableListOf<Mydataclass>()
        for (i in exam_id.indices){
            listofexaminfo.add(Mydataclass(exam_id[i],exam_date[i]))
        }
        return listofexaminfo
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentCustomAdapter().apply {
                arguments = Bundle().apply {

                }
            }
    }
}