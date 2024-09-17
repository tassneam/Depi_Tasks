package com.example.recyclerview

import java.io.Serializable

data class User(
    var name: String,
    var phone: String,
    var email: String
): Serializable
