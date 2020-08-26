# shardingsphere-demo


### demo-sharding工程想要实现功能
```
master与slave 构成读写分离master0，
同时AOP扫描所有mapper，根据业务逻辑强制路由数据源master0，master1
```

### 问题
```
配置default-database-strategy为hint，
但不配置table.<logic-table-name>.actual-data-nodes时，
使用hintManager.setDatabaseShardingValue()后，
并不能进入到MatchHintShardingAlgorithm中，因此无法强制设置数据源
```

### 复现方式
```
执行test下的UserServiceTest中testTable方法，分别将断点定在UserServiceTest（32行）
MatchHintShardingAlgorithm（13行），
会发现执行sql之前，不会进入到MatchHintShardingAlgorithm内
```
