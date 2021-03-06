package su.elevenetc.playground.opengl

import android.content.Context
import android.opengl.GLES30
import java.nio.FloatBuffer

/**
 * Created by eugene.levenetc on 02/02/2018.
 */
class GLProgram(
        val vertexResourceId: Int,
        val fragmentResourceId: Int,
        val mode:Int = GLES30.GL_TRIANGLES) {

    val link: Int = GLES30.glCreateProgram()
    private val links: MutableMap<String, Int> = mutableMapOf()
    private val coordsPerVertex = 3

    fun init(context: Context){
        initShaders(link, vertexResourceId, fragmentResourceId, context)
        bindAttribute(aPosition)
    }

    private fun linkTo(attribute: String): Int {
        return links[attribute]!!
    }

    fun bindAttribute(name: String) {
        links[name] = GLES30.glGetAttribLocation(link, name)
    }

    fun bindUniform(name: String) {
        links[name] = GLES30.glGetUniformLocation(link, name)
    }

    fun setV2(name: String, data: FloatArray) {
        setV2(link, name, data)
    }

    fun setV4(name: String, data: FloatArray) {
        setV4(link, name, data)
    }

    fun setV4Matrix(name: String, data: FloatArray) {
        setV4Matrix(link, name, data)
    }

    fun setFloat(name: String, data: Float) {
        setFloat(link, name, data)
    }

    fun onDrawStart() {
        GLES30.glUseProgram(link)
    }

    fun drawVertexes(vertexBuffer: FloatBuffer) {

        val aPositionLink = linkTo(aPosition)

        GLES30.glEnableVertexAttribArray(aPositionLink)
        GLES30.glVertexAttribPointer(aPositionLink, coordsPerVertex, GLES30.GL_FLOAT, false, coordsPerVertex * 4, vertexBuffer)
        GLES30.glDrawArrays(mode, 0, vertexBuffer.limit() / coordsPerVertex)
        GLES30.glDisableVertexAttribArray(aPositionLink)
    }
}