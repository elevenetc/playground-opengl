package su.elevenetc.playground.opengl

class Color(val r: Float, val g: Float, val b: Float, val a: Float) {

    companion object {
        val White = Color(1f, 1f, 1f, 1.0f)
        val Red = Color(1f, 0f, 0f, 1.0f)
        val Green = Color(0f, 1f, 0f, 1.0f)
        val Blue = Color(0f, 0f, 1f, 1f)
        val Magenta = Color(0f, 0.8f, 1f, 1f)
        val Sky = Color(0f, 0.6f, 1f, 1f)
        val DarkBlue = Color(0f, 0f, 0.8f, 1f)
    }
}

fun toV4(color: Color): FloatArray {
    return floatArrayOf(color.r, color.g, color.b, color.a)
}