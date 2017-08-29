package laurenyew.weatherapp.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import laurenyew.weatherapp.R
import laurenyew.weatherapp.model.Forecast
import laurenyew.weatherapp.model.ForecastList
import laurenyew.weatherapp.ui.utils.ctx
import org.jetbrains.anko.find

/**
 * Created by laurenyew on 7/28/17.
 * Recycler View adapter used to list the forecast across several days
 * (Author is assuming weekForecast is non-null b/c it's not notated as an optional)
 */
class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: OnItemClickListener)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int {
        return weekForecast.size
    }

    class ViewHolder(val view: View, val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.description)
        private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
        private val minTemperatureView = view.find<TextView>(R.id.minTemperature)

        //Bind the view holder to model information
        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "$high"
                minTemperatureView.text = "$low"
                itemView.setOnClickListener {
                    itemClick(this)
                }
            }
        }
    }
}