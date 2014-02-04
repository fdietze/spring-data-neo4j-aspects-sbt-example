package sdntest;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;


@NodeEntity
public class Node {
  @GraphId
  Long graphId;
}

