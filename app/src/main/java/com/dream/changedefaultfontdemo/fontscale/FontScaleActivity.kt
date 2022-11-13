package com.dream.changedefaultfontdemo.fontscale

import android.content.Context
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.dream.changedefaultfontdemo.R
import com.dream.changedefaultfontdemo.base.BaseActivity

class FontScaleActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_font_scale
    }

    override fun initView() {
        val fontScale = resources.configuration.fontScale
        val densityDpi = resources.configuration.densityDpi
        Log.d("erdai", "onCreate: " + fontScale + "  " + densityDpi)

        findViewById<Button>(R.id.btnChangeScale).setOnClickListener {
            resizeFont()
        }
    }


    interface DataCallback1<T> {
        fun onData(data: T)
    }

    /**
     * 显示拖动条对话框
     */
    fun showSeekBar(
        context: Context,
        @StringRes titleId: Int,
        max: Int,
        progress: Int,
        callback: DataCallback1<Int>
    ): AlertDialog {
        val seekBar = SeekBar(context)
        seekBar.max = max
        seekBar.progress = progress
        val padding = 80
        seekBar.setPadding(padding, padding, padding, 0)
        val dialog: AlertDialog = AlertDialog.Builder(context)
            .setTitle(titleId)
            .setView(seekBar)
            .setPositiveButton("ok") { dialog1, which -> callback.onData(seekBar.progress) }
            .setNegativeButton("cancel", null).create()
        dialog.show()
        return dialog
    }

    private fun resizeFont() {
        showSeekBar(this, R.string.app_name, 5, 0,object : DataCallback1<Int>{
            override fun onData(data: Int) {
                val value: Float = 0.5f + 0.5f * data
                Log.d("erdai", "onData value: $value")

                setFontScale(value)
            }
        })
    }
}