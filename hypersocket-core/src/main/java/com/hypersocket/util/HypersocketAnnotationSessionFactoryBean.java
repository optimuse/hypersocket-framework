package com.hypersocket.util;

import com.hypersocket.cache.HypersocketCacheRegionFactoryServiceInitiator;
import org.hibernate.SessionFactory;
import org.hibernate.cache.spi.RegionFactory;
import org.hibernate.search.hcore.impl.HibernateSearchIntegrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class HypersocketAnnotationSessionFactoryBean extends
		LocalSessionFactoryBean{

	@Autowired Environment environment;
	
	private RegionFactory regionFactory;

	static Logger log = LoggerFactory.getLogger(HypersocketAnnotationSessionFactoryBean.class);
	
	@Override
	public void setPackagesToScan(String...packagesToScan) {

		PathMatchingResourcePatternResolver matcher = new PathMatchingResourcePatternResolver();
		ArrayList<String> finalPackages = new ArrayList<String>(Arrays.asList(packagesToScan));
		
		try {
			Resource[] packages = matcher.getResources("classpath*:hibernate-ext.properties");
		
			for(Resource r : packages) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(r.getInputStream()));
				
				try {
					String line;
					
					if(log.isInfoEnabled()) {
						log.info("Processing hibernate-ext.properties from " + r.getURI().toASCIIString());
					}
					while((line = reader.readLine())!=null) {
						line = line.trim();
						if(!line.startsWith("#")) {
							if(line.startsWith("scanPackage=")) {
								String pkgName = line.substring(12);
								if(log.isInfoEnabled()) {
									log.info("Will scan package " + pkgName);
								}
								finalPackages.add(pkgName + ".**");
							}
						}
					}
				} finally {
					reader.close();
				}
				
			}
		} catch (IOException e) {
		}
		
		
		super.setPackagesToScan(finalPackages.toArray(new String[0]));
	}
	
	@Override
	protected SessionFactory buildSessionFactory(LocalSessionFactoryBuilder sfb) {
		sfb.getStandardServiceRegistryBuilder().addInitiator(HypersocketCacheRegionFactoryServiceInitiator.INSTANCE);
		return super.buildSessionFactory(sfb);
	}
	
	@Override
	public void afterPropertiesSet() throws IOException {
		if(environment.getActiveProfiles() != null && Arrays.asList(environment.getActiveProfiles()).contains("HA")) {
			//needed to be done else default integrator from hibernate search will register everything before hypersocket search integrator
			getHibernateProperties().put(HibernateSearchIntegrator.AUTO_REGISTER, false);
		}
		getHibernateProperties().put("hibernate.cache.region.factory_class", regionFactory);
		super.afterPropertiesSet();
	}
	
	public RegionFactory getRegionFactory() {
		return regionFactory;
	}

	public void setRegionFactory(RegionFactory regionFactory) {
		this.regionFactory = regionFactory;
	}
}
