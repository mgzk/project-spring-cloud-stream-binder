package com.mgzk.projectspringcloudstreambinder.binder;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileMessageBinderConfiguration {
  @Bean
  @ConditionalOnMissingBean
  public FileProvisioningProvider fileProvisioningProvider() {
    return new FileProvisioningProvider();
  }

  @Bean
  @ConditionalOnMissingBean
  public FileMessageBinder fileMessageBinder(FileProvisioningProvider fileProvisioningProvider) {
    return new FileMessageBinder(null, fileProvisioningProvider);
  }
}
