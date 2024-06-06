package com.raxors.animexplore

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform