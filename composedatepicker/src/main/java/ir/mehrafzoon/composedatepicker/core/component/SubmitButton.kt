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

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun AppButton(
    label: String,
    modifier: Modifier = Modifier,
    containerColor: Color = Color.Blue,
    enable: Boolean = false,
    textButtonStyle: TextStyle,
    shape: Shape = MaterialTheme.shapes.small,
    fontWeight: FontWeight = FontWeight.Normal,
    onClick: () -> Unit
) {
    Button(
        enabled = enable,
        modifier = modifier
            .fillMaxWidth(),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        shape = shape,
    ) {
        Text(
            text = label,
            fontWeight = fontWeight,
            style = textButtonStyle
        )
    }
}