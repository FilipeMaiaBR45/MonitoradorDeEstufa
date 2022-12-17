package com.example.monitoradordeestufa.dataFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.monitoradordeestufa.R
import com.example.monitoradordeestufa.databinding.FragmentDataBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch


@AndroidEntryPoint
class DataFragment : Fragment() {

    private lateinit var binding: FragmentDataBinding
    val viewmodel: DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDataBinding.inflate(layoutInflater, container, false)
        binding.viewmodel = viewmodel


        viewmodel.getData()



        viewmodel.datas.observe(viewLifecycleOwner, Observer {
            binding.progressBar.progress = it.sensorLdr
            binding.textViewPercent.text = it.sensorLdr.toString() + "%"
            viewmodel.getData()

        })




        return binding.root
    }


}