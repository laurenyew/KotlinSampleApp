package laurenyew.weatherapp

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import laurenyew.weatherapp.model.ForecastList

/**
 * Created by laurenyew on 7/28/17.
 * Recycler View adapter used to list the forecast across several days
 * (Author is assuming weekForecast is non-null b/c it's not notated as an optional)
 */
class ForecastListAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "$date - $description = $high/$low"
        }
    }

    override fun getItemCount(): Int {
        return weekForecast.dailyForecast.size
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}