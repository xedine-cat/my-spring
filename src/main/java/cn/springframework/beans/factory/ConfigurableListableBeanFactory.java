package cn.springframework.beans.factory;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.springframework.beans.factory.config.BeanDefinition;
import cn.springframework.beans.factory.config.BeanPostProcessor;
import cn.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 *
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
