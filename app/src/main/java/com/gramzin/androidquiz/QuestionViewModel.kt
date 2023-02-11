package com.gramzin.androidquiz

import androidx.lifecycle.ViewModel

class QuestionViewModel: ViewModel() {
    var currentQuestion = 0

    var questions = listOf(
        Question("Какой класс отвечает за всплывающие подсказки?", mapOf(
            Pair("Text", false),
            Pair("Toast", true),
            Pair("Message", false))),
        Question("Куда необходимо помещать изображения?", mapOf(
            Pair("В папку drawable", true),
            Pair("В папку values", false),
            Pair("В папку res", false))),
        Question("Какие программы необходимы для работы с Андроид?", mapOf(
            Pair("Только JDK", false),
            Pair("Только Android Studio", false),
            Pair("JDK, Android Studio", true))),
        Question("Какие программы необходимы для работы с Андроид?", mapOf(
            Pair("C#", false),
            Pair("Kotlin", true),
            Pair("Python", false))),
        Question("Какой метод находит объект по id?", mapOf(
            Pair("findViewId", false),
            Pair("findViewById", true),
            Pair("FindViewID", false))),
    ).shuffled()

}