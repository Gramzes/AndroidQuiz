package com.gramzin.androidquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gramzin.androidquiz.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    lateinit var binding: FragmentQuestionBinding
    val viewModel: QuestionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        binding.question = viewModel.questions[viewModel.currentQuestion]

        binding.nextBtn.setOnClickListener(listener)
        return binding.root
    }

    var listener = OnClickListener{
        if (!checkAnswer()){
            findNavController().navigate(R.id.action_questionFragment_to_lossFragment)
            return@OnClickListener
        }
        viewModel.currentQuestion++
        if (viewModel.currentQuestion > viewModel.questions.size - 1){
            findNavController().navigate(R.id.action_questionFragment_to_winFragment)
        }
        else {
            binding.question = viewModel.questions[viewModel.currentQuestion]
        }
    }

    private fun checkAnswer(): Boolean{
        var answerId = 0
        when (binding.radioGroup.checkedRadioButtonId){
            R.id.first_quest -> answerId = 0
            R.id.second_quest -> answerId = 1
            R.id.third_quest -> answerId = 2
        }
        return binding.question!!.variants.values.toList()[answerId]
    }

}