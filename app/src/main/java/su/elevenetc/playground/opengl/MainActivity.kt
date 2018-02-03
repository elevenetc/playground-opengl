package su.elevenetc.playground.opengl

import android.content.Context
import android.opengl.GLES30
import android.opengl.GLSurfaceView
import android.opengl.Matrix
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import su.elevenetc.playground.opengl.MainActivity.Renderer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ref: Context = this

        val rootContainer = findViewById<ViewGroup>(R.id.root_container)

        rootContainer.addView(MainGLSurfaceView(this))

        val supportedOpenGL = supportedOpenGL(this)


        findViewById<Button>(R.id.btn_z).setOnClickListener {
            Toast.makeText(ref, "sss!", Toast.LENGTH_SHORT).show()
        }
    }

    class MainGLSurfaceView(context: Context) : GLSurfaceView(context) {

        private var renderer: MainActivity.Renderer = Renderer(context)

        init {
            setEGLContextClientVersion(3)
            setRenderer(renderer)
        }
    }

    class Renderer(val context: Context) : GLSurfaceView.Renderer {

        private lateinit var triangle: Shape

        private val mvp = FloatArray(16)
        private val projection = FloatArray(16)
        private val view = FloatArray(16)

        override fun onSurfaceCreated(unused: GL10, config: EGLConfig) {
            triangle = TimeTriangle(
                    context,
                    R.raw.vertex_vertical_scale,
                    R.raw.fragment,
                    Vertex(0.0f, 0.5f, 0.0f),
                    Vertex(-0.25f, -0.0f, 0.0f),
                    Vertex(0.25f, -0.0f, 0f),
                    White
            )
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 1.0f)
        }

        override fun onDrawFrame(unused: GL10) {
            GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT)

            Matrix.setLookAtM(
                    view,
                    0,
                    0f, 0f, -3f,
                    0f, 0f, 0f,
                    0f, 1.0f, 0.0f
            )

            Matrix.multiplyMM(mvp, 0, projection, 0, view, 0)

            triangle.onDraw(mvp)

            Thread.sleep(100)
        }

        override fun onSurfaceChanged(unused: GL10, width: Int, height: Int) {

            GLES30.glViewport(0, 0, width, height)
            val ratio: Float = (width.toFloat() / height.toFloat())
            Matrix.frustumM(
                    projection,
                    0,
                    -ratio, ratio,
                    -1f, 1f,
                    3f, 7f
            )

            triangle.onScreenResize(width, height)
        }


    }
}
