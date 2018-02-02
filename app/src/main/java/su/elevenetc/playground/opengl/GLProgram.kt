package su.elevenetc.playground.opengl

import android.content.Context
import android.opengl.GLES30

/**
 * Created by eugene.levenetc on 02/02/2018.
 */
class GLProgram(vertexResourceId: Int, fragmentResourceId: Int, context: Context) {

    val link: Int = GLES30.glCreateProgram()
    val links: MutableMap<String, Int> = mutableMapOf()

    init {
        initShaders(link, vertexResourceId, fragmentResourceId, context)
    }

    fun getLink(name: String): Int {
        return links[name]
    }

    fun bindAttribute(name: String) {
        links[name] = GLES30.glGetAttribLocation(link, name)
    }

    fun bindUniform(name: String) {
        links[name] = GLES30.glGetUniformLocation(link, name)
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
}