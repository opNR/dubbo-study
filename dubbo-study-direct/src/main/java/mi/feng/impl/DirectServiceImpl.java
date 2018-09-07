package mi.feng.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import mi.feng.api.DirectService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: MiFeng
 * @Date: 2018/9/7 09:55
 * @Description:
 */
public class DirectServiceImpl implements DirectService {

    @Override
    public String sayHello(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name +", request from consumer: "
            + RpcContext.getContext().getRemoteAddress());

        return "Hello " + name +", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
