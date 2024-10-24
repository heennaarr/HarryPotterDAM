package com.example.harrypotterdam.app

sealed class ErrorApp {
    object InternetErrorApp:ErrorApp()
    object ServerErrorApp:ErrorApp()
    object DataErrorApp:ErrorApp()
    object UnknowErrorApp:ErrorApp()
    object TestErrorApp:ErrorApp()
}