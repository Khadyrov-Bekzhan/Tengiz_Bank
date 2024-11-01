package com.example.kaspi.ui.notifications

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Message(
    val id: Long,
    val title: String,
    val preview: String,
    val date: Date
) : Parcelable {
    companion object {
        fun createDemoMessages() = listOf(
            Message(
                1,
                "Уведомление о платеже",
                "Ваш платеж по кредиту успешно проведен",
                Date()
            ),
            Message(
                2,
                "Акция",
                "Получите кэшбэк 15% на все покупки в категории 'Продукты'",
                Date()
            ),
            Message(
                3,
                "Безопасность",
                "Обновите пароль от вашего аккаунта для повышения безопасности",
                Date()
            )
        )
    }
}