package sdntest

import org.springframework.data.neo4j.annotation.GraphId
import org.springframework.data.neo4j.annotation.NodeEntity
import org.springframework.data.neo4j.repository.GraphRepository


@NodeEntity
class Node {
  @GraphId
  private var graphId: java.lang.Long = _
}

trait NodeRepository extends GraphRepository[Node]
