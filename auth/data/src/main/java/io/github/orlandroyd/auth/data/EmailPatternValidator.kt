package io.github.orlandroyd.auth.data

import android.util.Patterns
import io.github.orlandroyd.auth.domain.PatternValidator

class EmailPatternValidator : PatternValidator {
    override fun matches(value: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }
}