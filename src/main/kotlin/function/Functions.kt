package rojojun.function

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.FileNotFoundException
import java.io.InputStream

inline fun <reified T> getLogger(): Logger = LoggerFactory.getLogger(T::class.java)

fun loadFromResourceOrThrow(filename: String): InputStream =
    Thread.currentThread().contextClassLoader.getResourceAsStream(filename)
        ?: throw FileNotFoundException("❌ 리소스에서 파일을 찾을 수 없습니다: $filename")

fun getHeader(filelist: List<String>) =
    filelist.first().split(",").map { it.trim() }