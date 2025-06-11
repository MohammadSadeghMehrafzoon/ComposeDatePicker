### 📆 کتابخانه‌ی ComposeDatePicker شمسی



‏ComposeDatePickerBottomSheet یک کامپوننت قدرتمند، منعطف و زیبای انتخاب تاریخ شمسی است که بر پایه‌ی Jetpack Compose طراحی شده و تجربه‌ای روان و حرفه‌ای برای انتخاب تاریخ در اپلیکیشن‌های فارسی‌زبان فراهم می‌کن

## ✨ ویژگی‌ها

- ✅ تقویم شمسی کامل و قابل استفاده در Jetpack Compose
- 🌐 پشتیبانی کامل از زبان فارسی (روزها، ماه‌ها، اعداد)
- 📅 خروجی‌های تاریخ با فرمت شمسی و میلادی
- 🖋️ فونت فارسی سفارشی با چند وزن متفاوت
- ⚙️ ساختار بهینه و قابل استفاده در پروژه‌های Compose

---

## 🛠️ نحوه استفاده از کتابخانه 

### مرحله ۱: افزودن JitPack در settings.gradle.kts
```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

### مرحله ۲: اضافه کردن dependency

```kotlin
dependencies {
    implementation("com.github.MohammadSadeghMehrafzoon:ComposeDatePicker:V1.1.0")
}
```



### 📅 قابلیت های ComposeDatePicker 

---
### 📅 توابع تاریخ شمسی

| 🔧 تابع                              | 📝 توضیحات                                                            |
|--------------------------------------|------------------------------------------------------------------------|
| `getPersianYear(): Int`              | برگرداندن **سال شمسی** (مثال: `1403`)                                 |
| `getPersianMonth(): Int`             | برگرداندن **شماره ماه شمسی** بین ۱ تا ۱۲ (مثال: `3` برای خرداد)      |
| `getPersianDay(): Int`               | برگرداندن **روز ماه شمسی** بین ۱ تا ۳۱ (مثال: `19`)                   |
| `getPersianMonthName(): String`      | برگرداندن **نام ماه شمسی** (مثال: `"خرداد"`)                         |
| `getPersianDayOfWeekName(): String`  | برگرداندن **نام روز هفته** به فارسی (مثال: `"چهارشنبه"`)             |

---

### 🌍 توابع تاریخ میلادی

| 🔧 تابع                              | 📝 توضیحات                                                            |
|--------------------------------------|------------------------------------------------------------------------|
| `getGregorianYear(): Int`            | برگرداندن **سال میلادی** (مثال: `2025`)                               |
| `getGregorianMonth(): Int`           | برگرداندن **شماره ماه میلادی** (۱ تا ۱۲، مثال: `6` برای ژوئن)        |
| `getGregorianDay(): Int`             | برگرداندن **روز ماه میلادی** (مثال: `11`)                             |
| `getGregorianDate(): Date`           | برگرداندن **تاریخ کامل میلادی** به‌صورت شیء `Date`                    |

---

### 🧠 اطلاعات عمومی تاریخ

| 🔧 تابع                | 📝 توضیحات                                                                 |
|------------------------|------------------------------------------------------------------------------|
| `getDayOfWeek(): Int`  | برگرداندن **شماره روز هفته** (تفسیر عدد بسته به پیاده‌سازی متفاوت است)      |

---

### 🗓️ رشته‌های تاریخ فرمت‌شده

| 🔧 تابع                                         | 📝 توضیحات                                                                           |
|--------------------------------------------------|----------------------------------------------------------------------------------------|
| `getFullDate(): String`                         | نمایش **تاریخ شمسی کامل** به‌صورت `yyyy/MM/dd` (مثال: `"1403/03/19"`)               |
| `getPersianMonthNameAndPersianYear(): String`   | ترکیب **نام ماه و سال شمسی** (مثال: `"خرداد 1403"`)                                 |
| `getMiladiFullDate(): String`                   | نمایش **تاریخ میلادی کامل** به‌صورت `yyyy/MM/dd` (مثال: `"2025/06/11"`)             |
| `getPersianFullDate(): String`                  | نمایش **تاریخ شمسی کامل با جزئیات** (مثال: `"چهارشنبه 19 خرداد 1403"`)              |

---

### ⏱️ ابزار Timestamp

| 🔧 تابع                 | 📝 توضیحات                                                                         |
|-------------------------|--------------------------------------------------------------------------------------|
| `getTimestamp(): Long`  | برگرداندن **تایم‌استمپ یونیکس** (تعداد میلی‌ثانیه از 1970-01-01) برای تاریخ فعلی  |






---


### 🔤 فونت‌های فارسی 

| متغیر فونت             | وزن فونت (Weight) | توضیح کاربردی                                    |
|------------------------|-------------------|---------------------------------------------------|
| `BoldFont`             | Bold (700)        | مناسب برای عنوان‌ها و بخش‌هایی با تأکید بالا     |
| `MediumFont`           | Medium (500)      | مناسب برای دکمه‌ها یا متن‌های نیمه‌برجسته        |
| `RegularFont`          | Regular (400)     | استفاده برای متن‌های عمومی و بدنه اصلی           |
| `LightFont`            | Light (300)       | مناسب برای متن‌های ثانویه یا توضیحی              |
| `ThinFont`             | Thin (200)        | مناسب برای متن‌های بسیار سبک و ظریف              |
| `HairlineFont`         | Hairline (100)    | باریک‌ترین وزن فونت، برای تزئینات یا متن خنثی    |

🔧 اگر فونت خاصی مدنظر شما نیست میتوانید از این فونت ها برای این datepicker استفاده کنید.

---


### ⚙️ پارامترهای قابل تنظیم ComposeDatePickerBottomSheet


| پارامتر            | نوع داده / توضیحات                                                                         |
| ------------------ | ------------------------------------------------------------------------------------------ |
| `modifier`         | `Modifier` — برای تنظیم نمای کلی Bottom Sheet.                                             |
| `titleModifier`    | `Modifier` — مخصوص عنوان بالای Bottom Sheet.                                               |
| `sheetState`       | `SheetState` — وضعیت فعلی Bottom Sheet. از `rememberModalBottomSheetState()` استفاده کنید |
| `controller`       | ✅ **ضروری** — کنترل‌کننده تاریخ انتخاب شده. باید در کامپوزبل ساخته و به خاطر سپرده شود    |
| `submitTitle`      | `String` — متن دکمه تایید (پیش‌فرض: تایید)                              |
| `titleBottomSheet` | `String` — عنوانی که در بالای Bottom Sheet نمایش داده می‌شود                              |
| `titleStyle`       | `TextStyle` — سبک (فونت، سایز، رنگ) عنوان                                                 |
| `textButtonStyle`  | `TextStyle` — سبک متن دکمه تایید                                                         |
| `unSelectedStyle`  | `TextStyle?` — سبک برای تاریخ‌های انتخاب‌نشده (اختیاری)                                   |
| `selectedStyle`    | `TextStyle?` — سبک تاریخ انتخاب‌شده (اختیاری)                                             |
| `buttonColor`      | `Color` —  رنگ پس‌زمینه دکمه تایید                                                        |
| `containerColor`   | `Color` — رنگ پس‌زمینه Bottom Sheet                                                       |
| `lineColor`        | `Color` — رنگ خطوط جداکننده داخل انتخابگر                                                |
| `shape`            | `Shape` — شکل گوشه‌های Bottom Sheet                                                      |
| `font`             | `Int?` —  فونت سفارشی                                                      |
| `onDateChanged`    | `(year: Int, month: Int, day: Int) -> Unit` — کال‌بک هنگام تغییر تاریخ انتخابی.            |
| `properties`       | `ModalBottomSheetProperties` — ویژگی‌های پیشرفته‌تر Bottom Sheet.                          |
| `onDismissRequest` | ✅ **ضروری** — کال‌بک هنگام بستن (مثلاً با کشیدن یا لمس خارج).                 |
| `onSubmitClick`    | ✅ **ضروری** — کال‌بک هنگام کلیک روی دکمه تایید.                                            |



---
### نمونه کد 
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
            //titleModifier = Modifier.padding(start = 10.dp)
        )
    }
}
```
