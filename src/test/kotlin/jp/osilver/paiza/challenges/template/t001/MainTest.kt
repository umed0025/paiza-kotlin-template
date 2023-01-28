package jp.osilver.paiza.challenges.template.t001

import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream
import kotlin.test.assertEquals


class MainTest {

    @Test
    fun test001() {
        test("in_001.txt", "expected_001.txt")
    }

    @Test
    fun test002() {
        test("in_002.txt", "expected_002.txt")
    }

    @Test
    fun test003() {
        test("in_003.txt", "expected_003.txt")
    }

    private fun test(inFileName: String, expectedFileName: String) {
        // デフォルトの入出力を保存
        val defaultSysIn: InputStream = System.`in`
        val defaultSysOut: PrintStream = System.out

        // put "$inFileName" in the same path as this class file.
        this.javaClass.getResourceAsStream(inFileName).use { sysIn ->
            ByteArrayOutputStream().use { byteArrayOutputStream ->
                PrintStream(byteArrayOutputStream).use { sysOut ->
                    System.setIn(sysIn)
                    System.setOut(sysOut)
                    // call target method.
                    main()
                    val actual = String(byteArrayOutputStream.toByteArray())
                    val expected = this.javaClass.getResource(expectedFileName)!!.readText()
                    assertEquals(expected, actual)
                }
            }
        }

        System.setIn(defaultSysIn)
        System.setOut(defaultSysOut)
    }
}