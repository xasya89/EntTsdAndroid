package com.example.enttsd.models

data class NaryadModel(
    val naryadId:Int,
    val shet:String,
    val customer:String,
    val numInOrder:String,
    val positionInOrder:Int,
    val svarkaCompliteFlag:Boolean,
    val frameCompliteFlag:Boolean,
    val sborkaCompliteFlag:Boolean,
    val colorCompliteFlag:Boolean,
    val upakCompliteFLag:Boolean,
    val shptCompliteFlag:Boolean,

    var isChacked:Boolean = false
)
