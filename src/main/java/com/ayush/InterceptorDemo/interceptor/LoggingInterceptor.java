package com.ayush.InterceptorDemo.interceptor;

import com.ayush.InterceptorDemo.StudentController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {

        if(handler instanceof HandlerMethod method){
            String controllerName = method.getBeanType().getName();
            String methodName = method.getMethod().getName();
            Class controllerBean = method.getBean().getClass();

            System.out.println("preHandle called");
            System.out.println("Controller name is : " + controllerName);
            System.out.println("Class name is : " + controllerBean);
            System.out.println("Method name is : " + methodName);

        }

//        String controllerName = method.getBeanType().getName();
//        String methodName = method.getMethod().getName();
//        Class controllerBean = method.getBean().getClass();
//
//        System.out.println("Controller name is : " + controllerName);
//        System.out.println("Class name is : " + controllerBean);
//        System.out.println("Method name is : " + methodName);
//        System.out.println("preHandle called");
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView){

        System.out.println("postHandle called");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex){

        System.out.println("afterCompletion called");
    }

}