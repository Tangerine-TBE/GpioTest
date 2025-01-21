package cn.com.dihealth

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cn.com.dihealth.util.GpioUtils

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.btn_close_usb1).setOnClickListener(this)
        findViewById<Button>(R.id.btn_close_usb2).setOnClickListener(this)
        findViewById<Button>(R.id.btn_close_usb3).setOnClickListener(this)
        findViewById<Button>(R.id.btn_open_usb1).setOnClickListener(this)
        findViewById<Button>(R.id.btn_open_usb2).setOnClickListener(this)
        findViewById<Button>(R.id.btn_open_usb3).setOnClickListener(this)
        findViewById<Button>(R.id.btn_open_ttyPower).setOnClickListener(this)
        findViewById<Button>(R.id.btn_close_ttyPower).setOnClickListener(this)
    }

    private fun openGpioUsb1PowerTrue(){
       val returnValue =  GpioUtils.setUsb1Power(true)
        Log.e("TAG",returnValue.toString());
    }
    private fun openGpioUsb2PowerTrue(){
        val returnValue =   GpioUtils.setUsb2Power(true)
        Log.e("TAG",returnValue.toString());

    }
    private fun openGpioUsb3PowerTrue(){
        val returnValue =   GpioUtils.setUsb3Power(true)
        Log.e("TAG",returnValue.toString());

    }
    private fun closeTTyPowerFalse(){
        val returnValue =  GpioUtils.setTTyPower(false)
        Log.e("TAG",returnValue.toString());

    }
    private fun openTTyPowerTrue(){
        val returnValue =  GpioUtils.setTTyPower(true)
        Log.e("TAG",returnValue.toString());

    }

    private fun closeGpioUsb1PowerFalse(){
        val returnValue =  GpioUtils.setUsb1Power(false)
        Log.e("TAG",returnValue.toString());

    }
    private fun closeGpioUsb2PowerFalse(){
        val returnValue =  GpioUtils.setUsb2Power(false)
        Log.e("TAG",returnValue.toString());

    }
    private fun closeGpioUsb3PowerFalse(){
        val returnValue =   GpioUtils.setUsb3Power(false)
        Log.e("TAG",returnValue.toString());

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_close_usb1 -> {
                closeGpioUsb1PowerFalse()

            }
            R.id.btn_close_usb2 -> {
                closeGpioUsb2PowerFalse()

            }
            R.id.btn_close_usb3 -> {
                closeGpioUsb3PowerFalse()

            }
            R.id.btn_open_usb1 -> {
                openGpioUsb1PowerTrue()

            }
            R.id.btn_open_usb2 -> {
                openGpioUsb2PowerTrue()

            }
            R.id.btn_open_usb3 -> {
                openGpioUsb3PowerTrue()

            }
            R.id.btn_close_ttyPower->{
                closeTTyPowerFalse()
            }
            R.id.btn_open_ttyPower->{
                openTTyPowerTrue()
            }
        }
    }
}