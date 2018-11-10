//package com.tencent.spring.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
//import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import java.util.List;
//
///**
// *
// * @author chenqi
// *
// * @date 2017年6月27日下午6:43:08
// */
//@Configuration
//public class WebConfiguration extends WebMvcConfigurerAdapter {
//	 /**
//     * 重写configurePathMatch此方法
//     * 设置其参数PathMatchConfigurer的属性UseSuffixPatternMatch值为false
//     * 可以让路径中带小数点“.”后面的值不被忽略
//     */
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer){
//        configurer.setUseSuffixPatternMatch(false);
//    }
//
//	@Override
//	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
//		super.addReturnValueHandlers(returnValueHandlers);
//	}
//
//
//	//    @Bean
////	public InternalResourceViewResolverMy getInternalResourceViewResolver() {
////	    InternalResourceViewResolverMy internalResourceViewResolver = new InternalResourceViewResolverMy();
////	    internalResourceViewResolver.setCacheLimit(0);
////	    return internalResourceViewResolver;
////    }
//}