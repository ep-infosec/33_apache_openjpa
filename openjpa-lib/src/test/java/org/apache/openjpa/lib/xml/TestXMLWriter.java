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
package org.apache.openjpa.lib.xml;

import java.io.InputStreamReader;
import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.openjpa.lib.util.StringUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Tests the {@link XMLWriter} by comparing the results of passing the
 * raw-source.xml file in this package through the writer to the correct
 * output in the formatted-result.xml file, also in this package.
 *
 * @author Abe White
 */
public class TestXMLWriter {

    /**
     * Tests the formatting works.
     */
    @Test
    public void testPrettyPrint() throws Exception {
        // get the raw xml from a file
        StreamSource source = new StreamSource
            (getClass().getResourceAsStream("raw-source.xml"));

        // and write the formatted result to a string
        StringWriter formatted = new StringWriter();
        StreamResult result = new StreamResult(new XMLWriter(formatted));

        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.transform(source, result);

        // read the correct output into a buffer
        StringBuilder correct = new StringBuilder();
        InputStreamReader reader = new InputStreamReader
            (getClass().getResourceAsStream("formatted-result.xml"));
        for (int c; (c = reader.read()) != -1; correct.append((char) c)) ;

        // assertTrue the formatted result and buffer are equal
        assertEquals(fixNewline(correct.toString().trim()),
            fixNewline(formatted.toString().trim()));
    }

    private String fixNewline(String str) {
        return StringUtil.join(StringUtil.split(str, "\r\n", -1), "\n");
    }

}
