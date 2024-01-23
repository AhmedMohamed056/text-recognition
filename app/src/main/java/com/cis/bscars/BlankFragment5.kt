package com.cis.bscars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.cis.bscars.databinding.FragmentBlank5Binding


class BlankFragment5 : Fragment() {
    private lateinit var binding: FragmentBlank5Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentBlank5Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {


        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment5().apply {
                arguments = Bundle().apply {

                }
            }
    }
}