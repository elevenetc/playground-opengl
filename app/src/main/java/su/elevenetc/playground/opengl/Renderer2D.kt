package su.elevenetc.playground.opengl

import android.content.Context
import android.opengl.GLES30
import android.opengl.GLSurfaceView
import android.opengl.Matrix
import su.elevenetc.playground.opengl.drawables.Drawable
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class Renderer2D(val context: Context) : GLSurfaceView.Renderer {

    val eyeValue = SpaceValue()

    private val mvp = FloatArray(16)
    private val projection = FloatArray(16)
    private val view = FloatArray(16)

    private val shapes = mutableListOf<Drawable>()
    private val shapesFactories = mutableListOf<() -> Drawable>()

    fun addShape(drawable: () -> Drawable) {
        shapesFactories.add(drawable)
    }

    override fun onSurfaceCreated(unused: GL10, config: EGLConfig) {
        //GLES30.glClearColor(0.0f, 0.0f, 0.0f, 1.0f)

        shapesFactories.forEach {
            shapes.add(it())
        }
    }

    override fun onDrawFrame(unused: GL10) {
        GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT)

        Matrix.setLookAtM(
                view,
                0,
                eyeValue.x, eyeValue.y, eyeValue.z,
                0f, 0f, 0f,
                0f, 1.0f, 0.0f
        )

        Matrix.multiplyMM(mvp, 0, projection, 0, view, 0)

        shapes.forEach {
            it.onDraw(mvp)
        }

        //Thread.sleep(100)
    }

    override fun onSurfaceChanged(unused: GL10, width: Int, height: Int) {

        GLES30.glViewport(0, 0, width, height)
        val ratio: Float = (width.toFloat() / height.toFloat())
        Matrix.frustumM(
                projection,
                0,
                -ratio, ratio,
                -1f, 1f,
                0.3f, 10f
        )

        shapes.forEach {
            it.onScreenResize(width, height)
        }
    }

    class SpaceValue(
            var x: Float = 0f,
            var y: Float = 0f,
            var z: Float = 0f
    )


}