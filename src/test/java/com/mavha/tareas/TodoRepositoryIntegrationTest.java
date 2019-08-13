package com.mavha.tareas;

import com.mavha.tareas.entity.TodoEntity;
import com.mavha.tareas.entity.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void whenFindByDescription_thenReturnTodoList() {
        // given
        TodoEntity todoEntity =buildEntityPersistMock();

        // when
        List<TodoEntity> found = todoRepository.findByDescripcion(todoEntity.getDescripcion());

        // then
        assert(found.get(0).getDescripcion()
                .equals(todoEntity.getDescripcion()));
    }

    @Test
    public void whenFindByEstado_thenReturnTodoList() {
        // given
        TodoEntity todoEntity =buildEntityPersistMock();
        // when
        List<TodoEntity> found = todoRepository.findByDescripcion(todoEntity.getDescripcion());

        // then
        assert(found.get(0).getEstado()
                .equals(todoEntity.getEstado()));
    }

    private TodoEntity buildEntityPersistMock(){
        TodoEntity todoEntity = new TodoEntity("Tarea 1", "POR INICIAR", "image.jpg");
        entityManager.persist(todoEntity);
        entityManager.flush();
        return todoEntity;
    }

}
