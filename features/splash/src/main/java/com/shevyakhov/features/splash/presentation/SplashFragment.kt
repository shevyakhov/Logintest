package com.shevyakhov.features.splash.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shevyakhov.feature.splash.R
import com.shevyakhov.feature.splash.databinding.FragmentSplashBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : Fragment() {

	private val viewModel: SplashViewModel by viewModel()
	private var _binding: FragmentSplashBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?,
	): View {
		_binding = FragmentSplashBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val sharedPreferences = requireContext().getSharedPreferences(getString(R.string.logged_shared_pref), Context.MODE_PRIVATE)
		val isLogged = sharedPreferences.getBoolean(getString(R.string.is_logged), false)
		viewModel.handleNavigation(isLogged)
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}