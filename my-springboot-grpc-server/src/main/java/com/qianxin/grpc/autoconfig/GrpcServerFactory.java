package com.qianxin.grpc.autoconfig;

import io.grpc.Server;

/**
 * User: Michael
 * Email: yidongnan@gmail.com
 * Date: 5/17/16
 */
public interface GrpcServerFactory {
    Server createServer();

    String getAddress();

    int getPort();

    void addService(GrpcServiceDefinition service);
}
