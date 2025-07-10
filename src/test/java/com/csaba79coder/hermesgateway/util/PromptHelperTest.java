package com.csaba79coder.hermesgateway.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PromptHelperTest {

    @Test
    @DisplayName("Simple text should encode spaces")
    void testEncodeSimpleText() {
        String input = "Hello world";
        String expected = "Hello+world";
        assertEquals(expected, PromptHelper.encodePrompt(input));
    }

    @Test
    @DisplayName("Should encode accented characters")
    void testEncodeAccentedCharacters() {
        String input = "mesterséges intelligencia";
        String expected = "mesters%C3%A9ges+intelligencia";
        assertEquals(expected, PromptHelper.encodePrompt(input));
    }

    @Test
    @DisplayName("Should encode question mark")
    void testEncodeQuestionMark() {
        String input = "Mi az AI?";
        String expected = "Mi+az+AI%3F";
        assertEquals(expected, PromptHelper.encodePrompt(input));
    }

    @Test
    @DisplayName("Should handle empty string")
    void testEncodeEmpty() {
        String input = "";
        String expected = "";
        assertEquals(expected, PromptHelper.encodePrompt(input));
    }

    @Test
    @DisplayName("Should encode ampersand and other reserved characters")
    void testEncodeSpecialCharacters() {
        String input = "AI & Machine Learning?";
        String expected = "AI+%26+Machine+Learning%3F";
        assertEquals(expected, PromptHelper.encodePrompt(input));
    }
}