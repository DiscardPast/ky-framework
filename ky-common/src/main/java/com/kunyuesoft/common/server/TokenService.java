package com.kunyuesoft.common.server;

import com.alibaba.fastjson.JSONObject;
import com.kunyuesoft.common.base.UserInfoDTO;
import com.kunyuesoft.common.constatnts.Constants;
import com.kunyuesoft.common.redis.RedisCache;
import com.kunyuesoft.common.utils.*;
import eu.bitwalker.useragentutils.UserAgent;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * token验证处理
 * 
 * @author kunyuesoft
 */
@Component
public class TokenService
{
    // 令牌自定义标识
    @Value("${token.header}")
    private String header;

    // 令牌秘钥
    @Value("${token.secret}")
    private String tokenSecret;

    @Value("${spring.application.name}")
    private String name;

    private static String secret;

    // 令牌有效期（默认30分钟）
    @Value("${token.expireTime}")
    private int expireTime;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    @Autowired
    private RedisCache redisCache;

    @PostConstruct
    private void init(){
        if(secret == null){
            secret =  DigestUtils.md5DigestAsHex((tokenSecret+"@"+name).getBytes());
        }
    }

    /**
     * 获取用户身份信息
     * 
     * @return 用户信息
     */
    public <T> T getLoginUser(HttpServletRequest request,Class<T> tClass)
    {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (StringUtils.isNotEmpty(token))
        {
            Claims claims = parseToken(token);
            // 解析对应的权限以及用户信息
            String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
            String userKey = getTokenKey(uuid);
            String json = redisCache.getCacheObject(userKey);
            return JSONObject.parseObject(json,tClass);
        }
        return null;
    }

    /**
     * 设置用户身份信息
     */
    public void setLoginUser(UserInfoDTO userInfoDTO)
    {
        if (StringUtils.isNotNull(userInfoDTO) && StringUtils.isNotEmpty(userInfoDTO.getToken()))
        {
            refreshToken(userInfoDTO);
        }
    }

    /**
     * 删除用户身份信息
     */
    public void delLoginUser(String token)
    {
        if (StringUtils.isNotEmpty(token))
        {
            String userKey = getTokenKey(token);
            redisCache.deleteObject(userKey);
        }
    }

    /**
     * 创建令牌
     * 
     * @param userInfoDTO 用户信息
     * @return 令牌
     */
    public String createToken(UserInfoDTO userInfoDTO)
    {
        String token = IdUtils.fastUUID();
        userInfoDTO.setToken(token);
        setUserAgent(userInfoDTO);
        refreshToken(userInfoDTO);

        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY, token);
        return createToken(claims);
    }

    /**
     * 验证令牌有效期，相差不足20分钟，自动刷新缓存
     * 
     * @param userInfoDTO 令牌
     * @return 令牌
     */
    public void verifyToken(UserInfoDTO userInfoDTO)
    {
        long expireTime = userInfoDTO.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MILLIS_MINUTE_TEN)
        {
            refreshToken(userInfoDTO);
        }
    }

    /**
     * 刷新令牌有效期
     * 
     * @param userInfoDTO 登录信息
     */
    public void refreshToken(UserInfoDTO userInfoDTO)
    {
        userInfoDTO.setLoginTime(System.currentTimeMillis());
        userInfoDTO.setExpireTime(userInfoDTO.getLoginTime() + expireTime * MILLIS_MINUTE);
        // 根据uuid将loginUser缓存
        String userKey = getTokenKey(userInfoDTO.getToken());
        String userInfoJson = JSONObject.toJSONString(userInfoDTO);
        redisCache.setCacheObject(userKey, userInfoJson, expireTime, TimeUnit.MINUTES);
    }
    
    /**
     * 设置用户代理信息
     * 
     * @param userInfoDTO 登录信息
     */
    public void setUserAgent(UserInfoDTO userInfoDTO)
    {
        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        userInfoDTO.setIpaddr(ip);
        userInfoDTO.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
        userInfoDTO.setBrowser(userAgent.getBrowser().getName());
        userInfoDTO.setOs(userAgent.getOperatingSystem().getName());
    }
    
    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String createToken(Map<String, Object> claims)
    {
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret).compact();
        return token;
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims parseToken(String token)
    {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token)
    {
        Claims claims = parseToken(token);
        return claims.getSubject();
    }

    /**
     * 获取请求token
     *
     * @param request
     * @return token
     */
    private String getToken(HttpServletRequest request)
    {
        String token = request.getHeader(header);
        if (StringUtils.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX))
        {
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }

    private String getTokenKey(String uuid)
    {
        return Constants.LOGIN_TOKEN_KEY + uuid;
    }
}
