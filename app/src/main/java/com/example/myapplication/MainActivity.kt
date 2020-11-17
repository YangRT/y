package com.example.myapplication

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.app.Activity
import android.app.AppComponentFactory
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.view.ViewStub
import android.webkit.PermissionRequest
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.util.jar.Manifest

// /storage/emulated/0/Screenshot/Screenshot_2020_1105_223556.png
class MainActivity : AppCompatActivity() {

    private  lateinit var viewStub : ViewStub
    private lateinit var databing : ActivityMainBinding
    var data = MutableLiveData(true)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databing = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        databing.viewStub.setOnInflateListener { stub, inflated ->

        }
        databing.btn.setOnClickListener {
            databing.viewStub.viewStub?.inflate()
        }
        data.observe(this, Observer {

        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode,resultCode,data)
        if (resultCode != Activity.RESULT_OK){
            return
        }
        var bm : Bitmap
        //外界的程序访问ContentProvider所提供数据 可以通过ContentResolver接口
        val resolver = getContentResolver()
        //此处的用于判断接收的Activity是不是你想要的那个
        if (requestCode == 0) {
            try {
                val originalUri = data?.getData();        //获得图片的uri
                Log.e("TAG","${originalUri}")

                val path = ImageGetPath.getPhotoPathFromContentUri(this,originalUri!!)
                Log.e("TAG","${path}")
            }catch (e:Exception){
                e.printStackTrace()
                Log.e("TAG",e.toString())

            }


    }
        }


    private fun getFilePathForN(
        context: Context,
        uri: Uri
    ): String? {
        try {
            val returnCursor =
                context.contentResolver.query(uri, null, null, null, null)
            val nameIndex = returnCursor!!.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            returnCursor.moveToFirst()
            val name = returnCursor.getString(nameIndex)
            val file = File(context.filesDir, name)
            val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
            val outputStream = FileOutputStream(file)
            var read = 0
            val maxBufferSize = 1 * 1024 * 1024
            val bytesAvailable: Int = inputStream!!.available()
            val bufferSize = Math.min(bytesAvailable, maxBufferSize)
            val buffers = ByteArray(bufferSize)
            while (inputStream.read(buffers).also({ read = it }) != -1) {
                outputStream.write(buffers, 0, read)
            }
            returnCursor.close()
            inputStream.close()
            outputStream.close()
            return file.getPath()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return null
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){

        }
    }
}