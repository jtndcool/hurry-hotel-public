package com.book.hurryhotels.configuration;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
public class DataBaseConfiguration {
	
	private static final Logger logger  = LoggerFactory.getLogger(DataBaseConfiguration.class);
	
	@Value("${hurryhotel.db.url}")
	private String dbUrl;
	
	@Value("${hurryhotel.db.username}")
	private String userName;
	
	@Value("${hurryhotel.db.password}")
	private String passWord;
	
	@Value("${hurryhotel.db.min.connections.per.partition}")
	private String minConnectionsPerPartition;
	
	@Value("${hurryhotel.db.max.connections.per.partition}")
	private String maxConnectionsPerPartition;
	
	@Value("${hurryhotel.db.partition.count}")
	private String count;
	
	@Value("${hurryhotel.db.driver.class}")
	private String driverClass;
	
	
	@Bean(name = "mappingDataSource")
	@Qualifier("mappingDataSource")
	public DataSource mappingDataSource() {
		
		BoneCPConfig boneCPConfig = new BoneCPConfig();
		boneCPConfig.setJdbcUrl(dbUrl);
		boneCPConfig.setUser(userName);
		boneCPConfig.setPassword(passWord);
		boneCPConfig.setMinConnectionsPerPartition(Integer.parseInt(minConnectionsPerPartition));
		boneCPConfig.setMaxConnectionsPerPartition(Integer.parseInt(maxConnectionsPerPartition));
		boneCPConfig.setPartitionCount(1);
		BoneCPDataSource boneCPDataSource = new BoneCPDataSource(boneCPConfig);
		boneCPDataSource.setDefaultAutoCommit(Boolean.TRUE);
		boneCPDataSource.setDriverClass("org.postgresql.Driver");
		
		return boneCPDataSource;
	}
	
	@Bean(name = "namedParameterJdbcTemplate")
	@Qualifier("namedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		logger.info("Trying to establish DB Connection...........................!");
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(mappingDataSource());
		logger.info("DB Connection successfully created........................!");
		return namedParameterJdbcTemplate;
	}

}
