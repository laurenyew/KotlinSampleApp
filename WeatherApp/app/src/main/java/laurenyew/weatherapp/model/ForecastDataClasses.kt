package laurenyew.weatherapp.model

/**
 * Created by laurenyew on 7/31/17.
 * Data model classes for UI to use
 */
data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)

data class Forecast(val date: String, val description: String, val high: Int, val low: Int)