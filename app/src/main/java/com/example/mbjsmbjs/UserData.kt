package com.example.mbjsmbjs

data class UserData(
    var name : String,
    var age : Int,
    var Height : Int,
    var Weight : Int,
    var id : String,
    var password : String,
    var disease : IntArray = IntArray(4,{0}),
    var develop : IntArray = IntArray(5,{0})
)
