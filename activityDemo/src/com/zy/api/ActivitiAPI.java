package com.zy.api;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.junit.*;

public class ActivitiAPI {
		
	//先从配置文件中拿到默认的流程引擎
	ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
	
	/**
	 * 部署流程定义：分别在三张表中生成数据
	 * 二进制数据表：act_ge_bytearray 生成两条数据
	 * 部署信息表：act_re_deployment 生成一条数据
	 * 流程定义表：act_re_procdef 生成一条数据
	 * 		有两种方式
	 */
	
	@Test//第一种：设置发布信息
	public void deploy(){
		
		//获取仓库服务并创建发布对象
		DeploymentBuilder deploymentBuilder=processEngine.getRepositoryService().createDeployment();
		
		//部署规则的名称
		deploymentBuilder.name("请假流程部署");
		//读取单个的流程定义文件
		deploymentBuilder.addClasspathResource("process/test1.bpmn");
		deploymentBuilder.addClasspathResource("process/vote.png");
		
		Deployment deployment=deploymentBuilder.deploy();
		System.out.println(deployment.getId()+"  "+deployment.getName());
	}
	
}
