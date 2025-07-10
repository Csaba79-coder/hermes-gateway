package com.csaba79coder.hermesgateway.util;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class PromptHelper {

    public static String encodePrompt(String prompt) {
        return URLEncoder.encode(prompt, StandardCharsets.UTF_8);
    }

    private PromptHelper() {

    }
}
