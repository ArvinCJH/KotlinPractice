package com.liyafeng.kotlinproject.practice

class Practice {


    //region 定义函数，拓展函数


    fun sum(x: Int, y: Int): Int {
        return x + y;
    }

    //用等于，当函数只有一个返回值，可以省略返回值的声明,
    fun sum1(x: Int, y: Int) = x + y

    fun sum2(x: Int, y: Int): Int = x + y


    //无返回值
    fun printSum(x: Int, y: Int): Unit {
        print(x + y);
    }

    //无返回值可以不写
    fun printSum1(x: Int, y: Int) {
        print(x + y);
    }

    //返回Unit
    fun printSum2(x: Int, y: Int) = print(x + y)


    /**
     * 拓展函数
     * 这个在类内声明，只能再类内用
     * 在file声明，可以在包内用，包外用要import
     */
    fun String.happy() {

        toString() + "ss"

        "ss".happy()
    }
    //endregion


    //region 常量 变量


    //    val a = 3;
//    var d = true
    fun Var(): Unit {
        //定义常量
        val a: Double = 2.0
        val b = 1//不用写类型，编译器自动推断

        val c: Int//要么一开始就赋值，要么指明常量类型
        c = 3


        //变量
        var d = 3
        d++
        print(d)

        //这个是错误的，{} 内，局部变量是优先的，但是全局变量（顶层变量）和局部变量名称一样是不好的
//        d=false


        //Kotlin 的块注释可以嵌套。java则不支持这种写法

        /*
        * /*
        *
        * */
        */


    }


    //endregion


    //region 字符串 条件表达式 ,try-catch

    fun ss() {

        val a = 1
        //直接引用
        val s: String = "this is $a"


        //直接在字符串中调用函数
        val s1 = "${s.replace("s", "a")} is good"
        print(s1)

        val s2 = "${a.plus(10.0)} is very good"
        print(s2)


    }

    fun foo14() {
        val s = ""
        //遍历字符串
        for (c in s) {
            print(c.isLowerCase())
        }

        //在大多数情况下，优先使用字符串模板或原始字符串而不是字符串连接。
        val d = "123" + "sdf"

        //原始字符串
        val a = """
           |  for (c in s) {
           |print(c.isLowerCase())
           | ${d.length} 可以使用表达式
           |
            }
        """.trimMargin().trimMargin("|")

        //trimMargin() 函数去除前导空格：
        //默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")。


    }


