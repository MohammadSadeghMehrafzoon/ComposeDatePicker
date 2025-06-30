package ir.mehrafzoon.composedatepicker.lineardatepicker

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

import androidx.annotation.FontRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import ir.mehrafzoon.composedatepicker.core.component.CustomNumberPicker
import ir.mehrafzoon.composedatepicker.core.component.NumberPicker
import ir.mehrafzoon.composedatepicker.core.component.PersianDatePickerController
import ir.mehrafzoon.composedatepicker.utils.Constant
import ir.mehrafzoon.composedatepicker.utils.Tools.convertNumberToPersian
import ir.mehrafzoon.composedatepicker.utils.Tools.toPersianDigits

@Composable
internal fun PersianDatePickerWithoutDay(
    controller: PersianDatePickerController,
    modifier: Modifier = Modifier,
    contentColor: Color,
    unSelectedStyle: TextStyle,
    selectedStyle: TextStyle,
    @FontRes font: Int?,
    onDateChanged: ((year: Int, month: Int, day: Int) -> Unit)? = null,
) {

    controller.initDate()

    val displayedValues = (controller.minYear..controller.maxYear)
        .map { it.toString().toPersianDigits() }
        .toTypedArray()

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        CustomNumberPicker(
            modifier = Modifier.weight(1F),
            onValueChangedListener = object : NumberPicker.OnValueChangeListener {
                override fun onValueChange(picker: NumberPicker?, oldVal: Int, newVal: Int) {
                    controller.updateFromCustomNumberPicker(newMonth = newVal)
                    if (onDateChanged != null) {
                        onDateChanged(
                            controller.selectedYear,
                            controller.selectedMonth,
                            controller.selectedDay
                        )
                    }
                }
            },
            minValue = 1,
            maxValue = if (controller.maxMonth > 0) controller.maxMonth else 12,
            selectedValue = controller.selectedMonth,
            dividerColor = contentColor,
            selectedTextColor = selectedStyle.color,
            unSelectedTextColor = unSelectedStyle.color,
            selectedTextStyle = selectedStyle,
            unSelectedTextStyle = unSelectedStyle,
            font = font,
            displayedValues = if (controller.displayMonthNames) Constant.persianMonthNames else null,
        )

        Spacer(modifier = Modifier.size(16.dp))

        CustomNumberPicker(
            modifier = Modifier
                .weight(1F)
                .wrapContentHeight(),
            onValueChangedListener = object : NumberPicker.OnValueChangeListener {
                override fun onValueChange(picker: NumberPicker?, oldVal: Int, newVal: Int) {
                    controller.updateFromCustomNumberPicker(newYear = newVal)
                    if (onDateChanged != null) {
                        onDateChanged(
                            controller.selectedYear,
                            controller.selectedMonth,
                            controller.selectedDay
                        )
                    }
                }
            },
            minValue = controller.minYear,
            maxValue = controller.maxYear,
            dividerColor = contentColor,
            selectedTextColor = selectedStyle.color,
            unSelectedTextColor = unSelectedStyle.color,
            selectedTextStyle = selectedStyle,
            unSelectedTextStyle = unSelectedStyle,
            font = font,
            selectedValue = controller.selectedYear,
            displayedValues = displayedValues
        )
    }
}