package laurenyew.weatherapp.requests

import laurenyew.weatherapp.data.ForecastDataMapper
import laurenyew.weatherapp.model.ForecastList

/**
 * Created by laurenyew on 7/31/17.
 * Make the forecast request and convert the json response to our data model
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}