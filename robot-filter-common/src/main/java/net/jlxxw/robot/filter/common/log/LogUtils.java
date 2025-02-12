package net.jlxxw.robot.filter.common.log;

import java.util.Objects;
import javax.annotation.PostConstruct;
import net.jlxxw.robot.filter.config.properties.log.FilterLogProperties;
import net.jlxxw.robot.filter.config.properties.RobotFilterProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chunyang.leng
 * @date 2022-11-03 10:26 AM
 */
@Component
public class LogUtils {
    private static final Logger logger = LoggerFactory.getLogger(LogUtils.class);
    @Autowired
    private RobotFilterProperties robotFilterProperties;

    private FilterLogProperties filterLogProperties;

    @PostConstruct
    public void init() {
        filterLogProperties = robotFilterProperties.getLog();
        if (Objects.isNull(filterLogProperties)) {
            filterLogProperties = new FilterLogProperties();
            info(logger, "robot filter enable default log properties");
        }
    }

    /**
     * debug 日志记录
     *
     * @param logger 日志面板
     * @param format 格式化字符串参数
     * @param args   参数
     */
    public void debug(Logger logger, String format, Object... args) {
        if (Objects.nonNull(logger) && filterLogProperties.isEnabled()) {
            if (logger.isDebugEnabled() && filterLogProperties.getLevel().toInt() >= Level.DEBUG.toInt()) {
                logger.debug(format, args);
            }
        }
    }

    /**
     * info 日志记录
     *
     * @param logger 日志面板
     * @param format 格式化字符串参数
     * @param args   参数
     */
    public void info(Logger logger, String format, Object... args) {
        if (Objects.nonNull(logger) && filterLogProperties.isEnabled()) {
            if (logger.isInfoEnabled() && filterLogProperties.getLevel().toInt() >= Level.INFO.toInt()) {
                logger.info(format, args);
            }
        }
    }

    /**
     * info 日志记录
     *
     * @param logger 日志面板
     * @param format 格式化字符串参数
     */
    public void info(Logger logger, String format) {
        if (Objects.nonNull(logger) && filterLogProperties.isEnabled()) {
            if (logger.isInfoEnabled() && filterLogProperties.getLevel().toInt() >= Level.INFO.toInt()) {
                logger.info(format);
            }
        }
    }

    /**
     * error 日志记录
     *
     * @param logger    日志面板
     * @param message   记录的信息
     * @param throwable 异常信息
     */
    public void error(Logger logger, String message, Throwable throwable) {
        if (Objects.nonNull(logger) && filterLogProperties.isEnabled()) {
            if (logger.isErrorEnabled() && filterLogProperties.getLevel().toInt() >= Level.ERROR.toInt()) {
                logger.error(message, throwable);
            }
        }
    }

    /**
     * error 日志记录
     *
     * @param logger  日志面板
     * @param message 记录的信息
     * @param args    一些参数
     */
    public void error(Logger logger, String message, Objects... args) {
        if (Objects.nonNull(logger) && filterLogProperties.isEnabled()) {
            if (logger.isErrorEnabled() && filterLogProperties.getLevel().toInt() >= Level.ERROR.toInt()) {
                logger.error(message, args);
            }
        }
    }

    /**
     * warn 日志记录
     *
     * @param logger 日志面板
     * @param format 格式化字符串参数
     * @param args   参数
     */
    public void warn(Logger logger, String format, Object... args) {
        if (Objects.nonNull(logger) && filterLogProperties.isEnabled()) {
            if (logger.isWarnEnabled() && filterLogProperties.getLevel().toInt() >= Level.WARN.toInt()) {
                logger.warn(format, args);
            }
        }
    }

    /**
     * warn 日志记录
     *
     * @param logger 日志面板
     * @param format 格式化字符串参数
     */
    public void warn(Logger logger, String format) {
        if (Objects.nonNull(logger) && filterLogProperties.isEnabled()) {
            if (logger.isWarnEnabled() && filterLogProperties.getLevel().toInt() >= Level.WARN.toInt()) {
                logger.warn(format);
            }
        }
    }
}
