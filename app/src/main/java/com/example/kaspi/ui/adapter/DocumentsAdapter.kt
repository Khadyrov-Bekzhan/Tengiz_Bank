package com.example.kaspi.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kaspi.R
import com.example.kaspi.ui.model.Document

class DocumentsAdapter(private val documents: List<Document>) :
    RecyclerView.Adapter<DocumentsAdapter.DocumentViewHolder>() {

    inner class DocumentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.tvDocumentTitle)
        val contentTextView: TextView = itemView.findViewById(R.id.tvDocumentContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_document, parent, false)
        return DocumentViewHolder(view)
    }

    override fun onBindViewHolder(holder: DocumentViewHolder, position: Int) {
        val document = documents[position]
        holder.titleTextView.text = document.title
        holder.contentTextView.text = document.content
    }

    override fun getItemCount(): Int = documents.size
}
