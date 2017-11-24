package com.icinfo.cs.common.logintoken;

import com.icinfo.cs.system.model.SysUser;
import com.icinfo.framework.security.shiro.LoginToken;

/**
 * 描述：
 *
 * @author 朱德峰
 * @date 2016/12/23
 */
@SuppressWarnings("serial")
public class CSLoginToken extends LoginToken {
    private String userType;
    SysUser sysUser;
    private String userPasswordKey;
    public CSLoginToken(String username, String password) {
        super(username, password);
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public void setUserPasswordKey(String userPasswordKey) {
		this.userPasswordKey = userPasswordKey;
	}
    
    public String getUserPasswordKey() {
		return userPasswordKey;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
}
