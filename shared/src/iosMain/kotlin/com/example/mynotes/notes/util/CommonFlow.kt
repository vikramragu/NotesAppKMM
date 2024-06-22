package com.example.mytranslate.core.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


/**
 * Written by Vikram Ragu on 12/06/24.
 */
actual open class CommonFlow<T> actual constructor(private val flow: Flow<T>) : Flow<T> by flow {

    fun subscribe(
        coroutineScope: CoroutineScope,
        coroutineDispatcher: CoroutineDispatcher,
        onCollect : (T) -> Unit
    ) : DisposableHandle {

       val job = coroutineScope.launch(coroutineDispatcher) {
            flow.collect(onCollect)
        }

        return object : DisposableHandle {
            override fun dispose() {
                job.cancel()
            }
        }
    }

    fun subscribe(
        onCollect : (T) -> Unit
    ) : DisposableHandle {

       return subscribe(
           coroutineScope = GlobalScope,
           coroutineDispatcher = Dispatchers.Main,
           onCollect = onCollect
       )

    }
}