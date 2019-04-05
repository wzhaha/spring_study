package api.service;

import com.common.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IMemberService {

    @RequestMapping("/getMember")
    Object getMember(@RequestParam("name") String name);

    @RequestMapping("/getUserInfo")
    ResponseBase getUserInfo();
}
