package com.shevyakhov.features.login

import androidx.fragment.app.Fragment
import com.shevyakhov.features.login.presentation.LoginFragment
import com.shevyakhov.libraries.navigation.FragmentDestination

object LoginDestination : FragmentDestination {

	override fun createInstance(): Fragment =
		LoginFragment()
}