package cn.maiaimei.example;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.JdkIdGenerator;
import org.springframework.util.SimpleIdGenerator;

@Slf4j
@Disabled
public class IDGeneratorTest {

  @Test
  public void test_hutool_IdUtil() {
    log.info("UUID.randomUUID()");
    log.info("获取随机UUID，UUID.randomUUID().toString()：{}",
        IdUtil.randomUUID()); // dff8be52-0810-41d4-9429-6758e69d9bc0
    log.info("获取随机UUID，去掉了横线，UUID.randomUUID().toString(true)：{}",
        IdUtil.simpleUUID()); // ac0060048c05447a9caa6fa3030192f3

    log.info("UUID.fastUUID()");
    log.info("获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID，UUID.fastUUID().toString()：{}",
        IdUtil.fastUUID()); // b8c6f3a0-d0f7-457c-b9ab-85cfd298437d
    log.info(
        "获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID，去掉了横线，UUID.fastUUID().toString(true)：{}",
        IdUtil.fastSimpleUUID()); // f9ed9c72fb2946faaed8f04254604968

    log.info("NanoId.randomNanoId()");
    log.info("获取随机NanoId，NanoId.randomNanoId()：{}",
        IdUtil.nanoId()); // H3_PdOA4eaFQ4Z5Kc6ky4
    log.info(
        "获取随机NanoId，NanoId.randomNanoId(size)：{}",
        IdUtil.nanoId(19)); // fsdwIlcq1WYF8QKlFa6

    log.info(
        "雪花算法（Snowflake）是 Twitter 开源的分布式 ID 生成算法，可以生成不重复的、有序的、可自增的 64 位 ID");
    log.info("{}", IdUtil.getSnowflake(1, 1).nextId()); // 1751116912034713600
    log.info("{}", IdUtil.getSnowflakeNextId()); // 1751116912273666048
  }

  @Test
  public void test_springframework_IdGenerator() {
    // 00000000-0000-0000-0000-000000000001
    log.info("new SimpleIdGenerator().generateId(): {}", new SimpleIdGenerator().generateId());
    // 3935499f-ca1f-4989-8d0f-f6f0ed1e7a66
    log.info("new JdkIdGenerator().generateId(): {}", new JdkIdGenerator().generateId());
    // 305be777-dd6a-8183-e233-5ee7b00271a6
    log.info("new AlternativeJdkIdGenerator().generateId(): {}",
        new AlternativeJdkIdGenerator().generateId());
  }

  @Test
  public void test_custom_id() {
    final AtomicInteger atomicInteger = new AtomicInteger(0);
    final DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    List<BigDecimal> ids = new ArrayList<>();
    for (int i = 0; i < 200; i++) {
      if (atomicInteger.get() >= 99) {
        atomicInteger.set(0);
      }
      final String s1 = LocalDateTime.now().format(pattern);
      final String s2 = StrUtil.padPre(String.valueOf(atomicInteger.incrementAndGet()), 2, "0");
      ids.add(new BigDecimal(s1.concat(s2)));
    }
    Set<BigDecimal> idSet = new HashSet<>(ids);
    log.info("重复ID个数：{}", ids.size() - idSet.size());
    for (BigDecimal id : ids) {
      log.info("{}", id);
    }
  }
}
