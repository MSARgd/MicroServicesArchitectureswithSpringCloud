package ma.enset.configservice.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
@RestController
@RefreshScope
public class VaultConfigRestController {
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