package laurenyew.weatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import laurenyew.weatherapp.requests.RequestForecastCommand
import laurenyew.weatherapp.ui.ForecastListAdapter
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Setup the list view
        setContentView(R.layout.activity_main)
        forecastList.layoutManager = LinearLayoutManager(this)

        async {
            val result = RequestForecastCommand("78759").execute()
            uiThread {
                //Create adapter provide callback lambda item click listener
                forecastList.adapter = ForecastListAdapter(result,
                        { toast(it.date) })
            }
        }
    }
}
