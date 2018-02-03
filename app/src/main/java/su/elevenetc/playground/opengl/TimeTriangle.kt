package su.elevenetc.playground.opengl

import android.content.Context

/**
 * Created by eugene.levenetc on 03/02/2018.
 */
class TimeTriangle(context: Context, vertexResourceId: Int, fragmentResourceId: Int, topVertex: Vertex, bottomLeftVertex: Vertex, bottomRightVertex: Vertex, color: Color) :
        Triangle(context, vertexResourceId, fragmentResourceId, topVertex, bottomLeftVertex, bottomRightVertex, color) {

    var time: Float = 0f

    override fun onScreenResize(width: Int, height: Int) {
        program.setV2(uResolution, floatArrayOf(width.toFloat(), height.toFloat()))
    }

    override fun beforeDraw() {
        time += 0.1f
        program.setFloat(uTime, time)
    }
}