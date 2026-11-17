package com.download.util;

import static com.download.util.HttpUtil.patch;
import java.io.IOException;

/**
 *
 * @author test
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        patch("http://54.145.68.172:8081/privateapi/clientchain", "{\n" +
" \"name\":\"GRUPO LAKTOPOL DE MEXICO SA\",\n" +
" \"chainList\":[\n" +
"   {\n" +
"    \"name\":\"PROVECOMER\",\n" +
"    \"status\": true,\n" +
"    \"code\":\"000\"\n" +
"   }\n" +
" ]\n" +
"}");
    }
}
