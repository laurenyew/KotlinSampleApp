package laurenyew.weatherapp

import android.app.Application

/**
 * Created by laurenyew on 1/10/18.
 */
class App : Application() {
    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}