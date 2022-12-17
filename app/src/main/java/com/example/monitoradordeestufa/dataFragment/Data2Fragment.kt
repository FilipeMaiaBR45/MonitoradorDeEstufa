package com.example.monitoradordeestufa.dataFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.monitoradordeestufa.R
import com.example.monitoradordeestufa.databinding.FragmentData2Binding
import com.example.monitoradordeestufa.databinding.FragmentDataBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Data2Fragment : Fragment() {

    private lateinit var binding: FragmentData2Binding
    val viewmodel: DataViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentData2Binding.inflate(layoutInflater, container, false)
        binding.viewmodel = viewmodel

        viewmodel.getData()



        viewmodel.datas.observe(viewLifecycleOwner, Observer {
            binding.circularProgressIndicator2.progress = it.sensorTemp
            binding.textView3.text = it.sensorTemp.toString() + "%"
            viewmodel.getData()

        })




        // Inflate the layout for this fragment
        return binding.root
    }

}