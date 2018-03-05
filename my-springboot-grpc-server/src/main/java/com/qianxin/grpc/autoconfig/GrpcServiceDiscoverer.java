package com.qianxin.grpc.autoconfig;

import java.util.Collection;

/**
 * User: Michael
 * Email: yidongnan@gmail.com
 * Date: 5/17/16
 */
public interface GrpcServiceDiscoverer {
    Collection<GrpcServiceDefinition> findGrpcServices();
}
