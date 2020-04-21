# 2020-04-13
------创建工程基础-------------
1.建module
2.改pom
3.建yml
4.写主启动类
5.写业务类
6.测试


------内容进度-------------
1.搭建springCloud的主工程
2.完成provider-payment支付模块springboot搭建
3.完成order-payment订单模块springboot搭建
4.完成springboot和swagger2的集成

------遇到的问题-------------
1.springcloud版本：H版；springboot 版本：2.2.2;swagger2版本：2.9.2 版本要保持一致
2.order-payment 调用provider-payment的create时，参数传不过去？
  原因：provider-payment的create方法的参数要实现@RequestBody 注解

# 2020-04-14
------集成eureka-------------
1.erueka-service服务端模块搭建
2.privider-payment8001、order-payment80工程作为eruekaclient注册到主服务

------集成zookeeper----------------------------
1.服务搭建完成

------集成consul----------------------------
1.docker拉取consul镜像
 docker pull consul 

2.consul参数详解
–net=host docker参数, 使得docker容器越过了net namespace的隔离，免去手动指定端口映射的步骤
-server consul支持以server或client的模式运行, server是服务发现模块的核心, client主要用于转发请求
-advertise 通告地址用于更改我们通告给集群中其他节点的地址。默认情况下，-bind地址是通告的。
-retry-join 指定要加入的consul节点地址，失败后会重试, 可多次指定不同的地址
-client Consul将绑定客户端接口的地址，包括HTTP和DNS服务器。默认情况下，这是“127.0.0.1”，只允许回送连接。
-bind 内部集群通信绑定的地址。这是集群中所有其他节点都应该可以访问的IP地址。默认情况下，这是“0.0.0.0”，集群内的所有节点到地址必须是可达的
-bootstrap-expect 此标志提供数据中心中预期服务器的数量。不应该提供此值，或者该值必须与群集中的其他服务器一致。指定后，Consul将等待指定数量的服务器可用，然后启动群集。允许自动选举leader，但不能与传统-bootstrap标志一起使用, 需要在server模式下运行。
-data-dir 此标志为代理存储状态提供了一个数据目录。这对所有代理都是必需的。该目录在重新启动时应该是持久的。这对于在服务器模式下运行的代理尤其重要，因为它们必须能够保持群集状态。此外，该目录必须支持使用文件系统锁定，这意味着某些类型的已装入文件夹（例如VirtualBox共享文件夹）可能不合适
-node 群集中此节点的名称，这在群集中必须是唯一的，默认情况下是节点的主机名。
-config-dir 指定配置文件，当这个目录下有 .json 结尾的文件就会被加载
-enable-script-checks 检查服务是否处于活动状态，类似开启心跳
-datacenter 数据中心名称。如果未提供，则默认为“dc1”。Consul对多个数据中心拥有一流的支持，但它依赖于正确的配置。同一个数据中心内的节点应该位于单个局域网中。
-ui - 启用内置的Web UI服务器和所需的HTTP路由。这消除了将Consul Web UI文件与二进制文件分开维护的需要。
-join 指定ip, 加入到已有的集群中
3.使用consul
1.启动第一个节点, 叫consul1
 docker run --name consul1 -d -p 18500:8500 -p 18300:8300 -p 18301:8301 -p 18302:8302 -p 18600:8600 consul agent -server -bootstrap-expect 2 -ui -bind=0.0.0.0 -client=0.0.0.0 

端口详解
8500 : http 端口，用于 http 接口和 web ui访问；
8300 : server rpc 端口，同一数据中心 consul server 之间通过该端口通信
8301 : serf lan 端口，同一数据中心 consul client 通过该端口通信; 用于处理当前datacenter中LAN的gossip通信
8302 : serf wan 端口，不同数据中心 consul server 通过该端口通信; agent Server使用，处理与其他datacenter的gossip通信；
8600 : dns 端口，用于已注册的服务发现；
2.查看容器ip地址
查看consul1的ip地址  docker inspect --format='{{.NetworkSettings.IPAddress}}' consul1

# 输出192.168.100.3
3.启动第二个consul服务(端口8501)：consul2， 并加入consul1（使用join命令）
 docker run --name consul2 -d -p 18501:8500 consul agent -server -ui -bind=0.0.0.0 -client=0.0.0.0 -join 192.168.100.3  

4.启动第三个consul服务(端口8502)：consul3， 并加入consul1（使用join命令）
 docker run --name consul3 -d -p 18502:8500 consul agent -server -ui -bind=0.0.0.0 -client=0.0.0.0 -join 192.168.100.3  

5.查看consul集群信息
 docker exec -it consul1 consul members 

// 可以看到集群里的三个节点
Node          Address          Status  Type    Build  Protocol  DC   Segment
618e9f617509  172.17.0.5:8301  alive   server  1.6.2  2         dc1  <all>
6ba34e2feb66  172.17.0.6:8301  alive   server  1.6.2  2         dc1  <all>
8cba36da0384  172.17.0.7:8301  alive   server  1.6.2  2         dc1  <all>
6.通过访问8500/8501/8502端口查看web界面
我是在阿里云上,记得开放安全端口


------集成feign----------------------------
1.main方法上增加@EnableFeignCliends
2.service方法增加FeignClient
3.service上的GetMapper必须要要调用的服务类上的路径一致


# 2020-04-15
------集成hystrix-------------
1.main方法上增加@EnableHystrix注解
2.controller的方法上增加HystrixCommand


# 2020-04-16
1.springcloud-bus
2.阿里云的rabbitMQ必须 开放15672 5672两个端口
curl -X POST http://eureka7001.com:3344/actuator/bus-refresh
