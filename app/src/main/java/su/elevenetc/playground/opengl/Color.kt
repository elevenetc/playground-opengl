package su.elevenetc.playground.opengl

/**
 * Created by eugene.levenetc on 03/02/2018.
 */
class Color(val r: Float, val g: Float, val b: Float, val a: Float){
    companion object{
        val White = Color(1f, 1f, 1f, 1.0f)
        val Red = Color(1f, 0f, 0f, 1.0f)
        val Green = Color(0.63671875f, 0.76953125f, 0.22265625f, 1.0f)
        val Blue = Color(0f, 0f, 1f, 1f)
    }
}

fun toV4(color: Color): FloatArray {
    return floatArrayOf(color.r, color.g, color.b, color.a)
}