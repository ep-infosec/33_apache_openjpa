/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openjpa.kernel;

import org.apache.openjpa.enhance.UnenhancedPropertyAccess;
import org.apache.openjpa.persistence.test.AllowFailure;

@AllowFailure(message="excluded")
public class TestUnenhancedPropertyAccessInstanceBrokerSerialization
    extends AbstractBrokerSerializationTest<UnenhancedPropertyAccess> {

    @Override
    protected Class<UnenhancedPropertyAccess> getManagedType() {
        return UnenhancedPropertyAccess.class;
    }

    @Override
    protected UnenhancedPropertyAccess newManagedInstance() {
        UnenhancedPropertyAccess e = new UnenhancedPropertyAccess();
        e.setStringField("foo");
        return e;
    }

    @Override
    protected void modifyInstance(UnenhancedPropertyAccess e) {
        e.setStringField("modified");
    }

    @Override
    protected Object getModifiedValue(UnenhancedPropertyAccess e) {
        return e.getStringField();
    }
}
