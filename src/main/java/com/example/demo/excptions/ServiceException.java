package com.example.demo.excptions;

/**
 * @Program: QuartzJobScheduling
 * @Description: 自定义异常
 * @Author: wangwei
 * @Version: 1.0
 * @Create: 2019-04-04 14:55
 * @Updater: st.wu
 * @UpdateTime: 2019-04-04 14:55
 */
public class ServiceException extends Exception{
    public ServiceException() {
        super();
    }

    public ServiceException( String message) {
        super(message);
    }
    public ServiceException( String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException( Throwable cause) {
        super(cause);
    }

    protected ServiceException( String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}