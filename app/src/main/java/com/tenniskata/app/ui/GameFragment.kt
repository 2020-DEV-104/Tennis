package com.tenniskata.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tenniskata.app.R
import com.tenniskata.app.databinding.GameFragmentBinding
import com.tenniskata.app.viewmodel.GameViewModel

class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel
    private lateinit var binding: GameFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.game_fragment, container, false
        )
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        binding.viewModel = viewModel

        return binding.root
    }

}