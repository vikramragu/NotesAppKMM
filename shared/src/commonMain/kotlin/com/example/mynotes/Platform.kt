package com.example.mynotes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform