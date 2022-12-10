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
package org.apache.openjpa.persistence.kernel.common.apps;

import java.util.Set;

public interface ManagedInterface extends ManagedInterfaceSup {

    int getIntField();

    void setIntField(int i);

    ManagedInterfaceEmbed getEmbed();

    void setEmbed(ManagedInterfaceEmbed embed);

    ManagedInterface getSelf();

    void setSelf(ManagedInterface iface);

    Set getSetInteger();

    void setSetInteger(Set collection);

    Set getSetPC();

    void setSetPC(Set collection);

    Set getSetI();

    void setSetI(Set collection);

    RuntimeTest1 getPC();

    void setPC(RuntimeTest1 pc);

    void unimplemented();
}
