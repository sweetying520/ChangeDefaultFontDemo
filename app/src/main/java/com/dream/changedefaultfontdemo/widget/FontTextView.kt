package com.dream.changedefaultfontdemo.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.dream.changedefaultfontdemo.utils.ChangeDefaultFontUtils

/**
 *function: 自定义字体 TextView
 *
 *@author zy
 *@since 2021/6/15
 */
class FontTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : AppCompatTextView(context, attrs, defStyleAttr) {

        init {
            try {
                ChangeDefaultFontUtils.changeDefaultFont(getContext(),this)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
}