package su.elevenetc.playground.opengl

import android.content.Context
import android.graphics.PixelFormat
import android.opengl.GLSurfaceView
import android.util.AttributeSet
import su.elevenetc.playground.opengl.drawables.Line
import su.elevenetc.playground.opengl.drawables.PlaneUnitXY
import su.elevenetc.playground.opengl.drawables.PlaneUnitXZ
import su.elevenetc.playground.opengl.drawables.PlaneUnitYZ

class MainGLSurfaceView : GLSurfaceView {


    constructor(context: Context) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    val renderer: Renderer2D = Renderer2D(context).apply {

        //        addShape {
//            Triangle(
//                    context,
//                    R.raw.vertex,
//                    R.raw.shader_fragment_color,
//                    Vertex(0.0f, 1f, 1.0f),
//                    Vertex(-1f, -0.0f, 1.0f),
//                    Vertex(1f, -0.0f, 1.0f),
//                    Red
//            )
//        }

        //Y
        addShape {
            Line(
                    Vertex(0.0f, 0f, 0.0f),
                    Vertex(0.0f, 10f, 0.0f),
                    color = Color.Red
            )
        }

        //X
        addShape {
            Line(
                    Vertex(0.0f, 0f, 0.0f),
                    Vertex(10.0f, 0f, 0.0f),
                    color = Color.Green
            )
        }

        //Z
        addShape {
            Line(
                    Vertex(0.0f, 0f, 0.0f),
                    Vertex(0.0f, 0f, 10.0f),
                    color = Color.Blue
            )
        }


        addShape {
            PlaneUnitXY(Color.Green)
        }

        addShape {
            PlaneUnitXZ(Color.DarkBlue)
        }

        addShape {
            PlaneUnitYZ(Color.Sky)
        }


//        addShape {
//            Plane(
//                    Vertex(0f, 0f, 0f),
//                    Vertex(0f, 1f, 0f),
//                    Vertex(1f, 1f, 0f),
//                    Vertex(1f, 0f, 0f)
//            )
//        }
//
//        addShape {
//            Plane(
//                    Vertex(0f, 0f, 0f),
//                    Vertex(0f, 1f, 0f),
//                    Vertex(0f, 1f, 1f),
//                    Vertex(0f, 0f, 1f)
//            )
//        }
//
//        addShape {
//            Plane(
//                    Vertex(0f, 0f, 0f),
//                    Vertex(1f, 0f, 0f),
//                    Vertex(1f, 0f, 1f),
//                    Vertex(0f, 0f, 1f)
//            )
//        }
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