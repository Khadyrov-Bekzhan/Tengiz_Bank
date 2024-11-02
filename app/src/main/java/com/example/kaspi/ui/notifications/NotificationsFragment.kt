package com.example.kaspi.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kaspi.R
import com.example.kaspi.databinding.FragmentNotificationsBinding
import com.google.android.material.snackbar.Snackbar

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MessagesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel = ViewModelProvider(this)[NotificationsViewModel::class.java]
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)

        setupRecyclerView()
        setupFab()
        observeViewModel(notificationsViewModel)

        return binding.root
    }

    private fun setupRecyclerView() {
        adapter = MessagesAdapter { message ->
            showMessageDetails(message)
        }

        binding.recyclerMessages.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@NotificationsFragment.adapter
        }
    }

    private fun setupFab() {
        binding.fabNewMessage.setOnClickListener {
            Snackbar.make(binding.root, "Создание нового сообщения", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun observeViewModel(viewModel: NotificationsViewModel) {
        viewModel.messages.observe(viewLifecycleOwner) { messages ->
            binding.textEmpty.visibility = if (messages.isEmpty()) View.VISIBLE else View.GONE
            adapter.submitList(messages)
        }
    }

    private fun showMessageDetails(message: Message) {
        val bundle = Bundle().apply {
            putParcelable("message", message)
        }
        findNavController().navigate(
            R.id.messageDetailFragment,
            bundle
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}