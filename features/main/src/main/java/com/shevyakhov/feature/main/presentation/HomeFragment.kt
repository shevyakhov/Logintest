package com.shevyakhov.feature.main.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.shevyakhov.feature.main.databinding.FragmentHomeBinding
import com.shevyakhov.feature.main.presentation.adapter.PaymentsAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

	private val viewModel: HomeViewModel by viewModel()
	private var _binding: FragmentHomeBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?,
	): View {
		_binding = FragmentHomeBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val scope = viewLifecycleOwner.lifecycleScope

		val adapter = PaymentsAdapter {
			Toast.makeText(requireContext(), "${it.title}", Toast.LENGTH_SHORT).show()
		}
		binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
		binding.recyclerView.adapter = adapter

		binding.logout.setOnClickListener {
			viewModel.logout()
		}

		viewModel.getPayments()

		viewModel.uiState.onEach { state ->
			when (state) {
				UiState.Initial    -> Unit
				is UiState.Error   -> renderError(state)
				is UiState.Content -> renderContent(state, adapter)

			}
		}.launchIn(scope)
	}

	private fun renderContent(state: UiState.Content, adapter: PaymentsAdapter) {
		adapter.updateData(state.data)
	}

	private fun renderError(state: UiState.Error) {
		Toast.makeText(requireContext(), state.e.localizedMessage, Toast.LENGTH_SHORT).show()
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}