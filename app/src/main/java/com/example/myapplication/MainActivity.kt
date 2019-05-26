package com.example.myapplication

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val arr: ArrayList<String> = arrayListOf("", "")
        val observableStr = Observable.just("kka", "llaa")
        val observableInt = Observable.just(1, 2, 3)

        Observable
            .merge(observableStr, observableInt)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            }, {

            })

        Observable
            .zip(observableStr, observableInt, BiFunction<String, Int, String> { t1, t2 -> t1.plus(t2) })
            .subscribe({


            })

        Observable
            .just(1, 2, 3)

            .flatMap {
                Observable.just(it + 1)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
            })

        val behavior = BehaviorSubject.create<Int>()

        val aa = CompositeDisposable ()

        val observer= object : Observer<Int> {
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {
                aa.addAll(d)
            }

            override fun onNext(t: Int) {
                println("xxxx${t}")
            }

            override fun onError(e: Throwable) {
            }

        }

        val a = Maybe.empty<Int>()


        behavior.subscribe(observer)

        behavior.onNext(2)

        Thread.sleep(1000)
        aa.clear()
        behavior.subscribe({
            println("xxxx${it}")
        })
        behavior.onNext(3)



        val observableTest = Observable.just(1, 2, 3)
        observableTest.subscribe({},{})

    }


}
