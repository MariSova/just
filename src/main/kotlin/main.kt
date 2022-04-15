package ru.netology

const val second: Int = 316 * 60
const val x: Int = 60

fun agoToTex(): String {
    val minAgo: Int = x * x
    val hourAgo: Int = 24 * minAgo
    val today: Int = hourAgo * 2
    val yesterday: Int = today * 3

    return when {
        (second <= x) -> "только что."
        (second <= minAgo) -> " ${minuteToText()} назад."
        (second <= hourAgo) -> "${hourToText()} назад."
        (second <= today) -> "сегодня."
        (second <= yesterday) -> "вчера."
        else -> "давно."
    }
}

fun minuteToText(): String {
    val minTex: String = when (val min: Int = second / x) {
        1 -> " $min минуту "
        2, 3, 4 -> " $min минуты "
        31, 41, 51, 61, 71, 81, 91 -> " $min минуту "
        else -> " $min минут "
    }
    return minTex
}

fun hourToText(): String {
    return when (val hour: Int = second / 3600) {
        in 5..20 -> " $hour часов "
        1, 21 -> " $hour час "
        else -> " $hour часа "
    }
}

fun main() {
    print(" Был(-а) в сети ${agoToTex()}")
}






