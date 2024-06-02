package com.example.dhiwisepracticaltask.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.dhiwisepracticaltask.databinding.ProgressDialogLayoutBinding

class DataLoadingDialog(private val context: Context) {
    private var dialog: AlertDialog? = null

    fun showLoadingDialog(message: String = "Loading...") {
        val builder = AlertDialog.Builder(context)
        builder.setView(createProgressDialogView(context, message))
        builder.setCancelable(false) // Optional: prevent user from dismissing by tapping outside
        dialog = builder.create()
        dialog?.show()
    }

    fun dismissDialog() {
        dialog?.dismiss()
    }

    private fun createProgressDialogView(context: Context, message: String): View {
        val binding = ProgressDialogLayoutBinding.inflate(LayoutInflater.from(context))
        binding.messagesText.text = message
        return binding.root
    }
}