import kotlin.math.pow
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
    val table =  Array(rows) {Array(cols){Random.nextInt(100,1000)} }
    val digits = mutableSetOf<Char>()
    for (i in 0 until rows)
    {
        for (j in 0 until cols)
        {
            val elements = readln().toInt()
            table[i][j] = elements
            elements.toString().forEach {digits.add(it)}
        }
    }
    println("Двумерный массив: ")
    for(i in 0 until rows)
    {
        for (j in 0 until cols)
        {
            println("${table[i][j]}")
        }
        println()
    }
    println("В мыссиве использовано ${digits.size} различных цифр")
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

}

fun task4()
{
    print("Введите выражение (ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ): ")
    val input = readLine()?.split(" ") ?: return
    if (input.size != 3) {
        println("Неверный формат ввода")
        return
    }

    val num_1 = input[0].toDoubleOrNull()
    val num_2 = input[1].toDoubleOrNull()
    val sign = input[2]

    if (num_1 == null || num_2 == null) {
        println("Ошибка: числа введены неверно")
        return
    }

    val result: Any = when (sign) {
        "+" -> num_1 + num_2
        "-" -> num_1 - num_2
        "*" -> num_1 * num_2
        "/" -> if (num_2 != 0.0) num_1 / num_2 else return println("Ошибка: деление на ноль!")
        else -> return println("Неизвестная операция")
    }

// Проверяем результат: если без дробной части — выводим как Int
    if (result is Double) {
        if (result % 1.0 == 0.0) {
            println("Результат: ${result.toInt()}")
        } else {
            println("Результат: $result")
        }
    } else {
        println("Результат: $result")
    }
}
fun task5() {
    print("Введите число n: ")
    val n = readLine()?.toIntOrNull() ?: return
    print("Введите основание степени x: ")
    val x = readLine()?.toIntOrNull() ?: return
    var found = false
    for (y in 1..100) { // ограничим перебор
        if (x.toDouble().pow(y.toDouble()).toInt() == n)
        {
            println("Целочисленный показатель существует: y = $y")
            found = true
            break
        }
    }
    if (!found) println("Целочисленный показатель не существует")
}
