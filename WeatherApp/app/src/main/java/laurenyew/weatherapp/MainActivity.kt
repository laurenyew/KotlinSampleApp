package laurenyew.weatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    private val items = listOf<String>(
            "Mon 6/23 - Sunny - 31/17",
            "Tues 6/24 - Foggy - 21/8",
            "Weds 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Setup the list view
        setContentView(R.layout.activity_main)
        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)

        toast("Hello World!")

        val APP_ID = "5c6984500a430a71931b8baf146d0c10"
        val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?"
        val QUERY = "q=78759&mode=json&units=metric&cnt=7"
        val COMPLETE_URL = "$URL" + "APPID=$APP_ID&$QUERY"

        Log.d(javaClass.simpleName, "Query: $COMPLETE_URL")
        doAsync {
            Request(COMPLETE_URL).run()
            uiThread { longToast("Request performed") }
        }
    }
}
