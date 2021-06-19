package com.dream.changedefaultfontdemo.base

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.LayoutInflaterCompat
import com.dream.changedefaultfontdemo.utils.ChangeDefaultFontUtils


/**
 *function: Activity 基类
 *
 *@author zy
 *@since 2021/6/15
 */
abstract class BaseActivity: AppCompatActivity(){


    private val TAG: String? = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        //===================================== 方式一 start===========================================
//        super.onCreate(savedInstanceState)
//        val mRootView = LayoutInflater.from(this).inflate(getLayoutId(), null)
//        setContentView(mRootView)
//        ChangeDefaultFontUtils.changeDefaultFont(this,mRootView)
//        initView()
        //===================================== 方式一 end===========================================


        //===================================== 方式二 start===========================================
//        LayoutInflaterCompat.setFactory2(layoutInflater,object : LayoutInflater.Factory2{
//            override fun onCreateView(parent: View?, name: String, context: Context, attrs: AttributeSet
//            ): View? {
//                var view: View? = null
//                if(1 == name.indexOf(".")){
//                    //表示自定义 View
//                    //通过反射创建
//                    view = layoutInflater.createView(name,null,attrs)
//                }
//
//                if(view == null){
//                    //通过系统创建一系列 appcompat 的 View
//                    view = delegate.createView(parent, name, context, attrs)
//                }
//
//                if(view is TextView){
//                    //如果是 TextView 或其子类，则进行字体的替换
//                    ChangeDefaultFontUtils.changeDefaultFont(this@BaseActivity,view)
//                }
//
//                return view
//            }
//
//            override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
//                return null
//            }
//
//        })
//        super.onCreate(savedInstanceState)
//        setContentView(getLayoutId())
//        initView()
        //===================================== 方式二 end===========================================


        //无替换
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
    }

    /**获取布局Id*/
    abstract fun getLayoutId(): Int

    /**初始化*/
    abstract fun initView()
}