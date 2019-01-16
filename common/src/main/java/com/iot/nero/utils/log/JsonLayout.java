package com.iot.nero.utils.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 扩展Log4j 1.x，使其支持 JsonLayout，与 log4j2.x 一样是基于Jackson进行解析，其格式也是完全参考 Log4J 2.x实现的。
 */
public class JsonLayout extends Layout {

    private final ObjectMapper mapper = new ObjectMapper();

    public String format(LoggingEvent loggingEvent) {
        String json;
        Map<String, Object> map = new LinkedHashMap<String, Object>(0);
        Map<String, Object> source = new LinkedHashMap<String, Object>(0);
        source.put("method", loggingEvent.getLocationInformation().getMethodName());
        source.put("class", loggingEvent.getLocationInformation().getClassName());
        source.put("file", loggingEvent.getLocationInformation().getFileName());
        source.put("line", safeParse(loggingEvent.getLocationInformation().getLineNumber()));

        map.put("timeMillis", loggingEvent.getTimeStamp());
        map.put("thread", loggingEvent.getThreadName());
        map.put("level", loggingEvent.getLevel().toString());
        map.put("loggerName", loggingEvent.getLocationInformation().getClassName());
        map.put("source", source);
        map.put("endOfBatch", false);
        map.put("loggerFqcn", loggingEvent.getFQNOfLoggerClass());


        map.put("message", safeToString(loggingEvent.getMessage()));
        map.put("thrown", formatThrowable(loggingEvent));
        try {
            json = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
        return json;
    }

    private List<Map<String, Object>> formatThrowable(LoggingEvent le) {
        if (le.getThrowableInformation() == null ||
                le.getThrowableInformation().getThrowable() == null)
            return null;
        List<Map<String, Object>> traces = new LinkedList<Map<String, Object>>();
        Map<String, Object> throwableMap = new LinkedHashMap<String, Object>(0);
        StackTraceElement[] stackTraceElements = le.getThrowableInformation().getThrowable().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            throwableMap.put("class", stackTraceElement.getClassName());
            throwableMap.put("file", stackTraceElement.getFileName());
            throwableMap.put("line", stackTraceElement.getLineNumber());
            throwableMap.put("method", stackTraceElement.getMethodName());
            throwableMap.put("location", "?");
            throwableMap.put("version", "?");
            traces.add(throwableMap);
        }
        return traces;
    }

    private static String safeToString(Object obj) {
        if (obj == null) return null;
        try {
            return obj.toString();
        } catch (Throwable t) {
            return "Error getting message: " + t.getMessage();
        }
    }

    private static Integer safeParse(String obj) {
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException t) {
            return null;
        }
    }

    public boolean ignoresThrowable() {
        return false;
    }

    public void activateOptions() {

    }
}