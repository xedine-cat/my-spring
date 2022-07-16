### IDEA编译maven项目，无法下载依赖：could not transfer artifact xxx from xx

日期：2022-03-24 10:29浏览：3427[评论：11](http://3ms.huawei.com/km/blogs/details/11974527#comment_pop)

解决方案原文出处：
https://www.cnblogs.com/qcjcode/p/15781538.html

总结：
一般发生这个问题的原因是IDE的maven设置问题，证书问题，本地maven仓权限问题。

排查步骤如下：

1. 确定maven的设置正确，主要是maven里面的conf/settings.xml的配置问题
   File-settings-> maven
   ![image.png](http://image.huawei.com/tiny-lts/v1/images/a9e77e789b485833df26ecc24342fdfb_1124x866.png@900-0-90-f.png)

我的本地路径是D:\Program Files\apache-maven-3.6.3\conf\settings.xml

然后settings.xml设置maven的华为源，建议找组内的开发要一份settings.xml,直接用即可

重新下载试试，如果还不下，接着往下看

1. 解决证书问题

向File - settings - 的maven - importing中添加这句

-Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true

![image.png](http://image.huawei.com/tiny-lts/v1/images/6f36caf9d87acd8c24e09e1efa042a07_1120x874.png@900-0-90-f.png)

到这里基本就ok了，重新下载试试

如果还不行，再向File - settings中的maven - Runner中添加这句话：

-Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true -DarchetypeCatalog=internal

![image.png](http://image.huawei.com/tiny-lts/v1/images/b6d7a60bdd464b2516510268726b6855_1116x864.png@900-0-90-f.png)

1. 如果以上的问题都弄了还有问题，那么很有可能就是User用户对你创建的Maven的仓库的文件夹的访问权限不够，添加写入权限。
   ![image.png](http://image.huawei.com/tiny-lts/v1/images/8e040201719bf8f63528955c71b35e4a_522x775.png@900-0-90-f.png)



- 