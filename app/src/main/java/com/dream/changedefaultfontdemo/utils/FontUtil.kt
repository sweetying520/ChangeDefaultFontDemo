package com.dream.changedefaultfontdemo.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.Typeface
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.dream.changedefaultfontdemo.MyApplication
import com.dream.changedefaultfontdemo.R

/**
 *function: waiting for add
 *
 *@author zy
 *@since 2021/6/7
 */
object FontUtil {

    const val NOTO_SANS_BOLD = R.font.noto_sans_bold
    const val MA_SHAN_ZHENG_REGULAR = R.font.ma_shan_zheng_regular

    /**缓存字体 Map*/
    private val cacheTypeFaceMap: HashMap<Int,Typeface> = HashMap()

    /**
     * 设置 NotoSanUIBold 字体
     */
    fun setNotoSanUIBold(mTextView: TextView){
        try {
            mTextView.typeface = getTypeface(NOTO_SANS_BOLD)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 设置 MaShanZhengRegular 字体
     */
    fun setMaShanZhengRegular(mTextView: TextView){
        try {
            mTextView.typeface = getTypeface(MA_SHAN_ZHENG_REGULAR)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 获取字体 Typeface 对象
     */
    fun getTypeface(fontResName: Int): Typeface? {
        val cacheTypeface = cacheTypeFaceMap[fontResName]
        if (cacheTypeface != null) {
            return cacheTypeface
        }
        return try {
            val typeface: Typeface? = ResourcesCompat.getFont(MyApplication.mApplication, fontResName)
            cacheTypeFaceMap[fontResName] = typeface!!
            typeface
        } catch (e: Exception) {
            e.printStackTrace()
            Typeface.DEFAULT
        }
    }

    /**
     * 设置字体大小不随系统设置变化
     * 重写 Activity 的 getResource
     */
    fun getResource(context: Context,resources: Resources,fontScale: Float): Resources{
        val configuration = resources.configuration
        if(configuration.fontScale != fontScale){
            configuration.fontScale = fontScale
            return context.createConfigurationContext(configuration).resources
        }
        return resources
    }

    /**
     * 设置字体大小不随系统设置变化
     * 重写 Activity 的 attachBaseContext
     */
    fun attachBaseContext(context: Context,fontScale: Float): Context{
        val configuration = context.resources.configuration
        configuration.fontScale = fontScale
        return context.createConfigurationContext(configuration)
    }
}