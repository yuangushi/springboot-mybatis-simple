package com.ylp.test.importBeans;

import com.ylp.test.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

@Component
public class ImportBeanRegistarBean implements ImportBeanDefinitionRegistrar, BeanFactoryAware, InitializingBean {
   private BeanFactory beanFactory;
   @Autowired
   private UserService userService;
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println(ImportBeanRegistarBean.class.getSimpleName()+"-----"+userService);

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory=beanFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(ImportBeanRegistarBean.class.getSimpleName()+"-----"+userService);
    }
}
