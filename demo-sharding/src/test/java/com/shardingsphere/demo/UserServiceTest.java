package com.shardingsphere.demo;

import com.shardingsphere.demo.entity.HealthTask;
import com.shardingsphere.demo.entity.User;
import com.shardingsphere.demo.repository.UserRepository;
import com.shardingsphere.demo.repository.HealthTaskRepository;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UserServiceTest {

	@Autowired
	private HealthTaskRepository healthTaskRepository;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testTable() throws Exception {
		HintManager hintManager = HintManager.getInstance();
		hintManager.setDatabaseShardingValue(1L);
		// 如何让两个主库内的所有表sql操作时都进入到MatchHintShardingAlgorithm
		// 不设置actual-data-nodes， 因为两个库中的表关联性不高，而且表会非常多
		List<HealthTask> tasks = healthTaskRepository.findEntities();
		hintManager.close();



		HintManager hintManager2 = HintManager.getInstance();
		hintManager2.setDatabaseShardingValue(2L);
		List<User> users = userRepository.findEntities();
		hintManager2.close();
	}
}
