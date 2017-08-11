package com.zy.api;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.junit.Test;

public class HelloWorld {

	@Test // ʹ��activiti�ṩ���Զ�����(�������ļ�)
	public void test() {
		// ����һ�������������ö���
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createStandaloneProcessEngineConfiguration();

		// ��������Դ
		configuration.setJdbcDriver("com.mysql.jdbc.Driver");
		configuration.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/activiti?useUnicode=true&characterEncoding=utf-8");
		configuration.setJdbcUsername("root");
		configuration.setJdbcPassword("123123");

		// �����Զ�����
		configuration.setDatabaseSchemaUpdate("true");

		// ����һ��������������ڴ���������������ʱ����Զ�������
		ProcessEngine engine = configuration.buildProcessEngine();
	}

	@Test // ʹ�ÿ���ṩ���Զ�����(�����ļ�)
	public void test1() {
		String resource = "activiti-context.xml";
		String beanName = "processEngineConfiguration";

		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource(resource, beanName);

		ProcessEngine processEngine = configuration.buildProcessEngine();

		DeploymentBuilder deploymentBuilder = processEngine.getRepositoryService().createDeployment();

		// ������������
		deploymentBuilder.name("������̲���");
		// ��ȡ���������̶����ļ�
		deploymentBuilder.addClasspathResource("test1.bpmn");
		deploymentBuilder.addClasspathResource("vote.png");

		Deployment deployment = deploymentBuilder.deploy();
		System.out.println(deployment.getId() + "  " + deployment.getName());
	}

	@Test // ֱ��ʹ��spring��ȫ���ܵ������ļ��Զ�����
	public void test2() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	}

}
