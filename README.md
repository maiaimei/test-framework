[https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/)

[https://www.thymeleaf.org/](https://www.thymeleaf.org/)



FileSystemResource、ClassPathResource、 InputStreamResource、ServletContextResource、 UrlResource 的区别如下：

- FileSystemResource 从文件系统中加载，效果类似于Java中的File
- ClassPathResource 从类路径中加载，效果类似于this.getClass().getResource("/").getPath()
- InputStreamResource 从输入流中加载
- ServletContextResource 从Servlet 上下文环境中加载，效果类似于request.getServletContext()
  .getRealPath("")
- UrlResource 从指定的Url中加载

Class.getResource("") 获取的是相对于当前类的相对路径。

Class.getResource("／") 获取的是classpath的根路径。

ClassLoader.getResource("") 获取的是classpath的根路径
