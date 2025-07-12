package ir.mehrafzoon.composedatepicker.sheet

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
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.SheetState
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import ir.mehrafzoon.composedatepicker.R
import ir.mehrafzoon.composedatepicker.core.component.PersianDatePickerController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModalBottomSheet(
    modifier: Modifier = Modifier,
    titleModifier: Modifier = Modifier,
    sheetMaxWidth: Dp = BottomSheetDefaults.SheetMaxWidth,
    sheetState: SheetState = rememberModalBottomSheetState(),
    controller: PersianDatePickerController,
    submitTitle: String = stringResource(R.string.submit),
    titleBottomSheet: String = "",
    titleStyle: TextStyle = LocalTextStyle.current,
    textButtonStyle: TextStyle = LocalTextStyle.current,
    unSelectedStyle: TextStyle? = null,
    selectedStyle: TextStyle? = null,
    buttonColor: Color = Color.Unspecified,
    containerColor: Color = Color.White,
    lineColor: Color = contentColorFor(containerColor),
    scrimColor: Color = BottomSheetDefaults.ScrimColor,
    shape: Shape = BottomSheetDefaults.ExpandedShape,
    @FontRes font: Int? = null,
    tonalElevation: Dp = BottomSheetDefaults.Elevation,
    dragHandle: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    windowInsets: WindowInsets = BottomSheetDefaults.windowInsets,
    onDateChanged: ((year: Int, month: Int, day: Int) -> Unit)? = null,
    properties: ModalBottomSheetProperties = ModalBottomSheetDefaults.properties(),
    onDismissRequest: () -> Unit,
    onSubmitClick: () -> Unit,
    datePickerWithoutDay: Boolean = false,
    useInitialDate: Boolean = false,
    initialDate: Triple<Int, Int, Int>? = null
) {
    val coroutine = rememberCoroutineScope()

    ModalBottomSheet(
        content = {
            DatePickerBottomSheetContent(
                modifier = modifier,
                onDateChanged = onDateChanged,
                lineColor = lineColor,
                submitTitle = submitTitle,
                controller = controller,
                textButtonStyle = textButtonStyle,
                unSelectedStyle = unSelectedStyle,
                containerColor = containerColor,
                selectedStyle = selectedStyle,
                titleBottomSheet = titleBottomSheet,
                titleStyle = titleStyle,
                titleModifier = titleModifier,
                buttonColor = buttonColor,
                font = font,
                onDismissRequest = {
                    coroutine.launch {
                        sheetState.hide()
                    }
                },
                onSubmitClick = onSubmitClick,
                datePickerWithoutDay = datePickerWithoutDay,
                useInitialDate = useInitialDate,
                initialDate = initialDate
            )
        },
        sheetMaxWidth = sheetMaxWidth,
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        sheetState = sheetState,
        shape = shape,
        containerColor = containerColor,
        tonalElevation = tonalElevation,
        scrimColor = scrimColor,
        dragHandle = dragHandle,
        properties = properties,
        contentWindowInsets = { windowInsets },
    )
}