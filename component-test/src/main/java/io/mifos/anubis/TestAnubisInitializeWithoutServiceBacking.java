/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.mifos.anubis;

import io.mifos.anubis.api.v1.domain.ApplicationSignatureSet;
import io.mifos.anubis.test.v1.TenantApplicationSecurityEnvironmentTestRule;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Myrle Krantz
 */
public class TestAnubisInitializeWithoutServiceBacking extends AbstractNoInitializeTest {

  @Test
  public void test()
  {
    final TenantApplicationSecurityEnvironmentTestRule tenantApplicationSecurityEnvironment
            = new TenantApplicationSecurityEnvironmentTestRule(testEnvironment);

    final ApplicationSignatureSet applicationSignatureSet
        = tenantApplicationSecurityEnvironment.initializeTenantInApplication();
    for (int i = 0; i < 50; i++ ) {
      final ApplicationSignatureSet x = tenantApplicationSecurityEnvironment.initializeTenantInApplication();
      Assert.assertEquals(applicationSignatureSet, x);
    }
  }
}
