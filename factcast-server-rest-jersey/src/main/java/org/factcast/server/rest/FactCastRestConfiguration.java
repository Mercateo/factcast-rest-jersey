/**
 * Copyright © 2018 Mercateo AG (http://www.mercateo.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.factcast.server.rest;

import org.factcast.server.rest.resources.FactsResource;
import org.factcast.server.rest.resources.FactsTransactionsResource;
import org.factcast.server.rest.resources.RootResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mercateo.common.rest.schemagen.link.LinkFactory;
import com.mercateo.common.rest.schemagen.link.LinkMetaFactory;
import com.mercateo.common.rest.schemagen.plugin.FieldCheckerForSchema;
import com.mercateo.common.rest.schemagen.plugin.MethodCheckerForLink;
import com.mercateo.rest.schemagen.spring.JerseyHateoasConfiguration;

/**
 * spring configuration class
 *
 */
@Configuration
@Import(JerseyHateoasConfiguration.class)
public class FactCastRestConfiguration {

    @Bean
    FieldCheckerForSchema fieldCheckerForSchema() {
        return (field, callContext) -> true;
    }

    @Bean
    MethodCheckerForLink methodCheckerForLink() {
        return (scope) -> true;
    }

    @Bean
    LinkFactory<RootResource> rootResourceLinkFactory(LinkMetaFactory linkMetaFactory) {
        return linkMetaFactory.createFactoryFor(RootResource.class);
    }

    @Bean
    LinkFactory<FactsTransactionsResource> transactionsResourceLinkFactory(
            LinkMetaFactory linkMetaFactory) {
        return linkMetaFactory.createFactoryFor(FactsTransactionsResource.class);
    }

    @Bean
    LinkFactory<FactsResource> factsResourceLinkFactory(LinkMetaFactory linkMetaFactory) {
        return linkMetaFactory.createFactoryFor(FactsResource.class);
    }
}
