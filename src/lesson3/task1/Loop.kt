@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson8.task1.countSubstrings
import java.lang.Math.*

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var count = 0
    var number = n
    do {
        count += 1
        number /= 10
    } while (number != 0)
    return count
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var last = 1
    var prelast = 1
    if (n == 1 || n == 2) last = 1
    if (n > 2) {
        for (i in 3..n) {
            val x = last
            last += prelast
            prelast = x
        }
    }
    return last
}

fun multiple(m: Int, n: Int): Int {
    var first = m
    var second = n
    while (first != second)
        if (first > second) first -= second
        else second -= first
    return first
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int = m * n / multiple(m, n)

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var i = 2
    val numberToGo = sqrt(n.toDouble() + 1)
    while (i < numberToGo)
        if (n % i == 0) return i
        else i += 1
    return n
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    val maxDivisor = minDivisor(n)
    return if (maxDivisor != n) n / maxDivisor
    else 1
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean = multiple(m, n) == 1

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    for (k in m..n)
        if (sqrt(k.toDouble()) % 1.0 == 0.0) return true
    return false
}

fun forSinusAndCosinus(count: Int, power: Double, x: Double, eps: Double, answer: Double, xNeeded: Double): Double {
    var count1 = count
    var power1 = power
    var sin1: Double
    var flag = -1
    var answer1 = answer
    do {
        count1 += 2
        power1 += 2
        sin1 = pow(xNeeded, power1) / factorial(count1)
        answer1 += sin1 * flag
        flag *= -1
    } while (abs(sin1) >= eps)
    return answer1
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    val count = 1
    val power = 1.0
    val xNeeded = x % (2 * PI)
    val answer = xNeeded
    return forSinusAndCosinus(count, power, x, eps, answer, xNeeded)
}


/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    val count = 0
    val power = 0.0
    val answer = 1.0
    val xNeeded = x % (2 * PI)
    return forSinusAndCosinus(count, power, x, eps, answer, xNeeded)
}


/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var reverse = 0
    var number = n
    while (number > 0) {
        reverse = reverse * 10 + number % 10
        number /= 10
    }
    return reverse
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean = revert(n) == n

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var number = n
    var answer = false
    var numeralnew = 0
    var numeralprevious = 0
    if (number > 10) {
        numeralprevious = number % 10
        numeralnew = number % 100 / 10
        number /= 100
        while ((number > 0) && (answer == false)) {
            if (numeralnew != numeralprevious) answer = true
            else {
                numeralnew = number % 10
                number /= 10
            }
        }
        if ((number == 0) && (numeralnew != numeralprevious)) answer = true
    }
    return answer
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var count = 0L
    var number = 0
    var square = 0L
    var exSum = 0
    var divisor = 1L
    while (number < n) {
        count += 1
        square = count * count
        exSum = digitNumber(square.toInt())
        number += exSum
    }
    return partToSequenceDigit(n, number, exSum, divisor, square)
}


/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var count = 0
    var number = 0
    var exSum = 0
    var fibonacci = 0L
    var divisor = 1L
    while (number < n) {
        count += 1
        fibonacci = fib(count).toLong()
        exSum = digitNumber(fibonacci.toInt())
        number += exSum
    }
    return partToSequenceDigit(n, number, exSum, divisor, fibonacci)
}


fun partToSequenceDigit(given: Int, n: Int, sumEx: Int, divisorr: Long, reply: Long): Int {
    var number = n
    var exSum = sumEx
    var divisor = divisorr
    var answer = reply
    number -= exSum
    while (exSum > 0) {
        divisor *= 10
        exSum -= 1
    }
    while (number != given) {
        answer %= divisor
        divisor /= 10
        number += 1
    }
    return if (divisor.toInt() == 0) answer.toInt()
    else answer.toInt() / divisor.toInt()
}

