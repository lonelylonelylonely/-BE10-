package com.back;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private final String actionName;
    private final Map<String, String> paramsMap = new HashMap<>();

    public Rq(String cmd) {
        String[] cmdBits = cmd.split("\\?", 2);
        actionName = cmdBits[0];
        String queryString = cmdBits.length > 1 ? cmdBits[1].trim() : "";

        String[] queryStringBits = queryString.split("&");
        for (String queryParam : queryStringBits) {
            String[] queryParamBits = queryParam.split("=", 2);


            String key = queryParamBits[0].trim();
            String value = queryParamBits.length > 1 ? queryParamBits[1].trim() : "";

            if (value.isEmpty()) {
                continue;
            }


            paramsMap.put(key, value);

        }
    }

    public String getParam(String paramName, String defaultValue) {
        if (paramsMap.containsKey(paramName)) {
            return paramsMap.get(paramName);
        } else {
            return defaultValue;
        }
    }


    public String getActionName() {
        return actionName;
    }

    public int getParamAsInt(String paramName, int defaultValue) {
        String value = getParam(paramName,"");

        if (value.isEmpty()){
            return defaultValue;
        }

        //return Integer.parseInt(value);
        // 예외처리 필요 : try, catch문 사용

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}

//    public int getParamAsInt(String name, int defaultValue) {
//        if(!paramsMap.containsKey(name)) return defaultValue;
//
//        String value = paramsMap.get(name);
//
//        try { // 예외처리 : 만약에 Integer.parseInt(value); 리턴해보고, 실패하면
//            return Integer.parseInt(value);
//        } catch (NumberFormatException e) { // catch를 리턴해라 (플랜 B)
//            return defaultValue;
//        }
//    }
//}
//package com.back;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Rq {
//    private final String actionName;
//    private final Map<String, String> paramsMap;
//
//    public Rq(String cmd) {
//        paramsMap = new HashMap<>();
//
//        String[] cmdBits = cmd.split("\\?", 2);
//        actionName = cmdBits[0];
//        String queryString = cmdBits.length > 1 ? cmdBits[1].trim() : "";
//
//        String[] queryStringBits = queryString.split("&");
//
//        for (String queryParam : queryStringBits) {
//            String[] queryParamBits = queryParam.split("=", 2);
//            String key = queryParamBits[0].trim();
//            String value = queryParamBits.length > 1 ? queryParamBits[1].trim() : "";
//
//            if (value.isEmpty()) {
//                continue;
//            }
//
//            paramsMap.put(key, value);
//        }
//    }
//
//    public String getActionName() {
//        return actionName;
//    }
//
//    public String getParam(String paramName, String defaultValue) {
//        if (paramsMap.containsKey(paramName)) {
//            return paramsMap.get(paramName);
//        } else {
//            return defaultValue;
//        }
//    }
//}