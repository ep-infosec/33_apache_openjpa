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
package org.apache.openjpa.instrumentation;

import org.apache.openjpa.lib.instrumentation.AbstractInstrumentationProvider;
import org.apache.openjpa.lib.instrumentation.Instrument;

public class SecondProvider extends AbstractInstrumentationProvider {

    public static final String[] INSTRUMENT_ALIASES = {
        "DataCache", "org.apache.openjpa.instrumentation.DCInstrument",
        "QueryCache","org.apache.openjpa.instrumentation.QCInstrument",
        "QuerySQLCache","org.apache.openjpa.instrumentation.QSCInstrument"
    };

    @Override
    public void start() {
        setStarted(true);
    }

    @Override
    public void stop() {
        setStarted(false);
        for (Instrument inst : getInstruments()) {
           stopInstrument(inst);
        }
    }

    @Override
    public void startInstrument(Instrument instrument) {
        instrument.start();
    }

    @Override
    public void stopInstrument(Instrument instrument, boolean force) {
        instrument.stop();
    }

    @Override
    public String[] getInstrumentAliases() {
        return INSTRUMENT_ALIASES;
    }
}
