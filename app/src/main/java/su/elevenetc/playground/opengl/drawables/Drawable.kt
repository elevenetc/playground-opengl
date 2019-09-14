package su.elevenetc.playground.opengl.drawables

import android.content.Context
import android.opengl.GLES30
import su.elevenetc.playground.opengl.*

/**
 * Created by eugene.levenetc on 03/02/2018.
 */
open class Drawable(
        val vertexes: Vertexes,
        val color: Color,
        val vertexResourceId: Int,
        val fragmentResourceId: Int,
        val mode: Int = GLES30.GL_TRIANGLES
) {

    private val arrayColor = toV4(color)
    protected val program = GLProgram(vertexResourceId, fragmentResourceId, mode)

    open fun onScreenResize(width: Int, height: Int) {

    }

    open fun beforeDraw() {

    }

    open fun onDraw(mvp: FloatArray) {
        program.onDrawStart()

        beforeDraw()

        program.setV4(uNames.uColor, arrayColor)
        program.setV4Matrix(uNames.uMvp, mvp)
        program.drawVertexes(vertexes.buffer)

        afterDraw()
    }

    open fun afterDraw() {

    }

    fun init(context: Context) {
        program.init(context)
    }
}