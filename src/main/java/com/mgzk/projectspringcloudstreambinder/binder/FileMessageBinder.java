package com.mgzk.projectspringcloudstreambinder.binder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.springframework.cloud.stream.binder.AbstractMessageChannelBinder;
import org.springframework.cloud.stream.binder.ConsumerProperties;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.cloud.stream.provisioning.ConsumerDestination;
import org.springframework.cloud.stream.provisioning.ProducerDestination;
import org.springframework.integration.core.MessageProducer;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

public class FileMessageBinder extends AbstractMessageChannelBinder<ConsumerProperties, ProducerProperties, FileProvisioningProvider> {

  public FileMessageBinder(String[] headersToEmbed, FileProvisioningProvider provisioningProvider) {
    super(headersToEmbed, provisioningProvider);
  }

  @Override
  protected MessageHandler createProducerMessageHandler(ProducerDestination destination, ProducerProperties producerProperties, MessageChannel errorChannel)
    throws Exception {
    return message -> {
      String fileName = destination.getName();
      String payload = new String((byte[]) message.getPayload()) + "\n";

      try {
        Files.write(Paths.get(fileName), payload.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    };
  }

  @Override
  protected MessageProducer createConsumerEndpoint(ConsumerDestination destination, String group, ConsumerProperties properties) throws Exception {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
