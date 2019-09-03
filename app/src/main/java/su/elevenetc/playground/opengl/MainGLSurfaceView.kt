package su.elevenetc.playground.opengl

import android.content.Context
import android.graphics.PixelFormat
import android.opengl.GLSurfaceView
import android.util.AttributeSet

class MainGLSurfaceView : GLSurfaceView {


    constructor(context: Context) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    val renderer: Renderer2D = Renderer2D(context).apply {
        addShape {

            Triangle(
                    context,
                    R.raw.vertex,
                    R.raw.shader_fragment_color,
                    Vertex(0.0f, 1f, 0.0f),
                    Vertex(-1f, -0.0f, 0.0f),
                    Vertex(1f, -0.0f, 0f),
                    Green
            )
        }
    }

    init {
        setTransparentBackground()
        setEGLContextClientVersion(3)
        setRenderer(renderer)
    }


    private fun setTransparentBackground() {
        setZOrderOnTop(true)
        setEGLConfigChooser(8, 8, 8, 8, 16, 0)
        holder.setFormat(PixelFormat.RGBA_8888)
    }
}