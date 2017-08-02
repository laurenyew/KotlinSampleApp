package laurenyew.weatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import laurenyew.weatherapp.requests.RequestForecastCommand
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {
//Deprecated
//    private val items = listOf<String>(
//            "Mon 6/23 - Sunny - 31/17",
//            "Tues 6/24 - Foggy - 21/8",
//            "Weds 6/25 - Cloudy - 22/17",
//            "Thurs 6/26 - Rainy - 18/11",
//            "Fri 6/27 - Foggy - 21/10",
//            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
//            "Sun 6/29 - Sunny - 20/7"
//    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Setup the list view
        setContentView(R.layout.activity_main)
        forecast_list
        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        toast("Hello World!")
        forecast_list
        async {
            val result = RequestForecastCommand("78759").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result)
            }
        }
    }
}
