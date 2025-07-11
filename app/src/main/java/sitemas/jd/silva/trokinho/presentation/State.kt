package sitemas.jd.silva.trokinho.presentation

sealed class State<T>(
    val data: T? = null,
    val message: String? = null,
) {
    class Initial<T> : State<T>()
    class Success<T>(data: T) : State<T>(data)
    class Error<T>(message: String, data: T? = null) : State<T>(data, message)
    class Loading<T>(data: T? = null) : State<T>(data)
    class Empty<T> : State<T>()
}