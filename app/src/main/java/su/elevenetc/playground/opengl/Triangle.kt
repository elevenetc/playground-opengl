package su.elevenetc.playground.opengl

import android.content.Context


/**
 * Created by eugene.levenetc on 02/02/2018.
 */
open class Triangle(
        context: Context,
        vertexResourceId: Int,
        fragmentResourceId: Int,
        topVertex: Vertex,
        bottomLeftVertex: Vertex,
        bottomRightVertex: Vertex,
        color: Color
) : Shape() {

    private val color = toV4(color)
    protected val program: GLProgram = GLProgram(vertexResourceId, fragmentResourceId, context)
    private val vertexes: Vertexes = Vertexes(
            topVertex.x, topVertex.y, topVertex.z,
            bottomLeftVertex.x, bottomLeftVertex.y, bottomLeftVertex.z,
            bottomRightVertex.x, bottomRightVertex.y, bottomRightVertex.z
    )

    override fun onDraw(mvp: FloatArray) {
        program.onDrawStart()

        beforeDraw()

        program.setV4(uColor, color)
        program.setV4Matrix(uMvp, mvp)
        program.drawVertexes(vertexes.buffer)

        afterDraw()
    }

    private fun initVertexes() {
        //Log.d("loc", vertexes.buffer[1].toString())
        //val loc = 6
        //var v = vertexes.buffer.get(loc)
        //v += Math.abs(Math.sin(time.toDouble())).toFloat()

        //vertexes.buffer.put(loc, v)
    }


}