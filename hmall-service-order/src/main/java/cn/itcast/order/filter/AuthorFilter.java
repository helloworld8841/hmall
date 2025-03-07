package cn.itcast.order.filter;

import cn.itcast.hmall.dto.common.ThreadLocalUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author mrchen
 * @date 2022/5/30 14:34
 */
@Component
@WebFilter(filterName = "authorFilter",urlPatterns = "/*")
public class AuthorFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String authorization = request.getHeader("authorization");
        if(StringUtils.isNotBlank(authorization)){
            ThreadLocalUtil.setUserId(Long.valueOf(authorization));
        }
        filterChain.doFilter(servletRequest,servletResponse);
        ThreadLocalUtil.clear();
    }
}
