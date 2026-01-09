package com.example.myapplication.ui

import com.example.myapplication.model.User
import com.example.myapplication.model.Wisdom

interface IMainView {
    fun onUserInfoSuccess(user: User)
    fun onWisdomSuccess(wisdom: Wisdom)
}