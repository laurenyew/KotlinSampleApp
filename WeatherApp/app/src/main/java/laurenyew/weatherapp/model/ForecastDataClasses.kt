package laurenyew.weatherapp.model

/**
 * Created by laurenyew on 7/31/17.
 * Data model classes for UI to use
 */
data class ForecastList(val city: String, val country: String, private val dailyForecast: List<Forecast>) {
    val size: Int
        get() = dailyForecast.size

    operator fun get(position: Int) = dailyForecast[position]
}

data class Forecast(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)