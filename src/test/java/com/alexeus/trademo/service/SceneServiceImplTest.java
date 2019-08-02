package com.alexeus.trademo.service;

import com.alexeus.trademo.dao.FactoryObjectsRepository;
import com.alexeus.trademo.dao.SceneObjectsRepository;
import com.alexeus.trademo.dao.ScenesRepository;
import com.alexeus.trademo.domain.Scene;
import com.alexeus.trademo.service.impl.SceneServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Component
public class SceneServiceImplTest {

    private static final int SCENE_ID = 111;
    private static final String SCENE_NAME = "defaultName";

    @TestConfiguration
    static class SceneServiceImplTestContextConfiguration {
        @MockBean
        private static ScenesRepository scenesRepository;
        @MockBean
        private static SceneObjectsRepository sceneObjectsRepository;
        @MockBean
        private static FactoryObjectsRepository factoryObjectsRepository;

        @Bean
        public SceneService sceneService() {
            return new SceneServiceImpl(scenesRepository, sceneObjectsRepository, factoryObjectsRepository);
        }
    }

    @Autowired
    private SceneService sceneService;

    @Before
    public void setUp() {
        Scene scene = new Scene();
        scene.setName(SCENE_NAME);

        Mockito.when(SceneServiceImplTestContextConfiguration.scenesRepository.findById(SCENE_ID))
                .thenReturn(Optional.of(scene));
    }

    @Test
    public void whenValidId_thenSceneShouldBeFound() {
        Scene found = sceneService.getScene(SCENE_ID);

        assertEquals(SCENE_NAME, found.getName());
    }
}
