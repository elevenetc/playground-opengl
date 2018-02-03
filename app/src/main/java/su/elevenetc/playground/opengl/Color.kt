package su.elevenetc.playground.opengl

/**
 * Created by eugene.levenetc on 03/02/2018.
 */
data class Color(val r: Float, val g: Float, val b: Float, val a: Float)

fun toV4(color: Color): FloatArray {
    return floatArrayOf(color.r, color.g, color.b, color.a)
}