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
package org.apache.openjpa.persistence.query;

import org.apache.openjpa.persistence.OpenJPAQuery;
import org.apache.openjpa.persistence.simple.AllFieldTypes;
import org.apache.openjpa.persistence.test.SingleEMTestCase;

public class TestDataStoreActions
    extends SingleEMTestCase {

    @Override
    public void setUp() {
        setUp(AllFieldTypes.class);
    }

    public void testDataStoreActions() {
        OpenJPAQuery q = em.createQuery("select o from AllFieldTypes o");
        String[] sql = q.getDataStoreActions(null);
        assertEquals(1, sql.length);
        assertTrue(sql[0].startsWith("SELECT"));
    }
}
