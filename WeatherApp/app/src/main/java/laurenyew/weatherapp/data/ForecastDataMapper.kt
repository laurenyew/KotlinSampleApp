package laurenyew.weatherapp.data

import laurenyew.weatherapp.model.ForecastList
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import laurenyew.weatherapp.model.Forecast as ModelForecast

/**
 * Created by laurenyew on 7/31/17.
 * Map the data model classes to the ui model classes
 */
class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country, convertForecastListToModel(forecast.list))
    }

    /**
     * Convert a given data forecast from gson, convert it to our UI model
     */
    private fun convertForecastListToModel(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            //Pass a new variable dt to the forecast starting from now,
            //increasing on each item per day
            val dt = Calendar.getInstance().timeInMillis +
                    TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToModel(forecast.copy(dt = dt))
        }
    }

    /**
     * Convert a single forecast data item to its model form
     */
    private fun convertForecastItemToModel(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description,
                forecast.temp.max.toInt(),
                forecast.temp.min.toInt())
    }

    /**
     * Convert date time in millis to a formatted date string
     */
    private fun convertDate(date: Long): String {
        val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return dateFormatter.format(date)
    }
}