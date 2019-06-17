package com.bebit.gramagent;

import com.bebit.gramagent.util.FileUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This test requires environment setup to run on remote system.
 * 
 * @author binodraj-pandey
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SelectUsersByDateActTest {
  @Autowired
  private RabbitTemplate rabbitTemplate;
  @Autowired
  private GmaSessionConfig gmaSessionConfig;

  @Test
  public void parseJsonToSelectUsesByDateActObject() throws InterruptedException {
    String jsonFile = "src/test/resources/select_users_by_date_valid.json";
    byte[] byteArrayFromFile = FileUtil.getByteArrayFromFile(jsonFile);
    String json = new String(byteArrayFromFile);
    MessageProperties properties =
        new MessageProperties();
    properties.setContentType("application/json");
    properties.getHeaders().put("ret_queue_name", "ret_queue_name");
    rabbitTemplate.send(gmaSessionConfig.getExchangeName(),
        gmaSessionConfig.getRoutingKey(),
        MessageBuilder.withBody(json.getBytes()).andProperties(properties).build());
    // TODO we should be able to receive acknowledgement from return queue

  }

}
