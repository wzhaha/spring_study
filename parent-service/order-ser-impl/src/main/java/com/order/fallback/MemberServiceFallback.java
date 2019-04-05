package com.order.fallback;

import com.common.BaseApiService;
import com.common.ResponseBase;
import com.order.feign.MemberServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceFallback extends BaseApiService implements MemberServiceFeign {
    @Override
    public Object getMember(String name) {
        return setResultError("服务器忙，请稍后重试");
    }

    //提示
    @Override
    public ResponseBase getUserInfo() {
        return setResultError("服务器忙，请稍后重试");
    }
}
