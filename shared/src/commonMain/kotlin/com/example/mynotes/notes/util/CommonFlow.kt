package com.example.mytranslate.core.util

import kotlinx.coroutines.flow.Flow


/**
 * Written by Vikram Ragu on 12/06/24.
 */
expect class CommonFlow<T>(flow: Flow<T>) : Flow<T>

fun <T> Flow<T>.asCommonFlow() = CommonFlow(this)

