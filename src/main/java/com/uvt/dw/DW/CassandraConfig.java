package com.uvt.dw.DW;

import com.mongodb.lang.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.*;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {



    @Override
    public List<String> getStartupScripts() {
//        if(script==null) {
           String script = "create keyspace if not exists pop1 with durable_writes = true " +
                    "and replication = {'class': 'org.apache.cassandra.locator.SimpleStrategy', 'replication_factor': '2'};";
            System.out.println("=======================================================");
//        }

        return Arrays.asList(script);
    }

    @Value("${cassandra.contactpoints}")
    private String contactPoints;

    @Value("${cassandra.port}")
    private int port;

    @Value("${cassandra.keyspace}")
    private String keySpace;

    @Value("${cassandra.basePackages}")
    private String basePackages;

    @Value("${cassandra.username}")
    private String username;

    @Value("${cassandra.password}")
    private String password;



    @Override
    protected String getKeyspaceName() {
        return keySpace;
    }

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {basePackages};
    }


    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster =
                new CassandraClusterFactoryBean();
        cluster.setContactPoints(this.getContactPoints());
        cluster.setPort(this.getPort());
        cluster.setUsername(username);
        cluster.setPassword(password);
        return cluster;
    }

    @Bean
    public CassandraMappingContext cassandraMapping()
            throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }

}