package sdntest


import org.junit.Test

import org.springframework.test.context.junit4.{SpringJUnit4ClassRunner, AbstractJUnit4SpringContextTests}
import org.springframework.test.context.ContextConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.junit.runner.RunWith


@ContextConfiguration(locations = Array("classpath*:/META-INF/spring/module-context.xml"))
@RunWith(classOf[SpringJUnit4ClassRunner])
class SDNTest extends AbstractJUnit4SpringContextTests {
  @Autowired private var nodeRepository: NodeRepository = null

  @Test
  def persist {
    val node = new Node()
    //nodeRepository.save(node)
    node.persist()
  }

}


