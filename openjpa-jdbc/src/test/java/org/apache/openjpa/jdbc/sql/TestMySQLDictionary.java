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
package org.apache.openjpa.jdbc.sql;

import static org.junit.Assert.assertEquals;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.openjpa.jdbc.kernel.JDBCFetchConfiguration;
import org.apache.openjpa.jdbc.kernel.JDBCFetchConfigurationImpl;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class TestMySQLDictionary {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void testDBDictionaryGetBatchFetchSize() throws Exception {
        DBDictionary db = new MySQLDictionary();
        assertEquals(Integer.MIN_VALUE, db.getBatchFetchSize(1));
    }



    /**
     * <P>
     * Ensure that <code>SQLBuffer.prepareStatement</code> calls
     * <code>setFetchSize(Integer.MIN_VALUE)</code> when using MySQL.
     * </P>
     *
     * @throws Exception
     *             If any of the expectations are not met or any unexpected
     *             method calls are made
     */
    @Test
    public void testPreparedStatementGetFetchBatchSize() throws Exception {
        DBDictionary db = new MySQLDictionary();
        SQLBuffer sql = new SQLBuffer(db);

        final PreparedStatement mockStatement = context.mock(PreparedStatement.class);
        final Connection mockConnection = context.mock(Connection.class);

        // Expected method calls on the mock objects above. If any of these are
        // do not occur, or if any other methods are invoked on the mock objects
        // an exception will be thrown and the test will fail.
        context.checking(new Expectations()
        {
            {
                oneOf(mockConnection).prepareStatement(with(any(String.class)));
                will(returnValue(mockStatement));
                oneOf(mockStatement).setFetchSize(Integer.MIN_VALUE);
            }
        });

        JDBCFetchConfiguration fetch = new JDBCFetchConfigurationImpl();
        fetch.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
        fetch.setFetchBatchSize(1);

        sql.prepareStatement(mockConnection, fetch, -1, -1);
    }

    /**
     * <P>
     * Ensure that <code>SQLBuffer.prepareCall()</code> calls
     * <code>setFetchSize(Integer.MIN_VALUE)</code> when using MySQL.
     * </P>
     *
     * @throws Exception
     *             If any of the expectations are not met or any unexpected
     *             method calls are made
     */
    @Test
    public void testPreparedCallGetFetchBatchSize() throws Exception {
        DBDictionary db = new MySQLDictionary();
        SQLBuffer sql = new SQLBuffer(db);

        final CallableStatement mockStatement = context.mock(CallableStatement.class);
        final Connection mockConnection = context.mock(Connection.class);

        // Expected method calls on the mock objects above. If any of these are
        // do not occur, or if any other methods are invoked on the mock objects
        // an exception will be thrown and the test will fail.
        context.checking(new Expectations() {
            {
                oneOf(mockConnection).prepareCall(with(any(String.class)));
                will(returnValue(mockStatement));
                oneOf(mockStatement).setFetchSize(Integer.MIN_VALUE);
            }
        });

        JDBCFetchConfiguration fetch = new JDBCFetchConfigurationImpl();
        fetch.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
        fetch.setFetchBatchSize(1);

        sql.prepareCall(mockConnection, fetch, -1, -1);
    }
}
