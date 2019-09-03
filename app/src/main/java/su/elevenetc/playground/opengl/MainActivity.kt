package su.elevenetc.playground.opengl

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.SeekBar
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rootContainer = findViewById<View>(R.id.root_container)

        val seekEyeX = rootContainer.findViewById<SeekBar>(R.id.seek_eye_x)
        val seekEyeY = rootContainer.findViewById<SeekBar>(R.id.seek_eye_y)
        val seekEyeZ = rootContainer.findViewById<SeekBar>(R.id.seek_eye_z)

        val valueEyeX = rootContainer.findViewById<TextView>(R.id.value_eye_x)
        val valueEyeY = rootContainer.findViewById<TextView>(R.id.value_eye_y)
        val valueEyeZ = rootContainer.findViewById<TextView>(R.id.value_eye_z)

        val surfaceView = findViewById<MainGLSurfaceView>(R.id.surface_view)

        AxisController(
                seekEyeX, seekEyeY, seekEyeZ,
                AxisController.SeekData(-10, 10, 0, 100f),
                AxisController.SeekData(-10, 10, 0, 100f),
                AxisController.SeekData(-10, 10, -6, 100f),
                {
                    valueEyeX.setText(it.toString())
                    surfaceView.renderer.eyeValue.x = it
                },
                {
                    valueEyeY.setText(it.toString())
                    surfaceView.renderer.eyeValue.y = it
                },
                {
                    valueEyeZ.setText(it.toString())
                    surfaceView.renderer.eyeValue.z = it
                }
        )

        //val ref: Context = this
        //val rootContainer = findViewById<ViewGroup>(R.id.root_container)
        //rootContainer.addView(MainGLSurfaceView(this))
        //val supportedOpenGL = supportedOpenGL(this)
    }

    class AxisController(
            val seekX: SeekBar,
            val seekY: SeekBar,
            val seekZ: SeekBar,
            val dataX: SeekData,
            val dataY: SeekData,
            val dataZ: SeekData,
            val handlerX: (value: Float) -> Unit,
            val handlerY: (value: Float) -> Unit,
            val handlerZ: (value: Float) -> Unit
    ) {

        init {
            initBar(seekX, dataX, handlerX)
            initBar(seekY, dataY, handlerY)
            initBar(seekZ, dataZ, handlerZ)
        }

        private fun initBar(bar: SeekBar, data: SeekData, handler: (value: Float) -> Unit) {
            bar.min = data.min * data.mult.toInt()
            bar.max = data.max * data.mult.toInt()
            bar.setProgress(data.current, false)

            handler(data.current.toFloat())

            bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    handler(progress / data.mult)
                }

            })
        }

        class SeekData(val min: Int, val max: Int, var current: Int, val mult: Float)
    }


}