    //直接
    fun iff(a: Int, b: Int): Int = if (a > b) a else b


    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a //如果实在 block 中，则必须写return
        } else {
            return b
        }
    }


    fun catch() {


        val result = try {

            var a = ""
            var b = ""

        } catch (e: Exception) {

        }


    }
    //endregion


    //region 空判断  ?.操作符  Elvis操作符（?:）  !!操作符   类型检测及自动类型转换(is操作符 )  as操作符

    fun getInt(): Int? {
        //如果一个 变量 的值可以为null，必须在声明处的类型后面添加 ？ 来标识此变量可以引用为null
        //否则如果返回null那么编译器报错

        var a = 4
        return null


    }

    fun printNull(): Unit {

        val a = 3
        var b = getInt()

//        var c = a + b;//这样写就报错，因为b有可能为null
//        val plus = a.plus(b);//这两种写法是一样的

        if (b != null) {//必须做判断
            val i = a + b;
        }


        //?. safe call  ，如果对象可能为null,那么当对象是null的时候，表达式返回null

        var s: String? = null;

        print(s?.length)

        //bob?.department?.head?.name  如果任意一个属性（环节）为空，这个链式调用就会返回 null。

        //如果 `person` 或者 `person.department` 其中之一为空，都不会调用该函数：
        //person?.department?.head = managersPool.getManager()


    }

    fun getString() = null
    fun getString1() = null

    /**
     * Elvis操作符（?:）
     * */
    fun foo1(node: Practice): String? {
        //Elvis 操作符是返回两侧的值的其中一个
        //只有左边为null，右边才会执行
        var p = node.getString() ?: "88"
        return p
    }

    /**
     * Elvis操作符（?:）
     * */
    fun foo(node: Practice): String? {
        //Elvis 操作符是返回两侧的值的其中一个,这里使用return 来直接返回
        //
        node.getString() ?: return null

    }


    fun foo2(s: String?) {
        //s有可能为null，如果我们想调用的时候抛出一个NPE异常，那么我们就使用它（好像没什么意义。。。）
        print(s!!.length)
    }


    fun foo4(a: Any?) {

        if (a is String) { //如果自动检测出是此类型，那么后面的语句块中无需显式转换
            print(a.length)
        }

        if (a !is Int) {
            print(a.toString())
        }

    }

    /**
     * as  “不安全的”转换操作符
     * 通常，如果转换是不可能的，转换操作符会抛出一个异常
     * */
    fun foo3(a: Any?) {


        //直接类型转换（如果是String 那么就转换并返回转换后的值，否则抛出异常）
        (a as String).replace("a", "v")

        //可为null的转 如果尝试转换不成功则返回 null
        (a as? String)?.replace("a", "v")

    }


    //endregion


    //region for循环 while  when  使用区间（range,in操作符） 流程控制（if-else ） 返回跳转于标签（TODO）

    /**
     * for循环
     * */
    fun forr(obj: Any) {

        val list = listOf(1, 2, 3, 4, 5)

        for (i in list) {
            print(i.plus(2))
        }

        for (i: Int in list.indices) {
            print(list[i])
        }


    }

    /**
     * when表达式
     * */
    fun foo16(obj: Any) {
        //when 相当于 switch

        when (obj) {
            1 -> print(obj) //这几个都是obj和他们相等

            "2", "3", "4" ->  //这个是多个分支执行一个逻辑
                print(3)

            true -> print(3)

            is Practice -> obj.foo11() //obj 是这个类型,自动转型

            in 1..3 -> print(3)  //在这个区间


            else -> print(3)
        }


        //when 也可以用来取代 if-else if链。

        //如果不提供参数，所有的分支条件都是简单的布尔表达式
        when {
            obj is Practice -> print(3)

            obj is String -> print(3)
        }
    }


    /**
     * 区间的使用，一个是配合for+in 来循环，一个是配合if+in来判断是否包含在集合中
     * */
    fun foo6() {

        // https://www.kotlincn.net/docs/reference/ranges.html
        // rangeTo  downTo reversed step
        val list = listOf(1, 2, 3, 4)

        //区间
        for (i in 1..9) { //默认step是1 闭区间，包括9
            print(i)
        }

        for (i in 1 until 9) {//开区间，不包括9

        }


        //
        for (i in 1..9 step 2) {
            print(i)
        }

        for (i in 9 downTo 1) {
            print(i)
        }


        //if
        val a = 4

        if (a in 1..9) {

        }


        if (a !in list.indices) {//0..list.size-1   indices是个集合，in 用在if中相当于调用contains()

        }


    }


    /**
     * if作为表达式 ，表达式都会返回一个值
     * */
    fun foo15(a: Int, b: Int) {

        var max = if (a > b) a else b

        max = if (a > b) {
            print(a)
            a
        } else {
            b
        }

    }

    //endregion


    //region with操作符  === ,== ,数据类型的转换，位运算

    class WithClass {
        fun fo1() = 3
        fun fo2() = 3
        fun fo3() = 3

    }

    fun foo9() {
        //对一个对象实例调用多个方法
        //直接里面的方法
        val practice = WithClass()
        with(practice) {
            fo1()
            fo2()
            print(fo3())
        }

    }

    fun foo10() {

        // == 是值得比较， ===是引用比较
        var a: Int = 1000 //这种kotlin会使用java的原生数据类型
        var b: Int? = a //装箱操作 变为Int?类型
        var c: Int? = a
        print(c == b)  //true
        print(c === b)//false


        var a1: Int? = 1000 //这种kotlin会使用装箱
        var b1: Int? = a1 //装箱操作 变为Int?类型
        var c1: Int? = a1
        print(c1 == b1)  //true
        print(c1 === b1)//true 因为引用是一样的


        var a2: Int = 100 //这种kotlin会使用java的原生数据类型
        var b2: Int? = a //装箱操作 变为Int?类型
        var c2: Int? = a
        print(c2 == b2)  //true
        print(c2 === b2)//true 在-128到127之间用的是缓存共享的Integer
    }


    fun foo11() {
        var l = 1L + 4 //自动转换为Long

        var b: Int = 4
        var a: Long = b.toLong() //必须显示转换


    }

    fun foo12() {
//        这是完整的位运算列表（只用于 Int 与 Long）：
//
//        shl(bits) – 有符号左移 (Java 的 <<)
//        shr(bits) – 有符号右移 (Java 的 >>)
//        ushr(bits) – 无符号右移 (Java 的 >>>)
//        and(bits) – 位与
//        or(bits) – 位或
//        xor(bits) – 位异或
//        inv() – 位非

        val a = 1 shl 2 or 3

    }

    //endregion

    //region 集合 数组（list） map ,lambda 表达式
    //所有的集合都分为可变的和不可变的


    //https://www.kotlincn.net/docs/reference/lambdas.html
    /**
     * list
     * */
    fun foo7(): Unit {

        val list = listOf(1, 23, 4, 5, 5)
        val mutableListOf = mutableListOf(1, 2, 3) //可变得

        //迭代
        for (i in list) {//这种就是语法糖了，in用在for中，就相当于iterator next

        }

        if (10 in list) { //这个就相当于调用 contains()  就是语法糖
            print("yes")
        }


        list.filter { it > 2 }
                .sorted()
                .map { "4$it" }
                .forEach { print(it) }

        //it是内置,只有kotlin才有

        //这种是简单定义一个函数，返回boolean ，a就是元素
        list.filter { a -> a > 0 }

    }

    /**
     * map
     * */
    fun foo8() {
        var map = mapOf(1 to "1", 2 to "2")

        val s = map[1];

        val replace = s?.replace("a", "s")

    }

    /**
     * array
     * */
    fun foo13() {
        //这个就相当于 new int[]{1,2,3,4}
        val array = arrayOf(1, 2, 3, 4)

        // arrayOfNulls() 可以用于创建一个指定大小的、所有元素都为空的数组
        val arrayOfNulls = arrayOfNulls<String>(5)
        arrayOfNulls[1] = "123"


        //无装箱开销的专门的类来表示原生类型数组
        val intArrayOf: IntArray = intArrayOf(1, 2, 3, 4)


    }

    /**
     * lambda 表达式
     * https://juejin.im/entry/58a382da61ff4b0058ab4542
     * lambda 表达式其实就是函数的简化
     * */
    fun foo30(): Unit {

    }

    //endregion


    //region 操作符重载  operator关键字

    //有很多内置的操作符对应的函数，我们
    class ClassO(var a: Int) {

    }

    operator fun ClassO.unaryMinus() = ClassO(-a)


    fun foo20(): Unit {
        val classO = ClassO(1)
        val classO1 = -classO //变成a为-1了
    }

    //endregion


    //region java 和 kotlin互相调用  ，类型别名 ，kotlin关键字
    /**
     * https://www.kotlincn.net/docs/reference/java-interop.html
     * external关键字来使得kotlin调用native方法
     *
     * */
    fun foo21(): Unit {

    }


    /**
     * typealias关键字
     * 通常缩减集合类型
     * 函数类型提供另外的别名
     *
     * */
    fun foo22(): Unit {

    }


    /**
     * 关键字集合
     * https://www.kotlincn.net/docs/reference/keyword-reference.html
     *
     * */
    fun foo23(): Unit {

    }

    //endregion


    //region kotlin Android 拓展

    /**
     * https://www.kotlincn.net/docs/tutorials/android-plugin.html
     *
     * 我们直接
     * apply plugin: 'kotlin-android-extensions'
     * */
    fun foo24(): Unit {

    }
    //endregion


    //region 反射

    var x = ""
    /**
     * 我们使用 :: 来调用反射
     * */
    fun foo25(): Unit {


        val kClass = String::class // KClass 类型的值
        val java = String::class.java //  Java 类引用


        val name: String? = ""::class.qualifiedName//对象获取类引用


        val kProperty0 = ""::length
        val length = kProperty0.get();


        //函数类型 所有可调用引用的公共超类型是 KCallable<out R>，


        listOf(1, 2).filter { i -> i % 2 == 0 }
        listOf(1, 2).filter { it % 2 == 0 }
        listOf(1, 2).filter(::isOdd)


        ::x.get()  //反射x类型  值为 KProperty<String>  KMutableProperty<String>
        ::x.name

        //映射
        listOf("1", "22").map(String::length)

        listOf("1", "22").map { it.length } //it是内置的

        listOf("1", "22").map { s: String -> s.length }

        listOf("1", "22").map { s -> s.length }


    }

    fun isOdd(x: Int) = x % 2 != 0

    //endregion


    //region kotlin常用函数  let

    fun foo26(): Unit {
        var x: String? = null
        //let中是返回自己的对象，一般可以用来做非空逻辑
        x?.let { print(it.length) }
        print(x?.length)

    }


    //endregion


    //region 常用规则


    /**
     * lambda有多个it如何取值》
     *
     * ===================
     * 初始化，可以用init,也可以直接写在参数上
     * 因为kotlin初始是调用构造函数，然后是init，然后是成员变量（这个看代码顺序来执行）
     *
     *  ========构造函数=====
     *  有主次之分，次必须最终委托给主
     *
     * ======tag强转=========
     * 我们用is判断完了后，我们要用as进行转换，因为判断完了后tag还是会改变的，所以
     * 不能保证安全，要用as转完，然后将引用给一个值，然后就可以使用了，因为as转
     * 不成功是会报错的 或者用as?
     *
     * ======static方法 静态方法的几种写法==========
     * object A{
     *  @JvmStatic
     *  fun get(){}
     * }
     *
     * class A privite constructor(context Context){
     *       companion object{
     *          fun get(){
     *          ....
     *          }
     *       }
     * }
     *
     *
     * ========可null属性声明(逻辑上避免空指针)=====
     * var instance: VerifyUtil? = null
     * 必须指明类型，而且初始化null
     *
     * =========设置属性=====
     *  private val userApiStore: UserApiStore
     *  get() {
     *  var dataRepository: UserApiStore = MineDataRepository()
     *      return dataRepository
     *   }
     * 这个每次调用 userApiStore都会new一个出来
     *
     * ===========匿名内部类===========
     * 如果这个类没有参数那么可以直接用{} 代替
     * xx.setCallBack{
     *
     * }
     *
     * 如果有一个参数那么就默认it
     * xx.setCallBack{
     *   print(it.toString)
     * }
     *
     *
     * ========内部接口定义=======
     *
     * class AAA {

    private var callback: OnCallback? = null //在非构造函数中初始化，都得是？类型

    interface OnCallback {
    fun func(s: String)
    }

    fun setLIns(callback: OnCallback) {

    this.callback = callback
    }
    }

     *
     * =============参数类型自动联想====
     * onClickListener 很给力
     *
     * =============kotlin的函数类型也很给力============
     * 之前我们要写个接口，然后定义方法
     * 然后写回调，现在我们直接将函数类型作为参数
     * fun1(var listener: (data: RankInfoEntity) -> Unit){
     *
     * listener(data)
     *
     * }
     *
     *
     * 而在那边 我们直接  fun1({ it.toString//这就是传入的data })
     *
     *
     * ========lambda创建接口类型的匿名内部类=====
     *
     * var listener = OnNetWorkErrorListener {fun()}
     *
     * 代表里面一个方法，而且没有参数
     *
     *
     * ===========when做表达式==============
     *   return when (position) {
     * 0 -> {
     * "进行中"
     * }
     * 1 -> {
     * "停止买入"
     * }
     * else -> {
     * "已结束"
     *    }
     *
     * ===============kotlin的char ================
     *  val c = '\u0000'
     *  相当于java 的 char c ='\0'
     *
     *  ===========kotlin中的val和const=======
     *  var 会生成getter, setter
     *  val 只会生成getter,我们可以重写 getter方法
     *  val currentTime:Long
     *      get(){return System.currentTimeMillis()}
     *  每次currentTime都是不一样的，所以val并不是常量，而是不可写
     *
     *  kotlin中的定义常量有两种
     *  一个是用const修饰 val ，这样编译器禁止生成getter对象
     *  const只能用在顶层文件，或者object中，
     *  一个是@JvmField
     *  @JvmField val NAME = "89757
     *
     * ================envnsi操作符======
     * 我们可以用?:来少些if return 的判断
     *
     *  val data = intent.data?.toString() ?: return
     *  如果前面表达式为null，后面直接返回
     *
     *  ==============!!操作符==============
     *  当我们一个参数是非空的时候，我们的参数是？类型
     *  那么我们就不能传入，这时我们用 fun(xxx!!)来传入
     *  但是如果是null则抛出异常
     *  ===========object 匿名内部类====
     *
     *  var o = object:XXX(){
     *
     *  }
     *
     * */
    fun foo27(): Unit {

    }


    /**
     * kotlin java 互转
     * Code - Convert Java File To Kotlin File

    Kotlikn 转 Java

    Tools>Kotlin>Show Kotlin Bytecode
    Decompile
     * */
    fun foo28(): Unit {

    }

    //endregion


}