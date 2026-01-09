package com.example.myapplication

import com.example.myapplication.model.User

class FakeDataBase {
    fun getCurrentUser() : User {
        return User("ahmed nasr" , 2001)
    }
}