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

import androidx.annotation.FontRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.res.ResourcesCompat

@Composable
internal fun CustomNumberPicker(
    modifier: Modifier,
    onValueChangedListener: NumberPicker.OnValueChangeListener,
    minValue: Int,
    maxValue: Int,
    selectedValue: Int,
    dividerColor: Color,
    selectedTextColor: Color,
    unSelectedTextColor: Color,
    unSelectedTextStyle: TextStyle,
    selectedTextStyle: TextStyle,
    @FontRes font: Int? = null,
    displayedValues: Array<String>? = null,
) {

    AndroidView(modifier = modifier, factory = { context ->

        val numberPicker = NumberPicker(
            context
        )

        val typeface = font?.let { ResourcesCompat.getFont(context, it) }

        numberPicker.minValue = minValue
        numberPicker.maxValue = maxValue
        numberPicker.value = selectedValue
        numberPicker.dividerColor = dividerColor.toArgb()
        numberPicker.textColor = unSelectedTextColor.toArgb()
        numberPicker.selectedTextColor = selectedTextColor.toArgb()
        numberPicker.textSize = unSelectedTextStyle.fontSize.value * 2
        numberPicker.selectedTextSize = selectedTextStyle.fontSize.value * 2
        numberPicker.isFadingEdgeEnabled = false;
        if (font != null) {
            numberPicker.setSelectedTypeface(typeface)
            numberPicker.typeface = typeface
        };
        numberPicker.setOnValueChangedListener(onValueChangedListener)
        if (displayedValues != null) {
            numberPicker.setDisplayedValues(displayedValues)
        }

        numberPicker
    }, update = { numberPicker ->
        numberPicker.minValue = minValue
        numberPicker.maxValue = maxValue
        numberPicker.smoothScrollToPosition(selectedValue)

    })
}