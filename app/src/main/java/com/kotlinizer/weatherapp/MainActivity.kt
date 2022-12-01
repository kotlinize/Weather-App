package com.kotlinizer.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kotlinizer.weatherapp.entities.WeatherData
import com.kotlinizer.weatherapp.theme.WeatherAppTheme
import com.kotlinizer.weatherapp.views.CurrentWeather
import com.kotlinizer.weatherapp.views.WeatherDay
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

	private val viewModel: MainActivityViewModel by viewModels()

	@OptIn(ExperimentalMaterialApi::class) override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			WeatherAppTheme {
				val refreshScope = rememberCoroutineScope()
				val weatherData = remember { viewModel.weatherData }
				var refreshing by remember { mutableStateOf(false) }

				fun refresh() = refreshScope.launch {
					refreshing = true
					delay(1000)
					viewModel.refresh()
					delay(1000)
					refreshing = false
				}

				val state = rememberPullRefreshState(refreshing, { refresh() })

				MainActivityScreen(refreshing = refreshing, refreshState = state, weatherData = weatherData)
			}
		}
	}

	@OptIn(ExperimentalMaterialApi::class) @Composable fun MainActivityScreen(
		refreshing: Boolean, refreshState: PullRefreshState, weatherData: MutableState<WeatherData?>
	) {
		WeatherAppTheme {
			Surface(modifier = Modifier.fillMaxSize()) {
				if (weatherData.value == null) {
					Box(Modifier.fillMaxSize()) {
						CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
					}
				} else {
					Column(modifier = Modifier.fillMaxSize()) {
						Box(
							Modifier
								.pullRefresh(refreshState, enabled = true)
								.fillMaxSize()
						) {
							Column(modifier = Modifier.fillMaxSize()) {
								LazyColumn {
									itemsIndexed(weatherData.value!!.list) { index, item ->
										if (index == 0) {
											CurrentWeather(weather = weatherData)
											Text(
												text = "${weatherData.value!!.list.size}-Day Forecast",
												style = MaterialTheme.typography.h6,
												fontWeight = FontWeight.Bold,
												modifier = Modifier.padding(start = 20.dp, top = 8.dp, bottom = 8.dp),
												color = MaterialTheme.colors.primary
											)
										}
										ListItem {
											WeatherDay(
												weatherDay = item,
												isLastItem = index == weatherData.value!!.list.count() - 1
											)
										}
									}
								}
							}
							PullRefreshIndicator(refreshing, refreshState, Modifier.align(Alignment.TopCenter))
						}
					}
				}
			}
		}
	}
}

