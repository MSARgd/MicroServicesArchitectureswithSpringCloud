package ma.enset.billingservice.controller;

import ma.enset.billingservice.config.MyConsulConfig;
import ma.enset.billingservice.config.MyVaultConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RefreshScope
public class ConsulConfugRestController {
    /**
    @Value("${token.accessTokenTimeOut}")
    private String 	accessTokenTimeOut;
    @Value("${token.refreshTokenTimeOut}")
    private String refreshTokenTimeOut;
    @GetMapping("/myConfig")
    public Map<String , Object> myConfig(){
        return Map.of("accessTokenTimeOut", accessTokenTimeOut,
                "refreshTokenTimeOut", refreshTokenTimeOut);

    }
     **/
    @Autowired
    private MyConsulConfig myConsulConfig;
    @Autowired
    private MyVaultConfig myVaultConfig;
    @GetMapping("/myConfig")
    public Map<String, Object> myConfig(){
        return Map.of("consulConfig",myConsulConfig,"vaultConfig",myVaultConfig);
    }


//    @Value("${user.name}")
//    private String 	name;
//    @Value("${user.token}")
//    private String token;
//    @GetMapping("/myConfig1")
//    public Map<String , Object> myConfig1(){
//        return Map.of("name", name,
//                "token", token);
//
//    }
}