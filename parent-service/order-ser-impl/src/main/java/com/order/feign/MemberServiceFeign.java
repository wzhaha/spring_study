package com.order.feign;

import api.service.IMemberService;
import com.order.fallback.MemberServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "member-service",fallback = MemberServiceFallback.class)
public interface MemberServiceFeign extends IMemberService {

}