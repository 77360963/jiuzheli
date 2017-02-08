package www.yunpan.com.interceptor;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import www.yunpan.com.annotation.Token;

public class TokenInterceptor extends HandlerInterceptorAdapter {

	public final static String TOKEN_NAME = "token";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			Token formToken = method.getAnnotation(Token.class);
			if (null != formToken) {
				if ((formToken.save() && formToken.remove())
						|| (!formToken.save() && !formToken.remove())) {
					throw new RuntimeException("请不要在同一个方法上同时注解：@FormToken(remove = true/false, produce = true/false)");
				} else if (formToken.save()) {
					request.getSession().setAttribute(TOKEN_NAME,UUID.randomUUID().toString());
				} else if (formToken.remove()) {
					String serverToken = (String)request.getSession().getAttribute(TOKEN_NAME);
					String clientToken = request.getParameter(TOKEN_NAME);
					request.getSession().removeAttribute(TOKEN_NAME); // remove token																		
					if (!StringUtils.equals(serverToken, clientToken)) {
						if (null != method.getAnnotation(ResponseBody.class)) { // JSON
							response.setContentType(MediaType.APPLICATION_JSON_VALUE);
							PrintWriter out = response.getWriter();
							out.print("无效请求，请刷新页面后重试");
							out.flush();
							out.close();
						} else { // 普通页面
							request.getRequestDispatcher("/error/invalidRequest").forward(request,response);
						}
						return false;
					}
				}
			}

		}
		return super.preHandle(request, response, handler);

	}
	

}
