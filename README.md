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
