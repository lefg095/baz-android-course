package com.lefg095.criptoone.util

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.lefg095.criptoone.R


fun alertWarning(context: Context, title: String, mensaje: String, parentFragmentManager: FragmentManager, fragment: Fragment) {
    val builder = AlertDialog.Builder(context)
    builder
        .setIcon(R.drawable.ic_alert)
        .setPositiveButton("OK") { _, _ ->
            parentFragmentManager.popBackStack()
            parentFragmentManager.beginTransaction().remove(fragment).commit()
        }
        .setTitle(title)
        .setMessage(mensaje)
    val dialog = builder.create()
    dialog.show()

    val btn_ok = dialog.getButton(DialogInterface.BUTTON_POSITIVE)
    btn_ok.setTextColor(context.resources.getColor(R.color.orange))

}

fun alertWarningDash(context: Context, title: String, mensaje: String) {
    val builder = AlertDialog.Builder(context)
    builder
        .setIcon(R.drawable.ic_alert)
        .setPositiveButton("OK") { _, _ ->
        }
        .setTitle(title)
        .setMessage(mensaje)
    val dialog = builder.create()
    dialog.show()

    val btn_ok = dialog.getButton(DialogInterface.BUTTON_POSITIVE)
    btn_ok.setTextColor(context.resources.getColor(R.color.orange))

}