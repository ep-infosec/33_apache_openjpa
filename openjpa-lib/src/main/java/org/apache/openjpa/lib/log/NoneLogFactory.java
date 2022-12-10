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
package org.apache.openjpa.lib.log;

/**
 * A log factory implementation that does not do any logging, as
 * quickly as possible.
 *
 * @author Patrick Linskey
 */
public class NoneLogFactory implements LogFactory {

    @Override
    public final Log getLog(String channel) {
        return NoneLog.getInstance();
    }

    /**
     * No-op log.
     */
    public static class NoneLog implements Log {

        private static final NoneLog s_log = new NoneLog();

        public static NoneLog getInstance() {
            return s_log;
        }

        @Override
        public final boolean isErrorEnabled() {
            return false;
        }

        @Override
        public final boolean isFatalEnabled() {
            return false;
        }

        @Override
        public final boolean isInfoEnabled() {
            return false;
        }

        @Override
        public final boolean isTraceEnabled() {
            return false;
        }

        @Override
        public final boolean isWarnEnabled() {
            return false;
        }

        @Override
        public final void trace(Object o) {
        }

        @Override
        public final void trace(Object o, Throwable t) {
        }

        @Override
        public final void info(Object o) {
        }

        @Override
        public final void info(Object o, Throwable t) {
        }

        @Override
        public final void warn(Object o) {
        }

        @Override
        public final void warn(Object o, Throwable t) {
        }

        @Override
        public final void error(Object o) {
        }

        @Override
        public final void error(Object o, Throwable t) {
        }

        @Override
        public final void fatal(Object o) {
        }

        @Override
        public final void fatal(Object o, Throwable t) {
        }
    }
}

