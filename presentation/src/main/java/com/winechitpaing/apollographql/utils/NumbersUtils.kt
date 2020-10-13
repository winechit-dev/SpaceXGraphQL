package com.winechitpaing.apollographql.utils

import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Calendar
import java.util.Date
import java.util.Locale



fun getLocalTimeFromUnix(unixTime: String): String {
    val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
    simpleDateFormat.timeZone = Calendar.getInstance().timeZone
    return simpleDateFormat.format(Date((unixTime.toLongOrNull() ?: 1) * 1000))
}

