package com.example.startup_forge.AppUI.BookAppointment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.startup_forge.ui.theme.ThemeOrange

@Composable
fun CalendarView(
    selectedDate: MutableState<String>,
    modifier: Modifier = Modifier
) {
    val daysOfWeek = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
    val selectedDay = remember { mutableStateOf("") }

    Column(modifier = modifier) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            daysOfWeek.forEach {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                )
            }
        }
        for (i in 1..5) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (j in 1..7) {
                    val day = (i - 1) * 7 + j - selectedDayOfWeek(selectedDate.value)
                    val isCurrentMonthDay = day in 1..31
                    val isSelected = day.toString() == selectedDay.value

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .padding(4.dp)
                            .selectable(
                                selected = isSelected,
                                onClick = {
                                    if (isCurrentMonthDay) {
                                        selectedDay.value = day.toString()
                                        selectedDate.value = "$day/${getCurrentMonth()}/${getCurrentYear()}"
                                    }
                                }
                            )
                            .background(
                                color = when {
                                    isSelected -> Color.Blue
                                    !isCurrentMonthDay -> Color.LightGray
                                    else -> Color.Transparent
                                }
                            )
                    ) {
                        Text(
                            text = if (isCurrentMonthDay) day.toString() else "",
                            style = MaterialTheme.typography.bodySmall,
                            color = when {
                                isSelected -> Color.White
                                else -> ThemeOrange
                            },
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCalendarView() {
    val selectedDate = remember { mutableStateOf("") }
    CalendarView(selectedDate = selectedDate)
}

fun selectedDayOfWeek(selectedDate: String): Int {
    val date = selectedDate.split("/").firstOrNull()?.toIntOrNull() ?: 1
    val month = selectedDate.split("/")[1].toIntOrNull() ?: 1
    val year = selectedDate.split("/").lastOrNull()?.toIntOrNull() ?: 2022
    val cal = java.util.Calendar.getInstance()
    cal.set(year, month - 1, date)
    return cal.get(java.util.Calendar.DAY_OF_WEEK)
}

fun getCurrentMonth(): Int {
    val cal = java.util.Calendar.getInstance()
    return cal.get(java.util.Calendar.MONTH) + 1
}

fun getCurrentYear(): Int {
    val cal = java.util.Calendar.getInstance()
    return cal.get(java.util.Calendar.YEAR)
}