package com.mgzk.projectspringcloudstreambinder.binder;

import org.springframework.cloud.stream.provisioning.ConsumerDestination;
import org.springframework.cloud.stream.provisioning.ProducerDestination;

public class FileProducerDestination implements ProducerDestination, ConsumerDestination {

  private final String destination;

  public FileProducerDestination(String destination) {
    this.destination = destination;
  }

  @Override
  public String getName() {
    return destination;
  }

  @Override
  public String getNameForPartition(int partition) {
    throw new UnsupportedOperationException("Partitioning is not implemented for file messaging.");
  }
}
