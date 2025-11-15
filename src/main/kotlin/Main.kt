import kotlin.random.Random
fun main()
{
    while (true)
    {
        println("\nМеню:")
        println("1. Создать программу, выполняющую несколько функционалов")
        println("2. Выяснить, симметричен ли массив относительно главной диагонали")
        println("3. Составить программу шифровки и дешифровки строкового выражения")
        println("4. Создать приложение, в котором пользователь дает на вход два числовых массива, на выходе приложение выдает пересечение этих массивов.")
        println("5. Создать приложение, в котором пользователь вводит массив из различных слов. На выходе приложение должно показать слова сгруппированные по признаку. ")
        println("0. Выход")
        print("Выберите задачу: ")

        when (readLine()?.toIntOrNull())
        {
            1 -> task1()
            2 -> task2()
            3 -> task3()
            4 -> task4()
            5 -> task5()
            0 -> {
                println("Выход из программы.")
                return
            }
            else -> println("Неверный выбор, попробуйте снова.")
        }
    }
}
fun task1()
{
    print("Введите количество строк: ")
    val rows = readln().toInt()
    print("Введите количество столбцов: ")
    val cols = readln().toInt()
    println("Введите числа в столбик: ")
    val table =  Array(rows) {Array(cols){0} }
    val digits = mutableSetOf<Char>()
    for (i in 0 until rows)
    {
        for (j in 0 until cols)
        {
            val elements = readln().toInt()
            table[i][j] = elements
            elements.toString().filter { it.isDigit() }.forEach { digits.add(it) }
        }
    }
    println("Двумерный массив: ")
    for(i in 0 until rows)
    {
        println(table[i].joinToString (" "))
        println()
    }
    println("В мыссиве использованно ${digits.size} различных цифр")
}


fun task2()
{
val n = 5
    val array1 = arrayOf(
        intArrayOf(5, 9, 6, 7, 2),
        intArrayOf(9, 8, 4, 5, 3),
        intArrayOf(6, 4, 3, 8, 7),
        intArrayOf(7, 5, 8, 4, 8),
        intArrayOf(2, 3, 7, 8, 1),
    )
    var symetr = true
    for (i in 0 until n)
        {
        for(j in i + 1 until n)
        {
            if (array1[i][j] != array1[j][i])
            {
                symetr = false
            }
        }
    }
if (symetr)
{
    println("матрица симетрична относительно главной диаганали")

}
    else
{
    println("матрица НЕ симетрична относительно главной диаганали")
}
    }


fun task3()
{
    val alphabet = listOf(
        'А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П',
        'Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ь','Ы','Ъ','Э','Ю','Я'
    )
    val numbers = listOf(
        21,13,4,20,22,1,25,12,24,14,2,28,9,23,3,29,6,
        16,15,11,26,5,30,27,8,18,10,33,31,32,19,7,17
    )
    val map = alphabet.zip(numbers).toMap()
    val reverseMap = numbers.zip(alphabet).toMap()
    print("Введите режим (1 - зашифровать, 2 - расшифровать): ")
    val mode = readLine()!!.toInt()
    print("Введите ключевое слово: ")
    val key = readLine()!!.uppercase()
    print("Введите текст: ")
    val text = readLine()!!.uppercase()
    val result = StringBuilder()
    var keyIndex = 0
    for (ch in text)
    {
        val num = map[ch] ?: continue
        val shift = map[key[keyIndex]] ?: 0
        val newNum = if (mode == 1)
        {
            (num + shift - 1) % 33 + 1
        } else {
            (num - shift - 1 + 33) % 33 + 1
        }
        result.append(reverseMap[newNum])
        keyIndex = (keyIndex + 1) % key.length
    }
    println("Результат: $result")
}

fun task4()
{
    println("Введите первый массив через пробел:")
    val arr1 = readLine()!!.split(" ").map { it.toInt() }
    println("Введите второй массив через пробел:")
    val arr2 = readLine()!!.split(" ").map { it.toInt() }
    val result = mutableListOf<Int>()
    val arr2Copy = arr2.toMutableList()
    for (num in arr1)
    {
        if (arr2Copy.contains(num))
        {
            result.add(num)
            arr2Copy.remove(num)
        }
    }
    println("Пересечение массивов: $result")

}
fun task5()
{
    println("Введите слова через пробел:")
    val words = readLine()!!.split(" ")
    val groups = mutableMapOf<String, MutableList<String>>()
    for (word in words) {
        val key = word.toCharArray().sorted().joinToString("")
        groups.computeIfAbsent(key) { mutableListOf() }.add(word)
    }
    println("Группы слов:")
    for (group in groups.values)
    {
        println(group.joinToString(", "))
    }
}
