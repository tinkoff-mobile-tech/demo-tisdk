package ru.tinkoff.demotisdk

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.tinkoff.tisdk.InsuranceBuyingEntrance

class MainActivity : AppCompatActivity() {

    private val insuranceBuyingEntrance = InsuranceBuyingEntrance.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        osago.setOnClickListener {
            insuranceBuyingEntrance.startOsago("osagoProcessId", this, null)
        }
        casco.setOnClickListener {
            insuranceBuyingEntrance.startCasco("cascoProcessId", this, null)
        }
    }
}
