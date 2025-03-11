package com.waylau.webhookemailsender.model;

/**
 * SkyWalking AlarmMessage
 * @author waylau.com
 * @version 2025/03/11 08:43
**/
public class SkyWalkingAlarmMessage {

    private int scopeId; //告警标识

    private String scope; //类型

    private String name; //告警的触发详情

    private String id0; //告警服务与告警消息的加密文

    private String id1; //请求的告警消息的加密文

    private String ruleName;

    private String alarmMessage;  //告警信息

    private long startTime; //告警的生产时间

    public int getScopeId() {
        return scopeId;
    }

    public void setScopeId(int scopeId) {
        this.scopeId = scopeId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId0() {
        return id0;
    }

    public void setId0(String id0) {
        this.id0 = id0;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getAlarmMessage() {
        return alarmMessage;
    }

    public void setAlarmMessage(String alarmMessage) {
        this.alarmMessage = alarmMessage;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

}