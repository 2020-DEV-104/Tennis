package com.tenniskata.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tenniskata.app.R
import com.tenniskata.app.databinding.FragmentWinnerBinding
import com.tenniskata.app.viewmodel.WinnerViewModel
import com.tenniskata.app.viewmodel.WinnerViewModelFactory

class WinnerFragment : Fragment() {

    private lateinit var viewModel: WinnerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWinnerBinding = DataBindingUtil.inflate(
            inflater, R.layout.winner_fragment, container, false
        )

        val arguments = arguments?.let { WinnerFragmentArgs.fromBundle(it) }

        val playerName = arguments?.playerName ?: ""

        val viewModelFactory = WinnerViewModelFactory(
            requireActivity().application,
            playerName
        )

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(WinnerViewModel::class.java)

        binding.viewModel = viewModel

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WinnerViewModel::class.java)
    }

}