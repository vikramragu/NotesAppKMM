package com.example.mytranslate.core.util

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


/**
 * Written by Vikram Ragu on 12/06/24.
 */
actual open class CommonMutableStateFlow <T> actual constructor(private val flow : MutableStateFlow<T>)
    : CommonStateFlow<T> (flow), MutableStateFlow<T> {


    override var value: T
        get() = super.value
        set(value) {
            flow.value = value
        }

    override val subscriptionCount: StateFlow<Int>
        get() = flow.subscriptionCount

    override fun compareAndSet(expect: T, update: T): Boolean {
        return flow.compareAndSet(expect = expect, update = update)
    }

    @ExperimentalCoroutinesApi
    override fun resetReplayCache() {
        flow.resetReplayCache()
    }

    override fun tryEmit(value: T): Boolean {
        return flow.tryEmit(value = value)
    }

    override suspend fun emit(value: T) {
        flow.emit(value)
    }

}