package com.server.sms.interceptor;

import com.server.sms.json.JsonBean;
import com.server.sms.service.user.UserLoginService;
import com.server.sms.util.ErrorCodeUtil;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/11/4 0004.
 */
public class UserInterceptor implements HandlerInterceptor {
    private static Logger logger = Logger.getLogger(UserInterceptor.class);

    private UserLoginService userLoginService;

    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     * 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true
     * 执行下一个拦截器,直到所有的拦截器都执行完毕
     * 再执行被拦截的Controller
     * 然后进入拦截器链,
     * 从最后一个拦截器往回执行所有的postHandle()
     * 接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = httpServletRequest.getParameter("token");
        //token参数不存在
        if (token == null)
            return true;

        //token校验
        //手动初始化Service
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(httpServletRequest.getServletContext());
        userLoginService = (UserLoginService) factory.getBean("userLoginService");

        int code = userLoginService.checkToken(token);
        if (code != ErrorCodeUtil.SUCCESS) {
            logger.error("UserInterceptor Error-->" + code);
            //json拼接返回
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");
            JsonBean bean = new JsonBean(code);
            httpServletResponse.getWriter().print(new Gson().toJson(bean));
            httpServletResponse.getWriter().close();
            return false;
        }
        return true;
    }

    //请求正式处理完成
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    //请求处理之后
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
