package com.getter.kollytsi.util

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(value: String, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(requireContext(), value, length).show()