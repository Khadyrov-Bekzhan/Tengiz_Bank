package com.example.kaspi.ui.documents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kaspi.databinding.FragmentDocumentsBinding
import com.example.kaspi.ui.adapter.DocumentsAdapter
import com.example.kaspi.ui.model.Document

class DocumentsFragment : Fragment() {
    private var _binding: FragmentDocumentsBinding? = null
    private val binding get() = _binding!!

    private val documentsList = mutableListOf<Document>()       // Список документов
    private lateinit var documentsAdapter: DocumentsAdapter     // Адаптер для RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDocumentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Настройка RecyclerView
        documentsAdapter = DocumentsAdapter(documentsList)
        binding.rvDocumentsList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvDocumentsList.adapter = documentsAdapter

        // Обработка нажатия кнопки добавления документа
        binding.btnAddDocument.setOnClickListener {
            addDocument()
        }

        // Обновление UI
        updateUI()
    }

    // Метод для добавления нового документа
    private fun addDocument() {
        val newDocument = Document(
            id = documentsList.size + 1,
            title = "Документ ${documentsList.size + 1}",
            content = "Содержание документа ${documentsList.size + 1}"
        )
        documentsList.add(newDocument)

        // Обновляем адаптер и UI
        documentsAdapter.notifyDataSetChanged()
        updateUI()
    }

    // Обновление интерфейса в зависимости от наличия документов
    private fun updateUI() {
        if (documentsList.isEmpty()) {
            binding.tvNoDocumentsMessage.visibility = View.VISIBLE
            binding.rvDocumentsList.visibility = View.GONE
        } else {
            binding.tvNoDocumentsMessage.visibility = View.GONE
            binding.rvDocumentsList.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
