package sdntest;


import org.junit.Test;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;


@ContextConfiguration(locations = {"classpath*:/META-INF/spring/module-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SDNTest extends AbstractJUnit4SpringContextTests {
  @Autowired private NodeRepository nodeRepository;

  @Test
  public void persist() {
    Node node = new Node();
    //nodeRepository.save(node)
    node.persist();
  }

}


