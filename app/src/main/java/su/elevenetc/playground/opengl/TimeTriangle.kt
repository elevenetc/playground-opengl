package su.elevenetc.playground.opengl

import android.content.Context

/**
 * Created by eugene.levenetc on 03/02/2018.
 */
class TimeTriangle(context: Context, vertexResourceId: Int, fragmentResourceId: Int, topVertex: Vertex, bottomLeftVertex: Vertex, bottomRightVertex: Vertex, color: Color) :
        Triangle(context, vertexResourceId, fragmentResourceId, topVertex, bottomLeftVertex, bottomRightVertex, color) {

    var time: Float = 0f
    var w: Int = 0
    var h: Int = 0

    override fun onScreenResize(width: Int, height: Int) {
        w = width
        h = height
    }

    override fun beforeDraw() {
        time += 0.1f
        program.setFloat(uTime, time)
        program.setV2(uResolution, floatArrayOf(w.toFloat(), h.toFloat()))
    }
}