package rojojun.config

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import rojojun.function.loadFromResourceOrThrow
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStreamReader

@Serializable
data class EnvironmentConfig(
    val gemini_key: String
)

fun loadEnvConfig(filename: String = "env.json"): EnvironmentConfig? {
    val inputStream = loadFromResourceOrThrow(filename)
    return runCatching {
        val jsonString = InputStreamReader(inputStream).readText()
        val json = Json { ignoreUnknownKeys = true }
        json.decodeFromString<EnvironmentConfig>(jsonString)
    }
        .onFailure { exception -> exceptionFunction(exception, filename) }
        .getOrNull()
}

fun exceptionFunction(exception: Throwable, filename: String) =
    when (exception) {
        is FileNotFoundException -> {
            println("⚠️ 설정 파일 '$filename'을 읽는 중 오류가 발생했습니다: 파일이 없습니다.")
            println("오류 상세: ${exception.message}")
        }
        is RuntimeException -> {
            println("⚠️ 설정 파일 '$filename'을 파싱하는 중 오류가 발생했습니다: JSON 형식이 올바르지 않거나 예상치 못한 구조입니다.")
            println("오류 상세: ${exception.message}")
        }
        is IOException -> { // FileNotFoundException 포함 가능
            println("⚠️ 설정 파일 '$filename'을 읽는 중 입출력 오류가 발생했습니다.")
            println("오류 상세: ${exception.message}")
        }
        else -> {
            println("⚠️ 설정 파일 '$filename'을 처리하는 중 알 수 없는 오류가 발생했습니다.")
            println("오류 상세: ${exception.message}")
        }
    }