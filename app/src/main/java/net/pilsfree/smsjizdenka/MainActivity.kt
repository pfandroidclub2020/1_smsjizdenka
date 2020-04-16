package net.pilsfree.smsjizdenka

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        p35.setOnClickListener { posliSMS("PMDP35M") }
        p24.setOnClickListener { posliSMS("PMDP24H") }
        v35.setOnClickListener { posliSMS("PMDP35MV") }
        pv65.setOnClickListener { posliSMS("PMDP65MV") }
    }

    fun posliSMS(text:String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("smsto:90206")
        intent.putExtra("sms_body",text)
        startActivity(intent)
    }
}
