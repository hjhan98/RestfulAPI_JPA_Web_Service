package syscon.restapijpaservice.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * request util
 *
 * @author sung-gue
 * @since 1.0 (2020-03-10)
 */
@Slf4j
public class RequestUtil {

    private static final String[] HEADER_LIST = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "X-Real-IP",
            "X-RealIP",
            "REMOTE_ADDR"
    };

    public static String getClientIpAddr() {
        HttpServletRequest request = getHttpServletRequest();
        String unknown = "unknown";
        String ip = null;

        for (String temp : HEADER_LIST) {
            ip = request.getHeader(temp);
            if (ip != null && ip.length() != 0 && !unknown.equalsIgnoreCase(ip)) {
                log.debug("getClientIpAddr | " + temp + " | " + ip);
                break;
            }
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static String getHeader(String name) {
        HttpServletRequest request = RequestUtil.getHttpServletRequest();
        return request.getHeader(name);
    }

    public static Object getAttribute(String name) {
        HttpServletRequest request = RequestUtil.getHttpServletRequest();
        return request.getAttribute(name);
    }

    public static HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes sra = getServletRequestAttributes();
        return sra.getRequest();
    }

    public static HttpServletResponse getHttpServletResponse() {
        ServletRequestAttributes sra = getServletRequestAttributes();
        return sra.getResponse();
    }

    public static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    }

}