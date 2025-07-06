package com.byquan2004.product;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@SpringBootTest
public class TestApplication {
    /**
     * 测试服务发现 可以通过两种接口获取服务列表 推荐使用spring cloud封装的接口
     */

    /**
     * spring cloud 封装的接口
     */
    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * spring cloud alibaba nacos 封装的接口
     */
    @Autowired
    NacosServiceDiscovery discoveryClient2;

    @Test
    void discoveryServiceTest() {
        for (String service : discoveryClient.getServices()) {
            System.out.println(service);
            for (var instance : discoveryClient.getInstances(service)) {
                System.out.println(instance.getHost());
                System.out.println(instance.getPort());
                System.out.println(instance.getServiceId());
            }
        }
    }
}
