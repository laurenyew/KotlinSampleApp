package laurenyew.weatherapp.requests

import com.google.gson.Gson
import laurenyew.weatherapp.data.ForecastResult
import java.net.URL

/**
 * Created by laurenyew on 7/31/17.
 * Request for the given 5 day forecast
 */
class ForecastRequest(private val zipCode: String) {
    companion object {
        private val APP_ID = "5c6984500a430a71931b8baf146d0c10"
        private val WEATHER_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?"
        private val QUERY = "mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$WEATHER_URL" + "APPID=$APP_ID&$QUERY&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}
