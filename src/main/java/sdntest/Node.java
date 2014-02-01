package sdntest;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.repository.GraphRepository;


@NodeEntity
public class Node {
  @GraphId
  Long graphId;
}

interface NodeRepository extends GraphRepository<Node>{};
