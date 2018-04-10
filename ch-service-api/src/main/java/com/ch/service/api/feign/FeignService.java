package com.ch.service.api.feign;

import com.ch.service.api.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;



/**
 * @author cj-ch
 * @date 2018/4/10 上午8:55
 */
public interface FeignService {

    @GetMapping("/feign4")
    String feign4();

    @GetMapping("/feign5")
    String feign5(@RequestHeader("name") String name);

    @PostMapping("/feign6")
    String feign6(@RequestBody User user);
}
