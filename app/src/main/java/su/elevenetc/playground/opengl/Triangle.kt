package su.elevenetc.playground.opengl

import android.content.Context
import android.opengl.GLES30
import java.nio.FloatBuffer


/**
 * Created by eugene.levenetc on 02/02/2018.
 */
class Triangle(private val context: Context) {

    private lateinit var vertexBuffer: FloatBuffer

    // number of coordinates per vertex in this array
    private val COORDS_PER_VERTEX = 3
    private var coords = floatArrayOf(// in counterclockwise order:
            0.0f, 0.822008459f, 0.0f, // top
            -0.5f, -0.311004243f, 0.0f, // bottom left
            0.5f, -0.311004243f, 0.0f  // bottom right
    )

    private val color = Green

    private val vertexCount = coords.size / COORDS_PER_VERTEX
    private val vertexStride = COORDS_PER_VERTEX * 4
    private val program: GLProgram = GLProgram(R.raw.vertex, R.raw.fragment, context)
    var time: Float = 0f

    private val Position: String = "position"
    private val Time: String = "time"

    init {
        vertexBuffer = initVertices(coords)
        program.bindAttribute(Position)
    }

    public fun draw(mvp: FloatArray) {
        GLES30.glUseProgram(program.link)

        val mPositionHandle = GLES30.glGetAttribLocation(program.link, "position")
        GLES30.glEnableVertexAttribArray(program.links.get(Position))

//        // Prepare the triangle coordinate data
        GLES30.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX, GLES30.GL_FLOAT, false, vertexStride, vertexBuffer)

        time += 0.1f
        program.setFloat(Time, time)
        program.setV4("vColor", color)
        program.setV4Matrix("uMVPMatrix", mvp)

        // Draw the triangle
        GLES30.glDrawArrays(GLES30.GL_TRIANGLES, 0, vertexCount)


        // Disable vertex array
        GLES30.glDisableVertexAttribArray(mPositionHandle)

    }


}