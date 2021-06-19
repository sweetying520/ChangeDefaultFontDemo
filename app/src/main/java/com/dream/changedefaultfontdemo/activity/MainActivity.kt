package com.dream.changedefaultfontdemo.activity

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.TextView
import com.dream.changedefaultfontdemo.R
import com.dream.changedefaultfontdemo.base.BaseActivity

class MainActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
    }

    fun toXmlFontActivity(view: View) {
        startActivity(Intent(this,XmlFontActivity::class.java))
    }
}