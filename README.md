# springbootRedisCluster
windows上搭建基础的redis服务集群，由springboot项目整合集群服务实现调用

1:创建多个文件夹存放配置文件

2:编写启动脚本并启动服务

3:安装ruby之后再安装rubygems

4:cmd中运行 `ruby -v` `gem -v` 检查安装是否正确

5:`gem install redis` ruby环境安装模块支持

6:下载redis-trib.rb放到集群根目录

7:编写启动集群脚本`redis-trib.rb create --replicas 1 127.0.0.1:7380 127.0.0.1:7381 127.0.0.1:7382 127.0.0.1:7383 127.0.0.1:7384 127.0.0.1:7385`   运行,便完成了基础的redis集群服务的搭建

# springboot整合redis集群方案

1:yml配置文件配置集群节点

2:创建RedisFactoryConfig手动实例化RedisConnectionFactory

3:创建RedisConfiguration注入手动实例化的RedisConnectionFactory,用于手动实例化RedisTemplate

4:启动项目测试

# springboot手动实例化关于@value问题
* 因为需要手动做一些配置对象，每个对象都有@Configuration注解，在这中情况下@value是没办法拿到yml中的配置数据的。只能通过注入Environment对象,使用getProperty方法来获得配置数据
* 手动实例化的RedisConnectionFactory需要由@Resource来注入
