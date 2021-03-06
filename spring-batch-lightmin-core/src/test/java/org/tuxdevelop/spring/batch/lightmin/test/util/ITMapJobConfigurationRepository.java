package org.tuxdevelop.spring.batch.lightmin.test.util;

import org.tuxdevelop.spring.batch.lightmin.admin.domain.JobConfiguration;
import org.tuxdevelop.spring.batch.lightmin.admin.repository.MapJobConfigurationRepository;
import org.tuxdevelop.spring.batch.lightmin.exception.NoSuchJobConfigurationException;

import java.util.Collection;

import static org.junit.Assert.fail;

public class ITMapJobConfigurationRepository extends MapJobConfigurationRepository implements ITJobConfigurationRepository {

    @Override
    public void clean(final String applicationName) {
        final Collection<JobConfiguration> allJobConfigurations = super.getAllJobConfigurations(applicationName);
        for (final JobConfiguration jobConfiguration : allJobConfigurations) {
            try {
                super.delete(jobConfiguration,applicationName);
            } catch (final NoSuchJobConfigurationException e) {
                fail(e.getMessage());
            }
        }
    }
}
