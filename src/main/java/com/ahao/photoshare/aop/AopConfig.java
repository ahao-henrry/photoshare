package com.ahao.photoshare.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.ahao.photoshare.aop")
@EnableAspectJAutoProxy
public class AopConfig {

}
