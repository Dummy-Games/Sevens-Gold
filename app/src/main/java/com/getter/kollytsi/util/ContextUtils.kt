package com.getter.kollytsi.util

import android.content.Context
import android.widget.Toast

fun Context.showToast(value: String, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, value, length).show()