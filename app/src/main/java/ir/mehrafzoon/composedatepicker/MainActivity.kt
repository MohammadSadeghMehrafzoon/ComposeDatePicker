package ir.mehrafzoon.composedatepicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.mehrafzoon.composedatepicker.core.component.BoldFont
import ir.mehrafzoon.composedatepicker.core.component.MediumFont
import ir.mehrafzoon.composedatepicker.core.component.RegularFont
import ir.mehrafzoon.composedatepicker.core.component.ThinFont
import ir.mehrafzoon.composedatepicker.core.component.rememberDialogDatePicker
import ir.mehrafzoon.composedatepicker.sheet.DatePickerModalBottomSheet
import ir.mehrafzoon.composedatepicker.ui.theme.ComposeDatePickerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeDatePickerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    Greeting()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    val datePickerController = rememberDialogDatePicker()
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutine = rememberCoroutineScope()

    var persianFullDate by remember { mutableStateOf("") }
    var gregorianDate by remember { mutableStateOf("") }
    var persianMonth by remember { mutableStateOf("") }
    var timestamp by remember { mutableStateOf("") }
    var fullDate by remember { mutableStateOf("") }
    var persianMonthNameAndPersianYear by remember { mutableStateOf("") }
    var getMiladiFullDate by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("با کلیک بر روی دکمه تایید تاریخ مورد نظر خود را انتخاب کنید")
        Spacer(Modifier.height(10.dp))
        Button(
            onClick = {
                coroutine.launch { bottomSheetState.show() }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(
                text = "انتخاب تاریخ",
                textAlign = TextAlign.Center,
            )
        }
        Spacer(Modifier.height(20.dp))
        Text(persianFullDate)
        Text(gregorianDate)
        Text(persianMonth)
        Text(fullDate)
        Text(persianMonthNameAndPersianYear)
        Text(getMiladiFullDate)
        if (timestamp.isNotEmpty()){
            Text("timestamp $timestamp")
        }

    }


    if (bottomSheetState.isVisible) {
        DatePickerModalBottomSheet(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            onSubmitClick = {
                persianFullDate = datePickerController.getPersianFullDate()
                gregorianDate = datePickerController.getGregorianDate().toString()
                persianMonth = datePickerController.getPersianMonth().toString()
                timestamp = datePickerController.getTimestamp().toString()
                fullDate = datePickerController.getFullDate()
                persianMonthNameAndPersianYear = datePickerController.getPersianMonthNameAndPersianYear()
                getMiladiFullDate = datePickerController.getMiladiFullDate()
            },
            sheetState = bottomSheetState,
            controller = datePickerController,
            onDismissRequest = {
                coroutine.launch { bottomSheetState.hide() }
            },
            font = RegularFont,
            textButtonStyle = TextStyle(fontFamily = FontFamily(Font(BoldFont))),
            //titleStyle = TextStyle(fontFamily = FontFamily(Font(MediumFont))),
            //titleBottomSheet = "تاریخ مورد نظر خود را انتخاب کنید",
            //titleModifier = Modifier.padding(start = 30.dp)
        )
    }
}
