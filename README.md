# Transactional Outbox Pattern

### 1. 사전 세팅.
- 카프카 (ver : kafka_2.12-3.7.0)
- Postgres (ver : postgres 15.2)
- 자바 17

### 2. FlowDiagram은 아래와 같다.
![TransactionalOutboxPattern](https://github.com/Nanninggu/Transactional-Outbox-Pattern/assets/54211801/b08a817e-ef6c-46dc-b196-7340f4db8423)

### 3. 기타 추가설명은 아래에 작성
#### 카프카 실행 명령어 Windows 기준
- 실행 location : C:\kafka_2.12-3.7.0\
- zookeeper : bin\windows\zookeeper-server-start.bat config\zookeeper.properties
- kafka server : bin\windows\kafka-server-start.bat config\server.properties
- 토픽 내용 확인 tail : bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic {topic_name}

### 추가 기록할 사항이 있으면 또 기록하자.
