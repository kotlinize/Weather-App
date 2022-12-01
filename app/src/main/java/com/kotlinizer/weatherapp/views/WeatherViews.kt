package com.kotlinizer.weatherapp.views

import android.graphics.Typeface
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kotlinizer.weatherapp.entities.WeatherData
import com.kotlinizer.weatherapp.entities.WeatherDay
import com.kotlinizer.weatherapp.theme.ComposeColors
import com.kotlinizer.weatherapp.util.dayOfWeek

@Composable fun CurrentWeather(weather: MutableState<WeatherData?>) {
	val currentWeather = weather.value!!.list.first()
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.background(
				brush = Brush.linearGradient(
					colors = listOf(
						ComposeColors.DENIM, ComposeColors.DENIM, ComposeColors.BOMBAY
					)
				)
			)
	) {
		Column(
			modifier = Modifier
				.align(Alignment.TopCenter)
				.padding(8.dp)
		) {
			Text(
				text = weather.value!!.city!!.name + ", GA",
				style = MaterialTheme.typography.h6,
				fontWeight = FontWeight.Normal,
				fontFamily = FontFamily(Typeface.SANS_SERIF),
				modifier = Modifier.align(Alignment.CenterHorizontally),
				color = Color.White
			)
			Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
				Icon(
					painter = painterResource(currentWeather.weatherList.first().iconRes()),
					contentDescription = null,
					tint = MaterialTheme.colors.onBackground,
					modifier = Modifier
						.size(40.dp)
						.align(Alignment.CenterVertically)
				)
				Text(
					text = currentWeather.weatherList[0].main,
					style = MaterialTheme.typography.body1,
					fontWeight = FontWeight.Light,
					fontFamily = FontFamily(Typeface.SANS_SERIF),
					modifier = Modifier
						.padding(start = 8.dp)
						.align(Alignment.CenterVertically),
					color = Color.White
				)
			}
			Text(
				text = "${currentWeather.currentTemp}°",
				style = MaterialTheme.typography.h1,
				fontWeight = FontWeight.ExtraLight,
				color = Color.White,
				modifier = Modifier.align(Alignment.CenterHorizontally)
			)
			Text(
				text = "Feels like ${currentWeather.currentFeelsLikeTemp}°",
				style = MaterialTheme.typography.body1,
				fontWeight = FontWeight.Light,
				color = Color.White,
				modifier = Modifier.align(Alignment.CenterHorizontally)
			)
		}
	}
}

@Composable fun WeatherDay(weatherDay: WeatherDay, isLastItem: Boolean) {
	val isOpened = remember { mutableStateOf(false) }
	Column(modifier = Modifier.clickable(true, onClick = { isOpened.value = !isOpened.value })) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(8.dp)
		) {
			Icon(
				painter = painterResource(weatherDay.weatherList.first().iconRes()),
				contentDescription = null,
				tint = MaterialTheme.colors.onBackground,
				modifier = Modifier
					.size(60.dp)
					.padding(end = 8.dp)
			)
			Column(modifier = Modifier.align(Alignment.Top)) {
				Text(
					text = weatherDay.date.dayOfWeek,
					style = MaterialTheme.typography.body1,
					fontWeight = FontWeight.Bold,
					modifier = Modifier.padding(4.dp),
					color = MaterialTheme.colors.primary
				)
				Text(
					text = weatherDay.weatherList.first().main,
					style = MaterialTheme.typography.body1,
					fontWeight = FontWeight.Light,
					modifier = Modifier.padding(4.dp),
					color = Color(0xFF97A2AA)
				)
				AnimatedVisibility(visible = isOpened.value) {
					Column {
						Text(
							text = "Humidity: ${weatherDay.humidity}%",
							style = MaterialTheme.typography.body1,
							fontWeight = FontWeight.Light,
							modifier = Modifier.padding(4.dp),
							color = Color(0xFF97A2AA)
						)
						Text(
							text = "Pressure: ${weatherDay.pressure} hPa",
							style = MaterialTheme.typography.body1,
							fontWeight = FontWeight.Light,
							modifier = Modifier.padding(4.dp),
							color = Color(0xFF97A2AA)
						)
						Text(
							text = "Wind: ${weatherDay.speed ?: 0} km/h",
							style = MaterialTheme.typography.body1,
							fontWeight = FontWeight.Light,
							modifier = Modifier.padding(4.dp),
							color = Color(0xFF97A2AA)
						)
					}
				}
			}
			Column(
				modifier = Modifier
					.align(Alignment.Top)
					.fillMaxWidth()
					.padding(end = 4.dp)
			) {
				Text(
					text = "${weatherDay.temp.max.toInt()}°",
					style = MaterialTheme.typography.body1,
					fontWeight = FontWeight.Bold,
					modifier = Modifier
						.padding(4.dp)
						.fillMaxWidth(),
					textAlign = TextAlign.End,
					color = MaterialTheme.colors.primary
				)
				Text(
					text = "${weatherDay.temp.min.toInt()}°",
					style = MaterialTheme.typography.body1,
					fontWeight = FontWeight.Light,
					modifier = Modifier
						.padding(4.dp)
						.fillMaxWidth(),
					textAlign = TextAlign.End,
					color = Color(0xFF97A2AA)
				)
			}
		}
		if (!isLastItem) {
			Divider(color = MaterialTheme.colors.secondary)
		}
	}
}