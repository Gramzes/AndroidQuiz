package com.gramzin.androidquiz

import android.content.res.ColorStateList
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.gramzin.androidquiz.databinding.ActivityMainBinding
import com.gramzin.androidquiz.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startGameBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_questionFragment)
        }

        binding.text.apply {
            setBackgroundResource(R.drawable.back_anim)
            val back = (background as AnimationDrawable)
            back.setEnterFadeDuration(2000)
            back.setExitFadeDuration(2000)
            back.start()
        }

        AnimationUtils.loadAnimation(context, R.anim.btn_scale).also {
            binding.startGameBtn.startAnimation(it)
        }
    }

}