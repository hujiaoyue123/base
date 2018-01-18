package com.boxin.base.web.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by user1 on 2015/4/23.
 */
public class ExceptionHandler implements HandlerExceptionResolver {
    public String getDefaultError() {
        return defaultError;
    }

    public void setDefaultError(String defaultError) {
        this.defaultError = defaultError;
    }
    private String defaultError;

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object obj, Exception ex) {
        //TODO:日志记录
        ex.printStackTrace();

        ModelAndView mView = new ModelAndView();
        String viewName=defaultError;//系统程序异常

        mView.setViewName(viewName);
        mView.addObject("msg", ex.getMessage());

        return mView;
    }
}
