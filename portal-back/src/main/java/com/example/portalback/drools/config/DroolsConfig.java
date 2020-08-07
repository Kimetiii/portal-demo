package com.example.portalback.drools.config;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.spring.KModuleBeanFactoryPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * @author songsenior
 * @date 2020/7/29 08:53
 * @Description:
 */
@Configuration
public class DroolsConfig {
	// 指定规则文件存放路径
	private static final String RULE_PATH = "rules/";

	private final KieServices kieServices = KieServices.Factory.get();

	@Bean
	@ConditionalOnMissingBean
	public KieFileSystem kieFileSystem() throws IOException {
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		Resource[] files = getRuleFiles();
		String path = null;
		for (Resource file : files) {
			path = RULE_PATH + file.getFilename();
			kieFileSystem.write(ResourceFactory.newClassPathResource(path, "UTF-8"));
		}
		return kieFileSystem;
	}

	private Resource[] getRuleFiles() throws IOException {
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		return resourcePatternResolver.getResources("classpath*:" + RULE_PATH + "*.*");
	}

	/**
	 * 创建容器对象
	 *
	 * @return KieContainer
	 * @throws IOException IOException
	 */
	@Bean
	@ConditionalOnMissingBean
	public KieContainer kieContainer() throws IOException {
		KieRepository kieRepository = kieServices.getRepository();
		kieRepository.addKieModule(kieRepository::getDefaultReleaseId);
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem());
		kieBuilder.buildAll();
		return kieServices.newKieContainer(kieRepository.getDefaultReleaseId());
	}


	@Bean
	@ConditionalOnMissingBean
	public KieBase kieBase() throws IOException {
		return kieContainer().getKieBase();
	}

	@Bean
	@ConditionalOnMissingBean
	public KieSession kieSession() throws IOException {
		return kieContainer().newKieSession();
	}

	@Bean
	@ConditionalOnMissingBean
	public KModuleBeanFactoryPostProcessor kiePostProcessor() {
		return new KModuleBeanFactoryPostProcessor();
	}
}
