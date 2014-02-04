package sdntest;

import org.springframework.data.neo4j.repository.GraphRepository;

interface NodeRepository extends GraphRepository<Node>{};
