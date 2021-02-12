package com.androiddevs.drugsinspectr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androiddevs.drugsinspectr.Client.Client
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.nio.charset.Charset

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    lateinit var client: Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        client = Client()

    }

    override fun onResume() {
        super.onResume()

        button.setOnClickListener {

            Thread(Runnable {
                kotlin.run {
                    try {
                        client.openConnection()
                        client.sendData(send_mes.text.toString().toByteArray(Charset.defaultCharset()))
                        tv_get_mes.text = client.getData()
                        client.closeConnection()
                    }catch (e: IOException){
                        Log.d("Client", e.toString())
                    }
                }
            }).start()
        }
    }

}