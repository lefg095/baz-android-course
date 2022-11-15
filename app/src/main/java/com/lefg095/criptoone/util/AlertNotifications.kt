package com.lefg095.criptoone.util

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.lefg095.criptoone.R


    fun alertWarning(context: Context, title: String, mensaje: String, parentFragmentManager: FragmentManager) {
        val builder = AlertDialog.Builder(context)
        builder
            .setIcon(R.drawable.ic_alert)
            .setPositiveButton("OK", { dialogInterface, i ->
                parentFragmentManager.popBackStack()
            })
            .setTitle(title)
            .setMessage(mensaje)
        val dialog = builder.create()
        dialog.show()

        val btn_ok = dialog.getButton(DialogInterface.BUTTON_POSITIVE)
        btn_ok.setTextColor(context.resources.getColor(R.color.orange))

    }
