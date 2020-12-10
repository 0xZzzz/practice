package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * rmi 服务端
 *
 * @author 0xZzzz
 */
public class Server {
    public static void main(String[] args) throws Exception {
        int port = 9527;
        String name = "BusinessDemo";
        Business business = new BusinessImpl();
        // 使用提供的特定端口导出远程对象，以便能够接收传入的调用
        UnicastRemoteObject.exportObject(business, port);
        // 创建并导出接受指定 port 请求的本地主机上的 Registry实例
        LocateRegistry.createRegistry(1099);
        Naming.bind(name, business);
    }
}
