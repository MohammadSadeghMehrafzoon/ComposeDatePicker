package ir.mehrafzoon.composedatepicker.core.component


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


import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import ir.huri.jcal.JalaliCalendar
import java.util.Calendar
import java.util.Date


@Composable
fun rememberDialogDatePicker(): PersianDatePickerController {
    return remember { PersianDatePickerController() }
}

class PersianDatePickerController {

    private var _date: MutableState<JalaliCalendar> = mutableStateOf(JalaliCalendar())
    internal val date get() = _date.value

    private var _yearRange: MutableState<Int> = mutableIntStateOf(10)
    internal val yearRange get() = _yearRange.value

    private var _minYear: MutableState<Int> = mutableIntStateOf(getPersianYear() - yearRange)
    internal val minYear get() = _minYear.value

    private var _maxYear: MutableState<Int> = mutableIntStateOf(getPersianYear() + yearRange)
    internal val maxYear get() = _maxYear.value

    private var _maxMonth: MutableState<Int> = mutableIntStateOf(12)
    internal val maxMonth get() = _maxMonth.value

    private var _maxDay: MutableState<Int> = mutableIntStateOf(31)
    internal val maxDay get() = _maxDay.value

    private var _selectedYear: MutableState<Int> = mutableIntStateOf(getPersianYear())
    internal val selectedYear get() = _selectedYear.value

    private var _selectedMonth: MutableState<Int> = mutableIntStateOf(getPersianMonth())
    internal val selectedMonth get() = _selectedMonth.value

    private var _selectedDay: MutableState<Int> = mutableIntStateOf(getPersianDay())
    internal val selectedDay get() = _selectedDay.value

    private var _displayMonthNames: MutableState<Boolean> = mutableStateOf(true)
    internal val displayMonthNames get() = _displayMonthNames.value

    private var _isLeapYear: MutableState<Boolean> = mutableStateOf(false)
    internal val isLeapYear get() = _isLeapYear.value

    private fun updateSelectedYear(value: Int) {
        _selectedYear.value = value
    }

    private fun updateSelectedMonth(value: Int) {
        _selectedMonth.value = value
    }

    private fun updateSelectedDay(value: Int) {
        _selectedDay.value = value
    }

    fun updateDisplayMonthNames(value: Boolean) {
        _displayMonthNames.value = value
    }

    fun updateIsLeapYear(value: Boolean) {
        _isLeapYear.value = value
    }

    fun updateMinYear(value: Int) {
        _minYear.value = value
    }

    fun updateMaxYear(value: Int) {
        _maxYear.value = value
    }

    fun updateMaxMonth(value: Int) {
        _maxMonth.value = value
    }

    fun updateMaxDay(value: Int) {
        _maxDay.value = value
    }

    fun updateYearRange(value: Int) {
        _yearRange.value = value
    }

    fun updateDate(timestamp: Long) {
        val date = Date(timestamp)
        _date.value = JalaliCalendar(date)
        updateSelectedDate()
    }

    fun updateDate(date: Date) {
        _date.value = JalaliCalendar(date)
        updateSelectedDate()
    }

    fun updateDate(persianYear: Int, persianMonth: Int, persianDay: Int) {
        _date.value = JalaliCalendar(persianYear, persianMonth, persianDay)
        updateSelectedDate()
    }

    private fun updateSelectedDate() {
        updateSelectedYear(date.year)
        updateSelectedMonth(date.month)
        updateSelectedDay(date.day)
    }

    internal fun resetDate(onDateChanged: ((year: Int, month: Int, day: Int) -> Unit)? = null) {
        _date.value = JalaliCalendar()
        updateSelectedDate()
        onDateChanged?.invoke(date.year, date.month, date.day)
    }

    fun getPersianYear(): Int = date.year
    fun getPersianMonth(): Int = date.month
    fun getPersianDay(): Int = date.day

    fun getGregorianYear(): Int = date.toGregorian().get(Calendar.YEAR)
    fun getGregorianMonth(): Int = date.toGregorian().get(Calendar.MONTH) + 1
    fun getGregorianDay(): Int = date.toGregorian().get(Calendar.DAY_OF_MONTH)

    fun getDayOfWeek(): Int = date.dayOfWeek

    fun getPersianMonthName(): String = date.monthString

    fun getPersianDayOfWeekName(): String = date.dayOfWeekString

    fun getPersianFullDate(): String =
        "${getPersianDayOfWeekName()}  ${getPersianDay()}  ${getPersianMonthName()}  ${getPersianYear()}"

    fun getGregorianDate(): Date = date.toGregorian().time

    fun getTimestamp(): Long = date.toGregorian().timeInMillis

    fun getFullDate(): String =
        "${getPersianYear()}/${
            getPersianMonth().toString().padStart(2, '0')
        }/${getPersianDay()}"

    fun getPersianMonthNameAndPersianYear(): String =
        "${getPersianMonthName()} ${getPersianYear()}"

    fun getMiladiFullDate(): String =
        " ${getGregorianYear()}/${
            getGregorianMonth().toString().padStart(2, '0')
        }/${getGregorianDay()}"

    internal fun updateFromCustomNumberPicker(
        newYear: Int? = null,
        newMonth: Int? = null,
        newDay: Int? = null
    ) {
        if (newYear != null) updateSelectedYear(newYear)
        if (newMonth != null) updateSelectedMonth(newMonth)
        if (newDay != null) updateSelectedDay(newDay)

        val isLeapYear = JalaliCalendar(selectedYear, selectedMonth, selectedDay).isLeap

        if (selectedMonth < 7) {
            updateMaxDay(31)
        } else if (selectedMonth < 12) {
            if (selectedDay == 31) updateSelectedDay(30)
            updateMaxDay(30)
        } else if (selectedMonth == 12) {
            if (isLeapYear) {
                if (selectedDay > 30) updateSelectedDay(30)
                updateMaxDay(30)
            } else {
                if (selectedDay > 29) updateSelectedDay(29)
                updateMaxDay(29)
            }
        }

        updateDate(selectedYear, selectedMonth, selectedDay)
    }

    internal fun initDate() {
        if (minYear > selectedYear) updateMinYear(selectedYear - yearRange)
        if (maxYear < selectedYear) updateMaxYear(selectedYear + yearRange)

        if (selectedYear > maxYear) updateSelectedYear(maxYear)
        if (selectedYear < minYear) updateSelectedYear(minYear)

        if (selectedMonth in 7..11 && selectedDay == 31) {
            updateSelectedDay(30)
        } else if (selectedMonth == 12) {
            val isLeapYear = JalaliCalendar(selectedYear, 1, 1).isLeap
            if (isLeapYear && selectedDay > 30) {
                updateSelectedDay(30)
            } else if (!isLeapYear && selectedDay > 29) {
                updateSelectedDay(29)
            }
        }
    }
}