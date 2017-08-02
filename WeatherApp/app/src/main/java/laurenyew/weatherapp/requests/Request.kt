package laurenyew.weatherapp.requests

import android.util.Log
import java.net.URL

/**
 * Created by laurenyew on 7/29/17.
 * Receive a json string from a given url
 */
class Request(val url: String) {
    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, "Request: " + forecastJsonStr)
    }
}
