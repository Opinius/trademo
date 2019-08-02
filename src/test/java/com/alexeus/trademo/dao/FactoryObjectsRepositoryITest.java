package com.alexeus.trademo.dao;

import com.alexeus.trademo.domain.FactoryObject;
import com.alexeus.trademo.domain.ObjectType;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureEmbeddedDatabase
public class FactoryObjectsRepositoryITest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FactoryObjectsRepository repository;

    @Test
    public void whenFindById_thenReturnFactoryObject() {
        // given
        final String objectName = "objectName";
        ObjectType type = new ObjectType();
        type.setName("type1");
        ObjectType persistedType = entityManager.persist(type);
        FactoryObject obj = new FactoryObject();
        obj.setType(persistedType);
        obj.setName(objectName);
        final FactoryObject persistedObject = entityManager.persist(obj);
        entityManager.flush();

        // when
        FactoryObject found = repository.findById(persistedObject.getId()).orElseThrow(RuntimeException::new);

        // then
        assertEquals(found.getName(), objectName);
    }
}
