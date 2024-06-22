package com.example.mytranslate.core.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow


/**
 * Written by Vikram Ragu on 12/06/24.
 */
expect class CommonStateFlow<T>  constructor(flow : StateFlow<T>) : StateFlow<T>

fun <T> StateFlow<T>.toCommonStateFlow() = CommonStateFlow(this)