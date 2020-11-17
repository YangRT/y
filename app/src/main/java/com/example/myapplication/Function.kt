package com.example.myapplication

//fun sum(a:Int,b:Int):Int{
//    return a+b
//}
// 简略写法
fun sum(a:Int,b:Int) = a+b
// 函数调用
val result = sum(2,3)

// 默认参数
fun test(a:Int,b:Boolean = false,c:String="777"):Int{
    return a
}
// 含有默认参数调用
val temp = test(2)
// 命名参数
val temp2  = test(2,c="666")

// 省略花括号
fun double(x: Int): Int = x * 2

// 可变长参数
fun <T> asList(vararg ts:T):List<T>{
    val list = ArrayList<T>()
    for (t in ts)
        list.add(t)
    return list
}
// 调用
val list = asList(1,2,3)


// 局部函数 即一个函数在另一个函数里面
// 局部函数可以访问外部函数的局部变量
fun inFunc(l:List<String>){
    fun insinde(){
        print(l.size)
    }
}

// 泛型函数
fun <T> singletonList(item: T): List<T>{
    val t = ArrayList<T>()
    t.add(item)
    return t
}

// 



