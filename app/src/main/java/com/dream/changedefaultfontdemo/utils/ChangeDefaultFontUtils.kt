package com.dream.changedefaultfontdemo.utils

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.forEach
import com.dream.changedefaultfontdemo.R

/**
 * function: 全局替换字体工具类
 *
 * @author zy
 * @since 2021/6/7
 */
object ChangeDefaultFontUtils {

    const val NOTO_SANS_BOLD = R.font.noto_sans_bold


    /**
     * 方式一: 遍历布局的 ViewTree, 找到 TextView 及其子类进行批量替换
     *
     * @param mContext 上下文
     * @param rootView 根View
     */
    fun changeDefaultFont(mContext: Context?, rootView: View?){
        when(rootView){
            is ViewGroup -> {
                rootView.forEach {
                    changeDefaultFont(mContext,it)
                }
            }
            is TextView -> {
                try {
                    val typeface = ResourcesCompat.getFont(mContext!!, NOTO_SANS_BOLD)
                    val fontStyle = rootView.typeface?.style ?: Typeface.NORMAL
                    rootView.setTypeface(typeface,fontStyle)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }


    /**
     * 方式4：第2步：编写反射方法全局替换默认字体
     *
     * @param mContext 上下文
     */
    fun changeDefaultFont(mContext: Context) {
        try {
            val typeface = ResourcesCompat.getFont(mContext, NOTO_SANS_BOLD)
            val defaultField = Typeface::class.java.getDeclaredField("SERIF")
            defaultField.isAccessible = true
            defaultField[null] = typeface
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}