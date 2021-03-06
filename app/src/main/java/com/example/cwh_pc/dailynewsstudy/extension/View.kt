package com.example.cwh_pc.dailynewsstudy.extension

import android.view.View
import android.widget.Toast
import com.example.cwh_pc.dailynewsstudy.R
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.list_aditor_item.view.*
import java.util.concurrent.TimeUnit

/**
 * RxBinding 防止多次点击的扩展方法,此处还需要在生命周期结束时，结束绑定，以免造成内存泄漏
 */

fun View.click(function:(View)->Unit){
    RxView.clicks(this)
            .throttleFirst(500,TimeUnit.MILLISECONDS)
            .subscribe{
                function(this)
            }
}

fun View.longClick(function: (View) -> Unit){
    RxView.longClicks(this)
            .throttleFirst(500,TimeUnit.MILLISECONDS)
            .subscribe {
                function(this)
            }

}



var functionClick:(View)->Unit={
    when(it.id){
        R.id.mImageEditor->
           LogUtils.d(msg="have id")
        else -> LogUtils.d(msg="do nothing")
    }
}

