// BaseFragment.kt
package com.example.kaspi.ui.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

open class BaseFragment : Fragment() {
    protected fun setupToolbar(toolbar: Toolbar) {
        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}