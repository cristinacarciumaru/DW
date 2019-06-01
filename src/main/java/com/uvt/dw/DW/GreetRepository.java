package com.uvt.dw.DW;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import java.util.UUID;
public interface GreetRepository extends CassandraRepository<Greeting,Object> {
    @Query("SELECT*FROM greetings WHERE user=?0 LIMIT ?1")
    Iterable<Greeting> findByUser(String user,Integer limit);
    @Query("SELECT*FROM greetings WHERE user=?0 AND id<?1 LIMIT ?2")
    Iterable<Greeting> findByUserFrom(String user,UUID from,Integer limit);

    @Query("SELECT*FROM asset")
    Iterable<Greeting> selectAsset();

    @Query("SELECT*FROM attribute ")
    Iterable<Greeting> selectAttribute();

    @Query("CREATE TABLE IF NOT EXISTS greetings (user text,id timeuuid, greet text,creation_date timestamp,   PRIMARY KEY (user, id)) WITH CLUSTERING ORDER BY (id DESC); ")
    Iterable<Greeting> createTable();

    @Query(value = "create table if not exists asset (   id text,  system_time timestamp, values_blob map<text, blob>,   values_boolean map<text, boolean>,  values_double map<text, double>, values_int map<text, int>, values_text map<text, text>,  values_timestamp map<text, timestamp>,   primary key (id, system_time) ) with clustering order by (system_time desc)and caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'}  and compaction = {'max_threshold': '32', 'min_threshold': '4', 'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy'}  and compression = {'class': 'org.apache.cassandra.io.compress.LZ4Compressor', 'chunk_length_in_kb': '64'} and dclocal_read_repair_chance = 0.1;")
    Iterable<Greeting> createAssetTable();


    @Query("create table if not exists attribute (  id text, system_time timestamp, data_type int, description text,  name text, primary key (id, system_time)) with clustering order by (system_time desc) and caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'} and compaction = {'max_threshold': '32', 'min_threshold': '4', 'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy'} and compression = {'class': 'org.apache.cassandra.io.compress.LZ4Compressor', 'chunk_length_in_kb': '64'} and dclocal_read_repair_chance = 0.1;\n")
    Iterable<Greeting> createAttributeTable();
}