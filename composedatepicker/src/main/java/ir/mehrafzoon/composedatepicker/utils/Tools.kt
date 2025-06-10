package ir.mehrafzoon.composedatepicker.utils

/*
 * Copyright (C) 2025 Mohammad Sadegh Mehrafzoon
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Calendar
import java.util.Date

internal object Tools {

    fun Date.isDateToday(): Boolean {
        val calendar = Calendar.getInstance()
        val today = Calendar.getInstance()

        calendar.time = this
        today.set(Calendar.HOUR_OF_DAY, 0)
        today.set(Calendar.MINUTE, 0)
        today.set(Calendar.SECOND, 0)
        today.set(Calendar.MILLISECOND, 0)

        return calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                calendar.get(Calendar.MONTH) == today.get(Calendar.MONTH) &&
                calendar.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)
    }

    fun String.toPersianDigits(): String {
        return this.map {
            when (it) {
                in '0'..'9' -> '۰' + (it - '0')
                else -> it
            }
        }.joinToString("")
    }

    fun convertNumberToPersian(number: Int): String {
        return number.toString().map {
            when (it) {
                in '0'..'9' -> '۰' + (it - '0')
                else -> it
            }
        }.joinToString("")
    }
}