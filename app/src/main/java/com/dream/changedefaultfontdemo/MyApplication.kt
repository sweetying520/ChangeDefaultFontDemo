package com.dream.changedefaultfontdemo

import android.app.Application
import com.dream.changedefaultfontdemo.utils.ChangeDefaultFontUtils

/**
 * function: 应用入口
 *
 * @author zy
 * @since 2021/6/7
 */
class MyApplication : Application() {

    companion object{
        lateinit var mApplication: Application
    }

    override fun onCreate() {
        super.onCreate()
        //方式4：第3步：在 Application 里面，调用替换的方法
//        ChangeDefaultFontUtils.changeDefaultFont(this)
    }
}



