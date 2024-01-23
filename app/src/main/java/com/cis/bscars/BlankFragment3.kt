package com.cis.bscars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.cis.bscars.databinding.FragmentBlank3Binding


class BlankFragment3 : Fragment() {
    private lateinit var binding: FragmentBlank3Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentBlank3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gofragment4.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_blankFragment3_to_blankFragment4)
            val mainactivity= activity as MainActivity
            mainactivity.hideNavbar()
            mainactivity.showactionbar()

        }
        binding.gofragmentcustomadapter.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_blankFragment3_to_fragmentCustomAdapter)
            val mainactivity= activity as MainActivity
            mainactivity.hideNavbar()

        }
        binding.gofragmentrecyclerview.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_blankFragment3_to_recyclerviewFragment)
            val mainactivity= activity as MainActivity
            mainactivity.hideNavbar()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment3().apply {
                arguments = Bundle().apply {

                }
            }
    }
}