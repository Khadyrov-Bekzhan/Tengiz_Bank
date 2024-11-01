package com.example.kaspi.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kaspi.databinding.FragmentMessageDetailBinding
import java.text.SimpleDateFormat
import java.util.Locale

class MessageDetailFragment : Fragment() {
    private var _binding: FragmentMessageDetailBinding? = null
    private val binding get() = _binding!!

    // Получаем сообщение через аргументы Bundle
    private val message: Message? by lazy {
        arguments?.getParcelable("message")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message?.let { setupMessage(it) }
    }

    private fun setupMessage(message: Message) {
        binding.apply {
            textTitle.text = message.title
            textContent.text = message.preview
            textDate.text = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
                .format(message.date)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}