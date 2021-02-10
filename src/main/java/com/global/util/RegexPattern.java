package com.global.util;

import java.util.regex.Pattern;

public class RegexPattern {
    public static Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
    public static Pattern passwordPattern = Pattern.compile("^[a-zA-Z0-9 @$^&\\-_+=():;.,?/!§%*µ£#{}]+$");
    public static Pattern labelPattern = Pattern.compile("^[a-zA-Z0-9@$^&\\-_+=():;.,?/!§%*µ£#{}]+( [a-zA-Z0-9@$^&\\-_+=():;.,?/!§%*µ£#{}]+)*$");
}
