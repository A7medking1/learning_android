package com.example.myapplication.utils

import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputLayout


fun TextInputLayout.validateNotEmpty(errorMessage: String = "This field is required"): Boolean {
    val text = editText?.text.toString().trim()
    return if (text.isEmpty()) {
        error = errorMessage
        false
    } else {
        error = null
        true
    }
}

fun TextInputLayout.text(): String =
    editText?.text?.toString()?.trim().orEmpty()


fun TextInputLayout.validateOnTextChange(
    errorMessage: String,
    validator: (String) -> Boolean = { it.isNotBlank() }
) {
    editText?.addTextChangedListener {
        error = if (validator(it.toString().trim())) null else errorMessage
    }
}
