/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.security.config.provisioning;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Rob Winch
 * @since 5.0
 */
@RunWith(SpringRunner.class)
public class UserDetailsManagerResourceFactoryBeanPropertiesResourceLocationITests {

	@Autowired
	UserDetailsManager users;

	@Test
	public void loadUserByUsernameWhenUserFoundThenNotNull() {
		assertThat(this.users.loadUserByUsername("user")).isNotNull();
	}

	@Configuration
	static class Config {

		@Bean
		public UserDetailsManagerResourceFactoryBean userDetailsService() {
			return UserDetailsManagerResourceFactoryBean.fromResourceLocation("classpath:users.properties");
		}

	}

}
