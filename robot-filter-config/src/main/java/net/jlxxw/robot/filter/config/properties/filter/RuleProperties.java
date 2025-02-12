package net.jlxxw.robot.filter.config.properties.filter;

import java.util.HashSet;
import java.util.Set;

/**
 * every one robot filter rule
 *
 * @author chunyang.leng
 * @date 2022-11-03 10:01 AM
 */
public class RuleProperties {

    /**
     * rule name
     */
    private String name;

    /**
     * interval window
     */
    private long interval = 1000;

    /**
     * robot allow pass max value
     */
    private int maxAllow = 50;

    /**
     * allow to add blacklisted
     */
    private boolean allowAddBlacklisted = true;

    /**
     * time out remove blacklisted
     * unit:second
     */
    private long blacklistedTime = 60;

    /**
     * allow remove
     */
    private boolean allowRemoveBlacklisted = true;

    /**
     * white list
     * refresh 10s
     */
    private Set<String> whitelist = new HashSet<String>();

    /**
     * blacklisted
     * refresh 10s
     */
    private Set<String> blacklisted = new HashSet<String>();

    /**
     * reject response http code,default is 403
     */
    private int httpResponseCode = 403;

    /**
     * reject response content type,default is application/json
     */
    private String contentType = "application/json";

    /**
     * return reject message
     */
    private boolean returnRejectMessage = false;

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public int getMaxAllow() {
        return maxAllow;
    }

    public void setMaxAllow(int maxAllow) {
        this.maxAllow = maxAllow;
    }

    public boolean isAllowAddBlacklisted() {
        return allowAddBlacklisted;
    }

    public void setAllowAddBlacklisted(boolean allowAddBlacklisted) {
        this.allowAddBlacklisted = allowAddBlacklisted;
    }

    public long getBlacklistedTime() {
        return blacklistedTime;
    }

    public void setBlacklistedTime(long blacklistedTime) {
        this.blacklistedTime = blacklistedTime;
    }

    public boolean isAllowRemoveBlacklisted() {
        return allowRemoveBlacklisted;
    }

    public void setAllowRemoveBlacklisted(boolean allowRemoveBlacklisted) {
        this.allowRemoveBlacklisted = allowRemoveBlacklisted;
    }

    public Set<String> getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(Set<String> whitelist) {
        this.whitelist = whitelist;
    }

    public Set<String> getBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(Set<String> blacklisted) {
        this.blacklisted = blacklisted;
    }

    public int getHttpResponseCode() {
        return httpResponseCode;
    }

    public void setHttpResponseCode(int httpResponseCode) {
        this.httpResponseCode = httpResponseCode;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReturnRejectMessage() {
        return returnRejectMessage;
    }

    public void setReturnRejectMessage(boolean returnRejectMessage) {
        this.returnRejectMessage = returnRejectMessage;
    }
}
