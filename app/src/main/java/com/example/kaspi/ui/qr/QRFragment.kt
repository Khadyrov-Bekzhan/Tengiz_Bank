package com.example.kaspi.ui.qr

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kaspi.databinding.FragmentQrBinding
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.ScanOptions

class QRFragment : Fragment() {

    private var _binding: FragmentQrBinding? = null
    private val binding get() = _binding!!

    // Регистрация результата сканера с правильной типизацией
    private val qrCodeLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == android.app.Activity.RESULT_OK) {
                val data: Intent? = result.data
                val contents = data?.getStringExtra("SCAN_RESULT")
                binding.textTengizQR.text = contents ?: "QR Code not found"
            } else {
                binding.textTengizQR.text = "Scan cancelled"
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQrBinding.inflate(inflater, container, false)

        // Установка слушателя на кнопку для запуска сканера
        binding.btnScanQr.setOnClickListener { startQRScanner() }

        return binding.root
    }

    private fun startQRScanner() {
        val integrator = IntentIntegrator.forSupportFragment(this) // Используем fragment
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("Scan a QR Code")
        integrator.setBeepEnabled(true)
        integrator.setOrientationLocked(false)
        qrCodeLauncher.launch(integrator.createScanIntent()) // Запуск сканера
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

