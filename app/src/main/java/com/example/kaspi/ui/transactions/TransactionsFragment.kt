package com.example.kaspi.ui.transactions

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kaspi.R
import com.example.kaspi.databinding.FragmentTransactionsBinding
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TransactionsFragment : Fragment() {

    private var _binding: FragmentTransactionsBinding? = null
    private val binding get() = _binding!!

    private lateinit var transactionsAdapter: TransactionsAdapter
    private var currentBalance = BigDecimal.ZERO
    private val transactions = mutableListOf<Transaction>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupClickListeners()
        loadBalance()
        loadTransactions()
    }

    private fun setupRecyclerView() {
        transactionsAdapter = TransactionsAdapter(transactions)
        binding.transactionsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = transactionsAdapter
        }
    }

    private fun setupClickListeners() {
        binding.topUpButton.setOnClickListener {
            showAmountInputDialog("Пополнение") { amount ->
                if (amount > BigDecimal.ZERO) {
                    topUpBalance(amount)
                } else {
                    showError("Сумма должна быть больше 0")
                }
            }
        }

        binding.withdrawButton.setOnClickListener {
            showAmountInputDialog("Вывод средств") { amount ->
                if (amount <= currentBalance) {
                    withdrawBalance(amount)
                } else {
                    showError("Недостаточно средств")
                }
            }
        }
    }

    private fun showAmountInputDialog(title: String, onAmountEntered: (BigDecimal) -> Unit) {
        val dialog = AlertDialog.Builder(requireContext())
        val input = EditText(requireContext()).apply {
            inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
        }

        dialog.setTitle(title)
            .setView(input)
            .setPositiveButton("OK") { _, _ ->
                try {
                    val amount = BigDecimal(input.text.toString())
                        .setScale(2, RoundingMode.HALF_UP)
                    onAmountEntered(amount)
                } catch (e: NumberFormatException) {
                    showError("Неверный формат суммы")
                }
            }
            .setNegativeButton("Отмена", null)
            .show()
    }

    private fun topUpBalance(amount: BigDecimal) {
        currentBalance = currentBalance.add(amount)
        updateBalance()
        addTransaction(Transaction(
            id = System.currentTimeMillis(),
            type = TransactionType.TOP_UP,
            amount = amount,
            timestamp = System.currentTimeMillis()
        ))
    }

    private fun withdrawBalance(amount: BigDecimal) {
        currentBalance = currentBalance.subtract(amount)
        updateBalance()
        addTransaction(Transaction(
            id = System.currentTimeMillis(),
            type = TransactionType.WITHDRAW,
            amount = amount,
            timestamp = System.currentTimeMillis()
        ))
    }

    private fun updateBalance() {
        binding.balanceAmountTextView.text = formatCurrency(currentBalance)
    }

    private fun addTransaction(transaction: Transaction) {
        transactions.add(0, transaction)
        transactionsAdapter.notifyItemInserted(0)
        binding.transactionsRecyclerView.scrollToPosition(0)
    }

    private fun loadBalance() {
        currentBalance = BigDecimal.ZERO
        updateBalance()
    }

    private fun loadTransactions() {
        transactions.clear()
        transactionsAdapter.notifyDataSetChanged()
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun formatCurrency(amount: BigDecimal): String {
        return String.format(Locale.getDefault(), "₸ %.2f", amount)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

data class Transaction(
    val id: Long,
    val type: TransactionType,
    val amount: BigDecimal,
    val timestamp: Long
)

enum class TransactionType {
    TOP_UP,
    WITHDRAW
}

class TransactionsAdapter(
    private val transactions: List<Transaction>
) : RecyclerView.Adapter<TransactionsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val typeTextView: TextView = view.findViewById(R.id.transactionTypeTextView)
        val amountTextView: TextView = view.findViewById(R.id.transactionAmountTextView)
        val dateTextView: TextView = view.findViewById(R.id.transactionDateTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transaction, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transaction = transactions[position]

        holder.typeTextView.text = when(transaction.type) {
            TransactionType.TOP_UP -> "Пополнение"
            TransactionType.WITHDRAW -> "Списание"
        }

        holder.amountTextView.text = String.format(
            Locale.getDefault(),
            "₸ %.2f",
            transaction.amount
        )

        holder.dateTextView.text = SimpleDateFormat(
            "dd.MM.yyyy HH:mm",
            Locale.getDefault()
        ).format(Date(transaction.timestamp))
    }

    override fun getItemCount() = transactions.size
}