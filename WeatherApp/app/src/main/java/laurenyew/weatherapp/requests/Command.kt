package laurenyew.weatherapp.requests

/**
 * Created by laurenyew on 7/31/17.
 */
public interface Command<out T> {
    fun execute(): T
}