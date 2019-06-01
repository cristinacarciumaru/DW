package Repo;

import common.DataKey;
import common.Values;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends CassandraRepository<Values, DataKey> {

    List<Values> findByKeyFirstName(final String firstName);

    List<Values> findByKeyIDAndKeyValesINT(
            final String id, final int values_int);

    // Don't do this!!
    @Query(allowFiltering = true)
    List<Values> findID(final String id);

}