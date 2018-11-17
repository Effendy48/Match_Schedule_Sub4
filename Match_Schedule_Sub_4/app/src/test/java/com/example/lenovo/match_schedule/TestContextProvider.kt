package com.example.lenovo.match_schedule

import com.example.lenovo.match_schedule.util.CoroutineContextProvider
import kotlinx.coroutines.experimental.Unconfined
import kotlin.coroutines.experimental.CoroutineContext

class TestContextProvider : CoroutineContextProvider() {
    override val main : CoroutineContext = Unconfined
}