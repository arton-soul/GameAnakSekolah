package com.example.eduquest

import com.example.eduquest.core.ui.AvatarHelper
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class OnboardingUiTest {

    private fun validateNickname(rawInput: String): String? {
        val trimmed = rawInput.trim()
        if (trimmed.isBlank()) {
            return "Silakan masukkan nama panggilanmu"
        }
        if (trimmed.length < 2) {
            return "Nama panggilan minimal 2 huruf"
        }
        if (trimmed.length > 20) {
            return "Nama panggilan maksimal 20 huruf"
        }
        return null // Valid
    }

    @Test
    fun blankNickname_returnsError() {
        val errorEmpty = validateNickname("")
        assertEquals("Silakan masukkan nama panggilanmu", errorEmpty)

        val errorSpaces = validateNickname("     ")
        assertEquals("Silakan masukkan nama panggilanmu", errorSpaces)
    }

    @Test
    fun tooShortNickname_returnsError() {
        val error = validateNickname("A")
        assertEquals("Nama panggilan minimal 2 huruf", error)

        val errorWithSpace = validateNickname("  B  ")
        assertEquals("Nama panggilan minimal 2 huruf", errorWithSpace)
    }

    @Test
    fun tooLongNickname_returnsError() {
        val error = validateNickname("Budi Santoso Dan Rekan Rekan Sekolah Dasar")
        assertEquals("Nama panggilan maksimal 20 huruf", error)
    }

    @Test
    fun validNicknames_passValidation() {
        assertNull(validateNickname("Budi"))
        assertNull(validateNickname("Aisyah"))
        assertNull(validateNickname("Rio"))
        assertNull(validateNickname("  Siti Rahma  ")) // Trimming makes it valid
        assertNull(validateNickname("12345678901234567890")) // Exact 20 chars
    }

    @Test
    fun gradeSelection_validGrades() {
        val validGrades = (1..6).toList()
        assertEquals(6, validGrades.size)
        assertTrue(validGrades.contains(1))
        assertTrue(validGrades.contains(6))
        assertFalse(validGrades.contains(0))
        assertFalse(validGrades.contains(7))
    }

    @Test
    fun avatarHelper_containsValidAvatars() {
        val avatars = AvatarHelper.AVATARS
        assertTrue("Avatars list must not be empty", avatars.isNotEmpty())
        assertTrue("At least 4 avatars available for selection", avatars.size >= 4)

        for (avatar in avatars) {
            assertTrue("Avatar ID must not be blank", avatar.id.isNotBlank())
            assertTrue("Avatar name must not be blank", avatar.name.isNotBlank())
            assertTrue("Avatar emoji must not be blank", avatar.emoji.isNotBlank())
        }

        val defaultAvatar = AvatarHelper.getAvatar("avatar_kancil")
        assertNotNull(defaultAvatar)
        assertEquals("Kancil", defaultAvatar.name)

        // Unknown avatar falls back to first avatar
        val fallbackAvatar = AvatarHelper.getAvatar("unknown_id")
        assertNotNull(fallbackAvatar)
        assertEquals(avatars.first().id, fallbackAvatar.id)
    }
}
