package utils;

import org.apache.logging.log4j.ThreadContext;

import java.util.UUID;

/**
 * 追踪id
 */
public class TraceIdUtil {

    private final static String TRACEID = "trace_id";

    /**
     * 当前threadlock设置traceId
     */
    public static void setTraceId() {
        String traceId = UUID.randomUUID().toString().replaceAll("-", "");
        ThreadContext.put(TRACEID, traceId);
    }

    /**
     * 当前threadlock清除traceId, 防止内存溢出
     */
    public static void clearTraceId() {
        ThreadContext.remove(TRACEID);
    }

    /**
     * 获取当前threadlocal的traceid
     *
     * @return
     */
    public static String getTraceId() {
        return ThreadContext.get(TRACEID);
    }
}
