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
package org.apache.openjpa.persistence.embed;

import java.io.Serializable;

public class FeatureIdXml implements Serializable {
	
    private static final long serialVersionUID = 1L;
    private String oid;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int feanum) {
		this.index = feanum;
	}

	@Override
    public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other instanceof FeatureIdXml) {
			FeatureIdXml castOther = (FeatureIdXml) other;
			return getIndex() == castOther.getIndex()
					&& getOid().equals(castOther.getOid());
		}
		return false;
	}

	@Override
    public int hashCode() {
		return getIndex() + getOid().hashCode();
	}

	@Override
    public String toString() {
		return getOid() + "#" + getIndex();
	}

	public FeatureIdXml() {
	}

    public FeatureIdXml(int idx, String oid) {
        index = idx;
        this.oid = oid;
    }
}
