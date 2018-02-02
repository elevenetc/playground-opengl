package su.elevenetc.playground.opengl

import android.content.Context
import android.opengl.GLES30
import java.nio.FloatBuffer


/**
 * Created by eugene.levenetc on 02/02/2018.
 */
class Triangle(context: Context) {

    private lateinit var vertexBuffer: FloatBuffer
    private lateinit var coords: FloatArray
    var time: Float = 0f

    private val color = Green
    private val program: GLProgram = GLProgram(R.raw.vertex, R.raw.fragment, context)

    init {
        initVertexes()
    }

    fun draw(mvp: FloatArray) {
        GLES30.glUseProgram(program.link)

        time += 0.1f
        program.setFloat("time", time)
        program.setV4("vColor", color)
        program.setV4Matrix("uMVPMatrix", mvp)

        program.drawVertexes(vertexBuffer)

        initVertexes()
    }

    private fun initVertexes() {

        coords = floatArrayOf(// in counterclockwise order:
                0.0f, 0.822008459f, 0.0f, // top
                -0.5f, -0.311004243f, 0.0f, // bottom left
                0.5f, -0.311004243f, Math.abs(Math.sin(time.toDouble())).toFloat()  // bottom right
        )

        vertexBuffer = initVertices(coords)
    }


}