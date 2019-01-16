package com.iot.nero.facade_sso.dao;

import com.iot.nero.parent_sso.entity.VerifyCode;
import com.sun.tracing.dtrace.ProviderAttributes;
import org.apache.ibatis.annotations.Param;

public interface VerifyDao {

    VerifyCode getVerifyCodeByDeveloperIdAndEmail(@Param("did") Integer developerId,@Param("email") String email);

    VerifyCode getVerifyCodeByPhone(@Param("phone") String phone);

    VerifyCode getVerifyCodeByEmail(@Param("email") String email);

    Integer updatePhoneCodeByDeveloperId(@Param("did") Integer developerId,@Param("code") String code);

    Integer updateEmailCodeByDeveloperIdAndEmail(@Param("did") Integer developerId,@Param("email") String email,@Param("code") String code);

    Integer insertIntoEmailVerifyCode(@Param("did") Integer id, @Param("email") String email, @Param("code") String verifyCode);
}
