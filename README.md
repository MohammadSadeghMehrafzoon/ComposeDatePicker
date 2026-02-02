# Compose DatePicker Persian
[![](https://jitpack.io/v/MohammadSadeghMehrafzoon/ComposeDatePicker.svg)](https://jitpack.io/#MohammadSadeghMehrafzoon/ComposeDatePicker)




### 📆 Compose DatePicker Persian Library
Compose DatePicker BottomSheet is a powerful, flexible, and beautifully designed component for selecting Persian (Jalali) dates. Built on Jetpack Compose, it provides a smooth and professional experience for date selection in Persian apps.

## ✨ Features


- ✅ Full Persian calendar support, fully compatible with Jetpack Compose
- 🌐 Complete Persian language support (days, months, numbers)
- 📅 Date output in both Persian (Jalali) and Gregorian formats
- 🖋️ Custom Persian fonts with multiple weights
- ⚙️ Optimized architecture, ready to use in Compose-based projects
- 📆 Support for selecting only month and year without requiring a day selection (ideal for use cases where day selection is unnecessary)
- 🎨 Fully customizable UI: colors, fonts, sizes, and layout
- 📅 Ability to provide an initial default date to be pre-selected when opening the Persian date picker, useful for cases where the user has previously selected a date and now needs to edit it.
- 📅 Support for configurable minimum and maximum year limits, allowing precise control over the selectable year range (with sensible defaults when not explicitly defined)



## 🛠️ Library Setup
### Step 1: Add JitPack to settings.gradle.kts


```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

### Step 2: Adding the Dependency

```kotlin
dependencies {
    implementation("com.github.MohammadSadeghMehrafzoon:ComposeDatePicker:V1.1.4")
}
```


## 💻 Sample Code

```kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModalBottomSheet() {
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
        Text("با کلیک بر روی دکمه زیر تاریخ مورد نظر خود را انتخاب کنید")
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
            //minYear = MinYear.On(1400),
            //maxYear = MaxYear.On(1407),
            //useInitialDate = true,
            //initialDate = Triple(1404,6,27)
            //datePickerWithoutDay = true
            //titleStyle = TextStyle(fontFamily = FontFamily(Font(MediumFont))),
            //titleBottomSheet = "تاریخ مورد نظر خود را انتخاب کنید",
            //titleModifier = Modifier.padding(start = 10.dp)
        )
    }
}
```




### 📅 Features of Compose DatePicker Persian

### 📅 Persian Date Functions

| 🔧 Function                          | 📝 Description                                                                 |
|-------------------------------------|---------------------------------------------------------------------------------|
| `getPersianYear(): Int`             | Returns the **Persian year** (e.g., `1403`)                                    |
| `getPersianMonth(): Int`            | Returns the **Persian month number** from 1 to 12 (e.g., `3` for *Khordad*)    |
| `getPersianDay(): Int`              | Returns the **Persian day of the month** from 1 to 31 (e.g., `19`)             |
| `getPersianMonthName(): String`     | Returns the **Persian month name** (e.g., `"خرداد"`)                         |
| `getPersianDayOfWeekName(): String` | Returns the **Persian day of the week name** (e.g., `"چهارشنبه"`)         |



## 🌍 Gregorian Date Functions

| 🔧 Function                          | 📝 Description                                                                 |
|-------------------------------------|---------------------------------------------------------------------------------|
| `getGregorianYear(): Int`           | Returns the **Gregorian year** (e.g., `2025`)                                  |
| `getGregorianMonth(): Int`          | Returns the **Gregorian month number** from 1 to 12 (e.g., `6` for June)       |
| `getGregorianDay(): Int`            | Returns the **Gregorian day of the month** (e.g., `11`)                        |
| `getGregorianDate(): Date`          | Returns the **full Gregorian date** as a `Date` object                         |



## 🧠 General Date Information

| 🔧 Function              | 📝 Description                                                                 |
|-------------------------|---------------------------------------------------------------------------------|
| `getDayOfWeek(): Int`   | Returns the **day of the week number** (the meaning of the number may vary depending on the implementation) |




## 🗓️ Formatted Date Strings

| 🔧 Function                                      | 📝 Description                                                                                   |
|--------------------------------------------------|--------------------------------------------------------------------------------------------------|
| `getFullDate(): String`                         | Returns the **full Persian date** in `yyyy/MM/dd` format (e.g., `"1403/03/19"`)                 |
| `getPersianMonthNameAndPersianYear(): String`   | Returns a combination of **Persian month name and year** (e.g., `"خرداد 1403"`)               |
| `getMiladiFullDate(): String`                   | Returns the **full Gregorian date** in `yyyy/MM/dd` format (e.g., `"2025/06/11"`)               |
| `getPersianFullDate(): String`                  | Returns the **detailed Persian date** (e.g., `"چهارشنبه 19 خرداد 1403"`)                 |


## ⏱️ Timestamp Utility

| 🔧 Function              | 📝 Description                                                                                   |
|-------------------------|--------------------------------------------------------------------------------------------------|
| `getTimestamp(): Long`  | Returns the **Unix timestamp** (number of milliseconds since `1970-01-01`) for the current date |



## 🔤 Persian Fonts

| Font Variable           | Font Weight       | Usage Description                                                       |
|-------------------------|-------------------|-------------------------------------------------------------------------|
| `BoldFont`              | Bold (700)        | Suitable for titles and highly emphasized sections                      |
| `MediumFont`            | Medium (500)      | Ideal for buttons or semi-bold texts                                    |
| `RegularFont`           | Regular (400)     | Used for general body text and main content                             |
| `LightFont`             | Light (300)       | Suitable for secondary or descriptive texts                             |
| `ThinFont`              | Thin (200)        | Suitable for very light and delicate text                               |
| `HairlineFont`          | Hairline (100)    | The thinnest font weight, ideal for decorative or neutral text          |


## ⚙️ Configurable Parameters of ComposeDatePickerBottomSheet

| Parameter            | Type / Description                                                                                   |
|----------------------|------------------------------------------------------------------------------------------------------|
| `modifier`           | `Modifier` — Used to configure the overall layout of the Bottom Sheet.                              |
| `titleModifier`      | `Modifier` — Modifier for the top title inside the Bottom Sheet.                                     |
| `sheetState`         | `SheetState` — Current state of the Bottom Sheet. Use `rememberModalBottomSheetState()` to create it. |
| `controller`         | ✅ **Required** — Controller for the selected date. Must be created and remembered inside a composable. |
| `submitTitle`        | `String` — Text for the confirm button (default: `"تایید"` / `"Confirm"`)                           |
| `titleBottomSheet`   | `String` — Title displayed at the top of the Bottom Sheet.                                           |
| `titleStyle`         | `TextStyle` — Style for the title text (font, size, color, etc.).                                   |
| `textButtonStyle`    | `TextStyle` — Style for the confirm button text.                                                     |
| `unSelectedStyle`    | `TextStyle?` — Style for unselected date items (optional).                                           |
| `selectedStyle`      | `TextStyle?` — Style for the selected date item (optional).                                          |
| `buttonColor`        | `Color` — Background color of the confirm button.                                                    |
| `containerColor`     | `Color` — Background color of the Bottom Sheet.                                                      |
| `lineColor`          | `Color` — Color of the divider lines inside the picker.                                              |
| `shape`              | `Shape` — Shape of the Bottom Sheet corners.                                                         |
| `font`               | `Int?` — Custom font ID.                                                                              |
| `onDateChanged`      | `(year: Int, month: Int, day: Int) -> Unit` — Callback triggered when the selected date changes.     |
| `properties`         | `ModalBottomSheetProperties` — Advanced Bottom Sheet behavior configuration.                         |
| `onDismissRequest`   | ✅ **Required** — Callback triggered when the sheet is dismissed (e.g., drag down or tap outside).    |
| `onSubmitClick`      | ✅ **Required** — Callback triggered when the confirm button is clicked.                              |
| `datePickerWithoutDay` | `Boolean` — Enables **month/year only** selection mode and hides the day selector.                |
| `useInitialDate` | `Boolean` — A boolean flag indicating whether to use a predefined date.                |
| `initialDate` | `Triple` — A Triple<Int, Int, Int> representing the year, month, and day in the Persian calendar. `Sample: Triple(1404,6,27)`.                |
| `minYear` | `MinYear` — Defines the minimum selectable year (optional, defaults to DatePicker configuration). |
| `maxYear` | `MaxYear` — Defines the maximum selectable year (optional, defaults to DatePicker configuration). |


## Sample Implementation
![InCollage_20250630_091654344](https://github.com/user-attachments/assets/4e02f908-9e6e-47d5-a375-427da634e106)
