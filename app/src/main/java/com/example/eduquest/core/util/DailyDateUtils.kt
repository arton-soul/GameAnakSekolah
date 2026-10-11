package com.example.eduquest.core.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DailyDateUtils {
    private const val ISO_DATE_PATTERN = "yyyy-MM-dd"
    private const val DISPLAY_DATE_PATTERN = "EEEE, d MMMM yyyy"

    fun getTodayDateString(date: Date = Date()): String {
        val sdf = SimpleDateFormat(ISO_DATE_PATTERN, Locale.US)
        return sdf.format(date)
    }

    fun getFormattedDisplayDate(date: Date = Date()): String {
        val sdf = SimpleDateFormat(DISPLAY_DATE_PATTERN, Locale("id", "ID"))
        return sdf.format(date)
    }

    fun formatDisplayDate(dateString: String): String {
        return try {
            val parser = SimpleDateFormat(ISO_DATE_PATTERN, Locale.US)
            val date = parser.parse(dateString)
            if (date != null) {
                getFormattedDisplayDate(date)
            } else {
                dateString
            }
        } catch (e: Exception) {
            dateString
        }
    }
}
