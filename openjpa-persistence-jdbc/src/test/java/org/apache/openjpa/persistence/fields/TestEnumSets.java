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
package org.apache.openjpa.persistence.fields;

import java.util.EnumSet;

import org.apache.openjpa.persistence.test.SingleEMTestCase;

public class TestEnumSets
    extends SingleEMTestCase {

    @Override
    public void setUp() {
        setUp(EnumSetOwner.class, CLEAR_TABLES);
    }

    public void testExternalizedEnumSet() {
        // test that inserting works
        EnumSetOwner o = new EnumSetOwner();
        o.setEnumSet(EnumSet.allOf(SampleEnum.class));

        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        Object oid = em.getObjectId(o);
        em.close();

        // ... and that loading works, with a new EM
        em = emf.createEntityManager();
        o = em.find(EnumSetOwner.class, oid);
        assertEquals(EnumSet.allOf(SampleEnum.class), o.getEnumSet());
    }
}
