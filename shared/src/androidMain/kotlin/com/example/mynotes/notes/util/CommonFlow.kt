package com.example.mytranslate.core.util

import kotlinx.coroutines.flow.Flow


/**
 * Written by Vikram Ragu on 12/06/24.
 */
actual class CommonFlow<T> actual constructor(private val flow : Flow<T>) : Flow<T> by flow