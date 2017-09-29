@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1
import java.lang.Math.*

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
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
    if(number == 0) count = 1
    else
    while(number != 0){
        count ++
        number /= 10
    }
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
    var X: Int
    if(n == 1) last = 1
    if(n == 2) last = 1
    if(n > 2){
        for (i in 3..n) {
            X = last
            last = prelast + last
            prelast = X
        }
    }
    return last
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var first = m
    var second = n
    var operation = second * first
    while(first != second)
        if(first > second) first -= second
    else second -= first
    return operation / first
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int{
    var i = 2
    var flag = 0
    while((i < sqrt(n.toDouble() + 1)) && (flag == 0))
        if(n % i != 0) i += 1
    else flag = 1
    return if(i < sqrt(n.toDouble() + 1)) i
        else n
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var i = 2
    var flag = 0
    while((i < sqrt(n.toDouble() + 1)) && (flag == 0))
        if(n % i != 0) i += 1
        else flag = 1
    return if(i < sqrt(n.toDouble() + 1))  n / i
    else 1
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var first = m
    var second = n
    while(first != second)
        if(first > second) first -= second
        else second -= first
    return if(first == 1) true
    else false
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var answer = false
    var SQRM = sqrt(m.toDouble())
    var SQRN = sqrt(n.toDouble())
    var SQRMROUND = SQRM.toInt()
    var SQRNROUND = SQRN.toInt()
    if(SQRM % 1.0 == 0.0) answer = true
    if(SQRN % 1.0 == 0.0) answer = true
    if(SQRN % 1.0 != 0.0) SQRNROUND += 1
    if(SQRNROUND - SQRMROUND > 1) answer = true
    return answer
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double = TODO ()

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()


/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int{
    var reverse = 0
    var number = n
    while(number > 0){
        reverse = reverse * 10 + number % 10
        number = number /10
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
fun isPalindrome(n: Int): Boolean {
    var number = n
    var numberfirst: Long //reverse of number n
    numberfirst = 0
    while(number > 0){
        numberfirst = 10 * numberfirst + number % 10;
        number /= 10;
    }
    number = n
    return if (number.toLong() == numberfirst) true
    else false
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var number = n
    var answer = false
    var numbernew: Int
    var numberlast: Int
    if (number > 10) {
        numberlast = number % 10
        numbernew = number % 100 / 10
        number = number / 100
        while ((number > 0) && (answer == false)) {
            if (numbernew != numberlast) answer = true
            else {
                numberlast = numbernew
                numbernew = number % 10
                number /= 10
            }
        }
        if((number ==0) && (numbernew != numberlast)) answer = true
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
    var SQR = 0L
    var exSum = 0
    var divisor = 1L
    while(number < n){
        count += 1
        SQR = count * count
        exSum = 0
        while(SQR > 0){
            SQR /= 10
            exSum += 1
        }
        SQR = count * count
        number = number + exSum
    }
    number = number - exSum
    while(exSum > 0){
        divisor = divisor * 10
        exSum -= 1
    }
    while(number != n){
        SQR = SQR % divisor
        divisor /= 10
        number += 1
    }
    return if(n == 1) 1
    else
        if(n == 2) 4
    else
            if(divisor.toInt() == 0) SQR.toInt()
    else
                SQR.toInt() / divisor.toInt()
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int = TODO()

