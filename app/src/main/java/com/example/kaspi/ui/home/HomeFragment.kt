package com.example.kaspi.ui.home

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.view.animation.DecelerateInterpolator
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kaspi.R
import com.example.kaspi.databinding.FragmentHomeBinding

class SearchManager {
    private val searchItems = mapOf(
        "магазин" to R.id.action_navigation_home_to_storeFragment,
        "устройства" to R.id.action_navigation_home_to_devicesFragment,
        "документы" to R.id.action_navigation_home_to_documentsFragment,
        "переводы" to R.id.action_navigation_home_to_transactionsFragment,
        "статьи" to R.id.action_navigation_home_to_articlesFragment,
        "travel" to R.id.action_navigation_home_to_travelFragment,
        "госуслуги" to R.id.action_navigation_home_to_govermentFragment,
        "статистика" to R.id.action_navigation_home_to_statisticsFragment,
        "каспи" to R.id.action_navigation_home_to_kaspiFragment,
        "халык" to R.id.action_navigation_home_to_halykFragment,
        "амазон" to R.id.action_navigation_home_to_amazonFragment,
        "магнум" to R.id.action_navigation_home_to_magnumFragment
    )

    fun findNavigationAction(query: String): Int? {
        return searchItems[query.lowercase().trim()]
    }
}

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val searchManager = SearchManager()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupButtonClickListeners()
        setupButtonShadows()
        setupSearchFunctionality()

        return root
    }

    private fun setupSearchFunctionality() {
        binding.searchEditText.apply {
            setOnEditorActionListener { textView, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch(textView.text.toString())
                    true
                } else {
                    false
                }
            }

            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    s?.toString()?.let { query ->
                        if (query.length >= 3) {
                            performSearch(query)
                        }
                    }
                }
            })
        }
    }

    private fun performSearch(query: String) {
        val navigationAction = searchManager.findNavigationAction(query)
        navigationAction?.let { actionId ->
            try {
                findNavController().navigate(actionId)
                binding.searchEditText.text.clear() // Очищаем поле поиска после успешной навигации
            } catch (e: Exception) {
                Toast.makeText(context, "Страница не найдена", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupButtonShadows() {
        binding.apply {
            val buttons = listOf(
                imageButton9, imageButton10, imageButton11, imageButton12
            )

            buttons.forEach { button ->
                ViewCompat.setElevation(button, 8f)
                button.apply {
                    translationZ = 4f
                    outlineProvider = ViewOutlineProvider.BOUNDS
                    isClickable = true
                    isFocusable = true

                    setOnTouchListener { v, event ->
                        when (event.action) {
                            MotionEvent.ACTION_DOWN -> {
                                animateButtonPress(v)
                                false
                            }
                            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                                animateButtonRelease(v)
                                false
                            }
                            else -> false
                        }
                    }
                }
            }
        }
    }

    private fun animateButtonPress(view: View) {
        val scaleDownX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0.95f)
        val scaleDownY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0.95f)
        val translationZ = ObjectAnimator.ofFloat(view, "translationZ", 4f, 2f)

        AnimatorSet().apply {
            playTogether(scaleDownX, scaleDownY, translationZ)
            duration = 100
            interpolator = DecelerateInterpolator()
            start()
        }
    }

    private fun animateButtonRelease(view: View) {
        val scaleUpX = ObjectAnimator.ofFloat(view, "scaleX", 0.95f, 1f)
        val scaleUpY = ObjectAnimator.ofFloat(view, "scaleY", 0.95f, 1f)
        val translationZ = ObjectAnimator.ofFloat(view, "translationZ", 2f, 4f)

        AnimatorSet().apply {
            playTogether(scaleUpX, scaleUpY, translationZ)
            duration = 200
            interpolator = DecelerateInterpolator()
            start()
        }
    }

    private fun setupButtonClickListeners() {
        binding.apply {
            imageButton1.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_storeFragment)
            }

            imageButton2.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_devicesFragment)
            }

            imageButton3.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_documentsFragment)
            }

            imageButton4.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_transactionsFragment)
            }

            imageButton5.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_articlesFragment)
            }

            imageButton6.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_travelFragment)
            }

            imageButton7.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_govermentFragment)
            }

            imageButton8.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_statisticsFragment)
            }

            imageButton9.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_kaspiFragment)
            }

            imageButton10.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_halykFragment)
            }

            imageButton11.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_amazonFragment)
            }

            imageButton12.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_magnumFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}