package io.github.orlandroyd.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}