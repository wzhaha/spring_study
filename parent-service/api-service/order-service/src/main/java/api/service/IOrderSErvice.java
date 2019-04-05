package api.service;

import com.common.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

public interface IOrderSErvice {

    @RequestMapping("/getOrder")
    Object getOrder();

    @RequestMapping("/orderToMember")
    ResponseBase orderToMember();

    @RequestMapping("/orderToMemberHystrix")
    ResponseBase orderToMemberHystrix();
}
