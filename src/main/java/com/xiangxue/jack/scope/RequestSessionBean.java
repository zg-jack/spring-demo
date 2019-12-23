package com.xiangxue.jack.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

@Component
@Scope(value = RequestAttributes.REFERENCE_REQUEST/*,proxyMode = ScopedProxyMode.TARGET_CLASS*/)
public class RequestSessionBean {
}
