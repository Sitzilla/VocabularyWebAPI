package evansitzes.filters;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by evan on 4/13/16.
 */
@Component
public class LevelFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final HttpServletResponse httpResponse = (HttpServletResponse) response;
        System.out.println("request is " + httpRequest.getClass());
        System.out.println("request URL : " + httpRequest.getRequestURL());
        System.out.println("response is " + httpResponse.getClass());
        System.out.println("request is " + httpRequest);

        request.setAttribute("level", "shinbun");

        filterChain.doFilter(request, response);
    }

}