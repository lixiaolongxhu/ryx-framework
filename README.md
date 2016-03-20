XXXX科技有限公司框架临时版：
	
	 后续还会对前端框架进行补充修改以及其他的完善
	 项目本身是一个测试框架，含有多种技术

项目构建组成: 
	
	maven+springMVC4.X(注解)+jdbcTempalte+mysql5.X+jetty++js+html+css+jdk7+jsp+jquery easyui

项目文档结构说明：

	src/main/java: 存放项目java业务代码。
	src/main/resources: 存放项目配置文件；spring 配置文件，数据库配置文件，日子配置文件，mybatis 代码生成配置文件(安装mybatis-generotor的eclipse插件后，鼠标右键，选择mybatis generotor 就可以在配置文件中指定的路径下生成代码)等。
	src/test/java : 测试代码文件路径，一般单元测试代码存放于该路径下。
	doc : 存放项目核心文件，数据库脚步，mybatis-generator(代码生成插件)等。
	src/main/webapp : 存放前端显示代码，jsp+js+html+css等。
	src/main/test : 存放前端测试代码，用户前端功能测试。
	Syslogs : log4j生成的系统日志路径，系统日志存放于该路径下。
	target : maven 项目编译打包文件存放路径。
	pom.xml : maven 项目jar加载配置
	README.md : 项目说明文件。
	webdefault.xml : 默认web配置文件，提供项目代码修改后，web容器重新自动编译，从而可以不用重新启动服务器。

项目构建组成详解：
	
	数据库持久化层(spring jdbcTemplate 或 nameJdbcTempalte): 
		1、包路径com.frmaework.core.dao 中使用jdbcTemaplte实现对dao层的统一封装，DslSql 是针对mysql数据库使用java发射生成对应的sql的工具类。
		1、优点：定义了sql语句查询语句拼写规则，并可以实现复杂的查询功能，查询的灵活性很高，统一了代码规则。对添加，修改，删除操作通过传入javabean程序生成sql进行操作，简化了daosql的编写。
		2、缺点：没有缓存，dao层的缓存操作必须使用其他缓存处理。sql语句的辅助生成使用java发射机制，这个对性能有所要求。
	
	memcache缓存嵌入：
		1、通过spring提供的接口，实现其接口以及相关的抽象类，实现注解缓存配置。	
	其他后端处理：
	     1、统一的异常返回机制。
	     2、统一的页面数据或者页面返回封装。
	     3、com.framework.core 是对spring mvc+jdbcTemplate 框架封装的核心代码，其他部分为业务代码。
	     4、定时任务，采用spring的任务调度。
	     
	     
	前端显示框架（暂时未调整好 预计使用jquery easyui）
	
		
				
项目开发部署：

	1、开发部署时选用jetty容器，配置与pom.xml文件，即可使用，无需安装单独的服务容器。
	2、生产部署时采用jetty服务器进行部署，最佳选择linux服务器。
	3、生产部署时采用tomcat服务器。请注意，开发时使用了jetty嵌入式服务器，在部署到tomcat时，项目应去除项目名，将项目的运行文件存放于tomcat中webapp/root文件下， 否则会存在相对路径定位出现错误。	