package com.example.matulohka

import com.example.matulohka.utils.EmailPasswordValidator
import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {

    private val invalidEmail = "asd@d"
    private val invalidPassword = "dafaAsdaf"

    private val validEmail = "user@gmail.com"
    private val validPassword = "User1234/"

    @Test
    fun validEmail() {
        assertTrue(EmailPasswordValidator.emailValidate(validEmail))
        assertFalse(EmailPasswordValidator.emailValidate(invalidEmail))
    }

    @Test
    fun validPassword() {
        assertTrue(EmailPasswordValidator.passwordValidate(validPassword))
        assertFalse(EmailPasswordValidator.passwordValidate(invalidPassword))
    }
}