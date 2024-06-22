package com.example.mytranslate.core.util

import kotlinx.coroutines.flow.MutableStateFlow


/**
 * Written by Vikram Ragu on 12/06/24.
 */
actual class CommonMutableStateFlow<T> actual constructor(private val flow : MutableStateFlow<T>)
    : MutableStateFlow<T> by flow