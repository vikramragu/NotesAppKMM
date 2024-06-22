package com.example.mynotes.notes.util

import com.example.mytranslate.core.util.CommonMutableStateFlow
import com.example.mytranslate.core.util.CommonStateFlow
import kotlinx.coroutines.flow.MutableStateFlow


/**
 * Written by Vikram Ragu on 13/06/24.
 */
class IOSMutableStateFlow<T> constructor(value : T) : CommonMutableStateFlow<T>(MutableStateFlow(value))