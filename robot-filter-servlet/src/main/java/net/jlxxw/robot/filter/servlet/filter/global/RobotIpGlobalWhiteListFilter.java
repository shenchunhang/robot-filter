package net.jlxxw.robot.filter.servlet.filter.global;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import net.jlxxw.robot.filter.config.properties.FilterProperties;
import net.jlxxw.robot.filter.config.properties.RobotFilterProperties;
import net.jlxxw.robot.filter.core.cache.CacheService;
import net.jlxxw.robot.filter.core.exception.RuleException;
import net.jlxxw.robot.filter.servlet.context.RobotServletFilterWebContext;
import net.jlxxw.robot.filter.servlet.template.AbstractFilterTemplate;
import net.jlxxw.robot.filter.servlet.utils.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chunyang.leng
 * @date 2022-11-03 2:10 PM
 */
@Component
public class RobotIpGlobalWhiteListFilter extends AbstractFilterTemplate {
    @Autowired
    private IpUtils ipUtils;
    @Autowired
    private RobotFilterProperties robotFilterProperties;
    @Autowired
    private CacheService cacheService;


    /**
     * filter function
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     * @throws RuleException    Robot limit triggered
     */
    @Override
    protected void filter(ServletRequest request, ServletResponse response,
        FilterChain chain, FilterProperties filterProperties) throws IOException, ServletException, RuleException {
        String clientIp = RobotServletFilterWebContext.getIp();

        Set<String> globalList = cacheService.getGlobalIpWhiteList();
        // set check context
        RobotServletFilterWebContext.setInWhiteList(globalList.contains(clientIp));
        chain.doFilter(request, response);
    }

    /**
     * current filter increase the client id counter once
     *
     * @param clientId client id
     */
    @Override protected void incClientId(String clientId) {

    }

    /**
     * current filter increase the ip counter once
     *
     * @param ip client ip
     */
    @Override protected void incIp(String ip) {

    }

    /**
     * count current filter all client id
     *
     * @return key: client id,value: count
     */
    @Override protected Map<String, Integer> countClientId() {
        return null;
    }

    /**
     * count current filter all ip
     *
     * @return key: ip,value: count
     */
    @Override protected Map<String, Integer> countIp() {
        return null;
    }
    /**
     * count the current IP qps
     *
     * @param ip client ip
     * @return qps
     */
    @Override protected Integer getQpsByIp(String ip) {
        return null;
    }

    /**
     * count the current client id qps
     *
     * @param clientId client id
     * @return qps
     */
    @Override protected Integer getQpsByClientId(String clientId) {
        return null;
    }
}
