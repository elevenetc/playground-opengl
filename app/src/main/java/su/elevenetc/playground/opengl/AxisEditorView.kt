package su.elevenetc.playground.opengl

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView

class AxisEditorView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    init {
        orientation = VERTICAL
        LayoutInflater.from(context).inflate(R.layout.axis_editor_view, this, true)
    }

    fun setData(name: String,
                dataX: AxisController.SeekData,
                dataY: AxisController.SeekData,
                dataZ: AxisController.SeekData,
                handlerX: (value: Float) -> Unit,
                handlerY: (value: Float) -> Unit,
                handlerZ: (value: Float) -> Unit) {

        findViewById<TextView>(R.id.text_title).text = name

        val seekEyeX = findViewById<SeekBar>(R.id.seek_x)
        val seekEyeY = findViewById<SeekBar>(R.id.seek_y)
        val seekEyeZ = findViewById<SeekBar>(R.id.seek_z)

        val valueEyeX = findViewById<TextView>(R.id.value_x)
        val valueEyeY = findViewById<TextView>(R.id.value_y)
        val valueEyeZ = findViewById<TextView>(R.id.value_z)

        AxisController(
                seekEyeX, seekEyeY, seekEyeZ,
                dataX,
                dataY,
                dataZ,
                {
                    valueEyeX.text = it.toString()
                    handlerX(it)
                },
                {
                    valueEyeY.text = it.toString()
                    handlerY(it)
                },
                {
                    valueEyeZ.text = it.toString()
                    handlerZ(it)
                }
        )
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
            bar.min = (data.min * 10).toInt()
            bar.max = (data.max * 10).toInt()
            bar.setProgress((data.current * 10).toInt(), false)

            handler(data.current.toFloat())

            bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    handler(progress / 10f)
                }

            })
        }

        class SeekData(val min: Float, val max: Float, var current: Float)
    }
}