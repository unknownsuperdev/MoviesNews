package com.task.network.ktor

import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.OkHttp

actual class HttpEngineFactory actual constructor() {
    actual fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig> = OkHttp
}