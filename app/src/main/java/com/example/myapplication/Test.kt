package com.example.myapplication

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.locks.Lock


class Test {

    val sum  =  {x:Int,y:Int -> x+y}

    // 协程
     fun test(){
        GlobalScope.launch {
            delay(1000)
            
        }
    }


    // 高阶函数是将函数作为返回值或参数的函数
    fun <T> lock(lock: Lock,body:()->T):T{
        lock.lock()
        try {
            return body()
        }finally {
            lock.unlock()
        }

    }

    // 伴生对象 类似 static
    companion object{
        const val V = 9
    }




}
// 最新专辑
class Artist {
    var name: String? = null
    var id = 0
    var picId = 0
    var img1v1Id = 0
    var briefDesc: String? = null
    var picUrl: String? = null
    var img1v1Url: String? = null
    var albumSize = 0
    var alias: List<String>? = null
    var trans: String? = null
    var musicSize = 0
    var topicPerson = 0
    var picId_str: String? = null
    var img1v1Id_str: String? = null
}

class Artists {
    var name: String? = null
    var id = 0
    var picId = 0
    var img1v1Id = 0
    var briefDesc: String? = null
    var picUrl: String? = null
    var img1v1Url: String? = null
    var albumSize = 0
    var alias: List<String>? = null
    var trans: String? = null
    var musicSize = 0
    var topicPerson = 0
    var img1v1Id_str: String? = null
}

class Albums {
    var name: String? = null
    var id = 0
    var type: String? = null
    var size = 0
    var picId = 0
    var blurPicUrl: String? = null
    var companyId = 0
    var pic = 0
    var picUrl: String? = null
    var publishTime = 0
    var description: String? = null
    var tags: String? = null
    var company: String? = null
    var briefDesc: String? = null
    var artist: Artist? = null
    var songs: String? = null
    var alias: List<String>? = null
    var status = 0
    var copyrightId = 0
    var commentThreadId: String? = null
    var artists: List<Artists>? = null
    var paid = false
    var onSale = false
    var picId_str: String? = null

}

class Root {
    var code = 0
    var albums: List<Albums>? = null
}

