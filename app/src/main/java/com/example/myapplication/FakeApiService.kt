package com.example.myapplication

import com.example.myapplication.model.Wisdom

class FakeApiService {
    private val wisdomList = listOf<Wisdom>(
        // here generate a wisdom
        Wisdom("Don't be afraid of failure, be afraid of not trying.", "2025-06-01"),
        Wisdom(
            "Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle.",
            "2025-01-01"
        ),
        Wisdom("You are never too old to set another goal or to dream a new dream.", "2025-05-01"),
        Wisdom("Start where you are. Use what you have. Do what you can.", "2025-03-01"),
        Wisdom("You are never too old to be yourself.", "2025-02-01"),
    )

    fun getRandomWisdom(): Wisdom {
        val random = (Math.random() * wisdomList.size).toInt()
        return wisdomList[random]
    }
}