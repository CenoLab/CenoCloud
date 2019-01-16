some tip:

1.jar package cannot be run ，because circle dependency
 solution：zip -d facade_app.jar 'META-INF/*.DSA' 'META-INF/*.RSA' 'META-INF/*.SF'

2.dubbo.xsd file not exists
 solution：put other jar package into classpath

3. no class found
 solution: when you add a new facade into project,you should delete the service artifacts which use that facade first and re create this service artifacts

4. if there sometime show 404 not found that may means spring context not load
solution: reconfig the spring context

Notice: rember this url below,it can help u:
http://dubbo.io/FAQ-zh.htm



