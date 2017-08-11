package com.zy.api;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.junit.Test;

public class HelloWorld {

	@Test // 使用activiti提供的自动建表(无配置文件)
	public void test() {
		// 创建一个流程引擎配置对象
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createStandaloneProcessEngineConfiguration();

		// 配置数据源
		configuration.setJdbcDriver("com.mysql.jdbc.Driver");
		configuration.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/activiti?useUnicode=true&characterEncoding=utf-8");
		configuration.setJdbcUsername("root");
		configuration.setJdbcPassword("123123");

		// 设置自动建表
		configuration.setDatabaseSchemaUpdate("true");

		// 创建一个流程引擎对象，在创建流程引擎对象的时候回自动创建表
		ProcessEngine engine = configuration.buildProcessEngine();
	}

	@Test // 使用框架提供的自动建表(配置文件)
	public void test1() {
		String resource = "activiti-context.xml";
		String beanName = "processEngineConfiguration";

		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource(resource, beanName);

		ProcessEngine processEngine = configuration.buildProcessEngine();

		DeploymentBuilder deploymentBuilder = processEngine.getRepositoryService().createDeployment();

		// 部署规则的名称
		deploymentBuilder.name("请假流程部署");
		// 读取单个的流程定义文件
		deploymentBuilder.addClasspathResource("test1.bpmn");
		deploymentBuilder.addClasspathResource("vote.png");

		Deployment deployment = deploymentBuilder.deploy();
		System.out.println(deployment.getId() + "  " + deployment.getName());
	}

	@Test // 直接使用spring完全代管的配置文件自动建表
	public void test2() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	}

}
