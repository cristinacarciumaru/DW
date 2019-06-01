package common;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Map;

@Data
@AllArgsConstructor
@Table("people_by_first_name")
public class Values {

    @PrimaryKey
    private DataKey key;
    
   @Column("id")
    private String id;

   @Column("system_time")
    private Timestamp system_time;

   @Column("values_blob")
    Map<String, Blob> values_blob;

   @Column("values_boolean")
    Map<String,Boolean> values_boolean;

   @Column("values_double")
    Map<String,Double> values_double;

   @Column("values_int")
    Map<String,Integer> values_int;

   @Column("values_text")
    Map<String,String> values_text;

   @Column("values_timestamp")
    Map<String, Timestamp> values_timestamp;
}
