package com.iot.nero.mq.callbacks;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.hivemq.spi.aop.cache.Cached;
import com.hivemq.spi.callback.CallbackPriority;
import com.hivemq.spi.callback.exception.AuthenticationException;
import com.hivemq.spi.callback.security.OnAuthenticationCallback;
import com.hivemq.spi.message.ReturnCode;
import com.hivemq.spi.security.ClientCredentialsData;
import com.iot.nero.mq.Consumer;
import com.iot.nero.mq.dto.ClientConn;
import com.iot.nero.mq.dto.Result;
import com.iot.nero.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/29
 * Time   下午6:22
 */
public class UserAuthentication implements OnAuthenticationCallback {
    Logger log = LoggerFactory.getLogger(UserAuthentication.class);

    private IClientService clientService;

    @Override
    public Boolean checkCredentials(ClientCredentialsData clientData) throws AuthenticationException {


        String username;
        if (!clientData.getUsername().isPresent()) {
            throw new AuthenticationException("No Username provided", ReturnCode.REFUSED_NOT_AUTHORIZED);
        }
        username = clientData.getUsername().get();


        if (Strings.isNullOrEmpty(username)) {
            throw new AuthenticationException("No Username provided", ReturnCode.REFUSED_NOT_AUTHORIZED);
        }

        Optional<String> password = Optional.fromNullable(retrievePasswordFromDatabase(username));

        if (!password.isPresent()) {
            throw new AuthenticationException("No Account with the credentials was found!", ReturnCode.REFUSED_NOT_AUTHORIZED);
        } else {
            String clientId = clientData.getClientId();
            String productKey = clientData.getUsername().get();
            String productSecret = clientData.getPassword().get();

            try{
                clientService= (IClientService) Consumer.singleton().getBean("IClientService");
                System.out.println("auth start!!!");
                Result<ClientConn> result = clientService.clientAuth(clientId,productKey,productSecret);
                log.info(result.toString());
                if(result.isState()){
                    System.out.println("auth success!!!");
                    return true;
                }else{
                    System.out.println("auth failed!!!");
                    return false;
                }
            }catch (Exception e){
                log.info(e.getMessage());
                return false;
            }
        }
    }

    @Cached(timeToLive = 10, timeUnit = TimeUnit.MINUTES)
    private String retrievePasswordFromDatabase(String username) {

        String password ="";     //Call to any database to ask for the password of the user

        return password;
    }

    @Override
    public int priority() {
        return CallbackPriority.MEDIUM;
    }
}
