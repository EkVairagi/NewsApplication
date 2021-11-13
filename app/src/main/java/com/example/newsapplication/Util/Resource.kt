package com.example.newsapplication.Util

/*
* Sealed class is a kind of abstract class but we can
* define which classes are allowed to inherit from that resource class
* */
sealed class Resource<T>(val data:T? = null,val message:String?=null)
{
    class Success<T>(data: T):Resource<T>(data)
    class Error<T>(message: String,data: T? = null):Resource<T>(data,message)
    class Loading<T>:Resource<T>()
}