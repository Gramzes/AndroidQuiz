package com.gramzin.androidquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gramzin.androidquiz.databinding.FragmentWinBinding

class WinFragment : Fragment() {
    lateinit var binding: FragmentWinBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWinBinding.inflate(inflater, container, false)

        binding.nextBtn.setOnClickListener {
            findNavController().popBackStack(R.id.mainFragment, false)
        }

        return binding.root
    }

}