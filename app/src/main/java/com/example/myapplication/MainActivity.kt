package com.example.myapplication

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import io.reactivex.*
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val kaka = ""
    private val hihi = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ("kaka" as String).toString()
        (1 as Int).toString()
        findViewById<TextView>(R.id.click).setOnClickListener { kaka ->

        }
        findViewById<TextView>(R.id.click).setOnTouchListener { view, motionEvent ->
            false
        }
    }
}
