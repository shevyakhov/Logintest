package com.shevyakhov.features.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.shevyakhov.features.login.R
import com.shevyakhov.features.login.databinding.FragmentLoginBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

	private val viewModel: LoginViewModel by viewModel()
	private var _binding: FragmentLoginBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?,
	): View {
		_binding = FragmentLoginBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val scope = viewLifecycleOwner.lifecycleScope

		viewModel.uiState.onEach { state ->
			when (state) {
				UiState.Content  -> renderContent()
				is UiState.Error -> renderError()
			}
		}.launchIn(scope)

		binding.buttonLogin.setOnClickListener {
			val login = binding.loginInput.text.toString()
			val password = binding.passwordInput.text.toString()
			viewModel.login(login, password)
		}
	}

	private fun renderContent() {
		binding.loginLayout.error = null
		binding.passwordLayout.error = null
	}

	private fun renderError() {
		binding.loginLayout.error = getString(R.string.error)
		binding.passwordLayout.error = getString(R.string.error)
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}
