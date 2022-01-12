package com.getter.kollytsi.util

import android.text.Editable

fun CharSequence.toEditable() = Editable.Factory().newEditable(this)