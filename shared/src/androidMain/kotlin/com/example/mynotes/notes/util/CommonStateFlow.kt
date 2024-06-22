package com.example.mytranslate.core.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow


/**
 * Written by Vikram Ragu on 12/06/24.
 */
actual class CommonStateFlow<T> actual constructor(private val flow: StateFlow<T>) : StateFlow<T> by flow