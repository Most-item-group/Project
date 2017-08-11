package com.zy.api;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.junit.*;

public class ActivitiAPI {
		
	//�ȴ������ļ����õ�Ĭ�ϵ���������
	ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
	
	/**
	 * �������̶��壺�ֱ������ű�����������
	 * ���������ݱ�act_ge_bytearray ������������
	 * ������Ϣ��act_re_deployment ����һ������
	 * ���̶����act_re_procdef ����һ������
	 * 		�����ַ�ʽ
	 */
	
	@Test//��һ�֣����÷�����Ϣ
	public void deploy(){
		
		//��ȡ�ֿ���񲢴�����������
		DeploymentBuilder deploymentBuilder=processEngine.getRepositoryService().createDeployment();
		
		//������������
		deploymentBuilder.name("������̲���");
		//��ȡ���������̶����ļ�
		deploymentBuilder.addClasspathResource("process/test1.bpmn");
		deploymentBuilder.addClasspathResource("process/vote.png");
		
		Deployment deployment=deploymentBuilder.deploy();
		System.out.println(deployment.getId()+"  "+deployment.getName());
	}
	
}
