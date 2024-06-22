package com.example.mytranslate.core.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow


/**
 * Written by Vikram Ragu on 12/06/24.
 */
expect class CommonMutableStateFlow<T>(flow : MutableStateFlow<T>) : MutableStateFlow <T>

fun <T> MutableStateFlow<T>.toCommonMutableStateFlow() = CommonMutableStateFlow(this)