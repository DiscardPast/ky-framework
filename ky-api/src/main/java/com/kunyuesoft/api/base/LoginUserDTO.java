package com.kunyuesoft.api.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kunyuesoft.common.base.UserInfoDTO;
import com.kunyuesoft.model.domain.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * 登录用户身份权限
 * 
 * @author kunyuesoft
 */
public class LoginUserDTO extends UserInfoDTO implements UserDetails
{
    private static final long serialVersionUID = 1L;

    private SysUser user;

    /**
     * 权限列表
     */
    private Set<String> permissions;


    public LoginUserDTO()
    {
    }

    public LoginUserDTO(SysUser user, Set<String> permissions)
    {
        this.user = user;
        this.permissions = permissions;
    }

    @JsonIgnore
    public String getPassword()
    {
        return this.user.getUserPassword();
    }

    public String getUsername()
    {
        return this.user.getUserName();
    }

    /**
     * 账户是否未过期,过期无法验证
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    /**
     * 指定用户是否解锁,锁定的用户无法进行身份验证
     * 
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    /**
     * 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
     * 
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    /**
     * 是否可用 ,禁用的用户不能身份验证
     * 
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isEnabled()
    {
        return true;
    }

    public Set<String> getPermissions()
    {
        return permissions;
    }

    public void setPermissions(Set<String> permissions)
    {
        this.permissions = permissions;
    }

    public SysUser getUser()
    {
        return user;
    }

    public void setUser(SysUser user)
    {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return null;
    }
}
