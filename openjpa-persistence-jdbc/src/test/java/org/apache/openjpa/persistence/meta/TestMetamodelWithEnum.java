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

package org.apache.openjpa.persistence.meta;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.openjpa.persistence.test.SingleEMFTestCase;

public class TestMetamodelWithEnum extends SingleEMFTestCase {

    @Override
    public void setUp() {
        super.setUp(
                "openjpa.RuntimeUnenhancedClasses", "unsupported",
                "openjpa.DynamicEnhancementAgent", "false",
                Main.class, AttributeConverterImpl.class);
    }

    public void testEnsureEnumDontFail() { // OPENJPA-2743
        assertNotNull(emf.getMetamodel());
    }

    @Converter
    public static class AttributeConverterImpl implements AttributeConverter<MyEnum, String> {
        @Override
        public String convertToDatabaseColumn(final MyEnum myEnum) {
            return myEnum.name();
        }

        @Override
        public MyEnum convertToEntityAttribute(final String s) {
            return MyEnum.valueOf(s);
        }
    }

    @Entity
    public static class Main {
        @Id
        private String id;

        private MyEnum enumColumn;

        public String getId() {
            return id;
        }

        public void setId(final String id) {
            this.id = id;
        }

        public MyEnum getEnumColumn() {
            return enumColumn;
        }

        public void setEnumColumn(final MyEnum enumColumn) {
            this.enumColumn = enumColumn;
        }
    }

    public enum MyEnum {
        A
    }
}
