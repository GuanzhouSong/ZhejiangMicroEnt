package com.icinfo.cs.common.constant;

/**
 * 系统日志类型
 * @author ZhuDefeng
 * @date 2016-12-29
 */
public enum LogTypeEnum {

    REG_LOGIN("1","100","警示系统登录"),
    SYN_LOGIN("2","200","协同系统登录"),
    YR_LOGIN("3","300","年报系统登录");

    //所在系统
    private String logSystem;

    //日志类型
    private String logType;

    //日志说明
    private String logMsg;


    private LogTypeEnum(String logSystem,String logType, String logMsg){
        this.logSystem=logSystem;
        this.logType=logType;
        this.logMsg=logMsg;
    }

    public static LogTypeEnum getLogType(String logType){
        for(LogTypeEnum logTypeEnum: LogTypeEnum.values()){
            if(logType.equals(logTypeEnum.getLogType())){
                return logTypeEnum;
            }
        }
        return null;
    }

    public String getLogSystem() {
        return logSystem;
    }

    public void setLogSystem(String logSystem) {
        this.logSystem = logSystem;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogMsg() {
        return logMsg;
    }

    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg;
    }

    public String getLogType() {
        return logType;
    }
}
