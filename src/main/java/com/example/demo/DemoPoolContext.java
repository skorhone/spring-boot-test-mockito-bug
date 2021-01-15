package com.example.demo;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.target.CommonsPool2TargetSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration(proxyBeanMethods = false)
public class DemoPoolContext {
    public static final String ID = "DemoPool";

	@Bean(name = "demoProxy")
	public DemoBean demoProxy(@Qualifier(ID) ProxyFactoryBean federationProxyFactoryBean) {
		return (DemoBean) federationProxyFactoryBean.getObject();
	}

    @Bean
    @Qualifier(ID)
    @Scope("prototype")
    public DemoBean demo() {
        return new DemoBean();
    }

    @Bean
    @Qualifier(ID)
    public CommonsPool2TargetSource demoPoolTargetSource() {
        final CommonsPool2TargetSource commonsPoolTargetSource = new CommonsPool2TargetSource();
        commonsPoolTargetSource.setTargetBeanName("demo");
        commonsPoolTargetSource.setMaxSize(2);
        return commonsPoolTargetSource;
    }

    @Bean
    @Qualifier(ID)
    public ProxyFactoryBean proxyFactoryBean(@Qualifier(ID) CommonsPool2TargetSource targetSource) {
        ProxyFactoryBean p = new ProxyFactoryBean();
        p.setTargetSource(targetSource);
        p.setProxyTargetClass(true);
        return p;
    }    
}
