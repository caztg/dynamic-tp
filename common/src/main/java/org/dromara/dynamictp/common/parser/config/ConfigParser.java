/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.dynamictp.common.parser.config;

import org.dromara.dynamictp.common.em.ConfigFileTypeEnum;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * ConfigParser related
 *
 * @author yanhom
 * @since 1.0.0
 **/
public interface ConfigParser {

    /**
     * Judge type.
     *
     * @param type config file type
     * @return true if the parse supports this type, else false
     */
    boolean supports(ConfigFileTypeEnum type);

    /**
     * Type: yaml, properties...
     *
     * @return the parse supports types.
     */
    List<ConfigFileTypeEnum> types();

    /**
     * Parse content.
     *
     * @param content content
     * @return k-v properties
     * @throws IOException if occurs error while parsing
     */
    Map<Object, Object> doParse(String content) throws IOException;

    /**
     * Parse content.
     *
     * @param content content
     * @param prefix key prefix
     * @return k-v properties
     * @throws IOException if occurs error while parsing
     */
    Map<Object, Object> doParse(String content, String prefix) throws IOException;
}
