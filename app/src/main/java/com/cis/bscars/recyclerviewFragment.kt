package com.cis.bscars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.cis.bscars.databinding.FragmentRecyclerviewBinding
import com.cis.bscars.model.Mydataclass

class recyclerviewFragment : Fragment() {
    private lateinit var adapter: recyclerViewAdapter
    private lateinit var binding: FragmentRecyclerviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentRecyclerviewBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setuprecyclerview()
        setupdatasource()
    }

    private fun setuprecyclerview() {
    //Gridview
    // binding.recyclerView.layoutManager=GridLayoutManager(context,2)
        //listview
        binding.recyclerView.layoutManager=LinearLayoutManager(context)
        adapter=recyclerViewAdapter(requireContext())
        binding.recyclerView.adapter=adapter
    }

    private fun setupdatasource() {
        val exam_id= arrayOf<String>("01558625455gxchb","2025343512fcbsh","654548731bhdbj","1454215485jnjjf","01558625455gxchb","2025343512fcbsh","654548731bhdbj","1454215485jnjjf","01558625455gxchb","2025343512fcbsh","654548731bhdbj","1454215485jnjjf")
        val exam_date= arrayOf<String>("01558625455gxchb","2025343512fcbsh","654548731bhdbj","1454215485jnjjf","01558625455gxchb","2025343512fcbsh","654548731bhdbj","1454215485jnjjf","01558625455gxchb","2025343512fcbsh","654548731bhdbj","1454215485jnjjf")
        val listofexaminfo= mutableListOf<Mydataclass>()
        for (i in exam_id.indices){
            listofexaminfo.add(Mydataclass(exam_id[i],exam_date[i]))
        }
       if (::adapter.isInitialized)
           adapter.setData(listofexaminfo)
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            recyclerviewFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}